use Sep4
 Go
 -- A trigger that detects Temperature vlaue and assign a status based on that value 
ALTER TRIGGER [dbo].[TemperatureConfigureStatus]
ON [dbo].[temperature]
AFTER INSERT
AS
BEGIN 
-- Declaring variables
	DECLARE @status AS varchar(15)
	DECLARE @max AS INT = 35
	DECLARE @min AS INT = 0
	DECLARE @originalValue AS INT
-- set the default value 
	UPDATE Co2 SET status = 'NORMAL'
		WHERE Co2.id IN (SELECT id FROM Inserted)

	SELECT @status = status
	FROM Inserted
	
	SELECT @originalValue = value
	FROM Inserted

-- update the default value based on the condition 
	IF (@originalValue  > 30)
		UPDATE [temperature]
		SET status = 'HIGH'
		WHERE [temperature].id IN (SELECT id FROM Inserted) 
		ELSE IF(@originalValue  < 0)
		UPDATE [temperature]
		SET status = 'LOW'
		WHERE [temperature].id IN (SELECT id FROM Inserted)
		


END
