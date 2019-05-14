use Sep4
 Go

 -- This trigger insert a row in the warning table if the status field is either LOW or HIGH 
ALTER TRIGGER [dbo].[HumidityWarningConfigureStatus]
ON [dbo].[humidity]
AFTER UPDATE
AS
BEGIN 
-- Declaring the variable s
	DECLARE @status AS VARCHAR(15)
	DECLARE @timeStamp AS DATETIME
	DECLARE @value AS float
	DECLARE @roomID AS INT
	DECLARE @type AS VARCHAR(10) = 'Humidity'
    DECLARE @date AS DATE
	-- assigning values 
	SELECT @status = status, @timeStamp = timestamp,@value = value,@roomID = room_id, @date = date 
	FROM Inserted
		-- checking the condition and inserting if true
	IF (@status = 'HIGH' OR @status = 'LOW')
		INSERT INTO dbo.warning (
	   [measurement_type]
      ,[status]
      ,[timestamp]
      ,[value]
      ,[room_id]
	  ,[date]) values (
	  @type,
	  @status,
	  @timeStamp,
	  @value,
	  @roomID, 
	  @date)
		


END
