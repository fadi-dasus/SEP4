use Sep4
 Go

 -- A trigger that detects humidity vlaue and assign a status based on that value 
ALTER TRIGGER [dbo].[HumidityConfigureStatus]
ON [dbo].[humidity]
AFTER INSERT
AS
BEGIN 
-- Declaring variables
	DECLARE @status AS varchar(15)
	DECLARE @max AS float = 35
	DECLARE @min AS float = 0
	DECLARE @originalValue AS float
-- set the default value 
	UPDATE Co2 SET status = 'NORMAL'
		WHERE Co2.id IN (SELECT id FROM Inserted)
	SELECT @status = status
	FROM Inserted
	
	SELECT @originalValue = value
	FROM Inserted

-- update the default value based on the condition 
	IF (@originalValue  > 50)
		UPDATE [humidity]
		SET status = 'HIGH'
		WHERE [humidity].id IN (SELECT id FROM Inserted) 
		ELSE IF(@originalValue  < 10)
		UPDATE [humidity]
		SET status = 'LOW'
		WHERE [humidity].id IN (SELECT id FROM Inserted)
		


END
