use Sep4_GroupX2
 Go


CREATE TRIGGER [dbo].[HumidityConfigureStatus]
ON [dbo].[humidity]
AFTER INSERT
AS
BEGIN 
	DECLARE @status AS varchar(15)
	DECLARE @max AS INT = 35
	DECLARE @min AS INT = 0
	DECLARE @originalValue AS INT

	UPDATE Co2 SET status = 'NORMAL'
		WHERE Co2.id IN (SELECT id FROM Inserted)
	SELECT @status = status
	FROM Inserted
	
	SELECT @originalValue = value
	FROM Inserted
	IF (@originalValue  > 50)
		UPDATE [humidity]
		SET status = 'HIGH'
		WHERE [humidity].id IN (SELECT id FROM Inserted) 
		ELSE IF(@originalValue  < 10)
		UPDATE [humidity]
		SET status = 'LOW'
		WHERE [humidity].id IN (SELECT id FROM Inserted)
		


END
