use Sep4
 Go


ALTER TRIGGER [dbo].[HumidityWarningConfigureStatus]
ON [dbo].[humidity]
AFTER UPDATE
AS
BEGIN 
	DECLARE @status AS VARCHAR(15)
	DECLARE @timeStamp AS DATETIME
	DECLARE @value AS INT
	DECLARE @roomID AS INT
	DECLARE @type AS VARCHAR(10) = 'Humidity'
    DECLARE @date AS DATE

	SELECT @status = status, @timeStamp = timestamp,@value = value,@roomID = room_id, @date = date 
	FROM Inserted

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
