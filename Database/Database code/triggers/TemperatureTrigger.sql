use Sep4
 Go


CREATE TRIGGER [dbo].[TemperatureConfigureStatus]
ON [dbo].[temperature]
AFTER INSERT
AS
BEGIN 
	DECLARE @status AS varchar(15)
	DECLARE @max AS INT = 35
	DECLARE @min AS INT = 0
	DECLARE @originalValue AS INT


	SELECT @status = status
	FROM Inserted
	
	SELECT @originalValue = value
	FROM Inserted
	IF (@originalValue  > 30)
		UPDATE [temperature]
		SET status = 'HIGH'
		WHERE [temperature].id IN (SELECT id FROM Inserted) 
		ELSE IF(@originalValue  < 0)
		UPDATE [temperature]
		SET status = 'LOW'
		WHERE [temperature].id IN (SELECT id FROM Inserted)
		


END
