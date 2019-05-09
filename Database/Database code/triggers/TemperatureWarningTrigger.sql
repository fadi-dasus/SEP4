
Create TRIGGER [dbo].[TemperatureWarningConfigureStatus]
ON [dbo].[temperature]
AFTER UPDATE
AS
BEGIN 
	DECLARE @status AS VARCHAR(15)
	DECLARE @timeStamp AS DATETIME
	DECLARE @value AS INT
	DECLARE @roomID AS INT
	DECLARE @type AS VARCHAR(10) = 'Temperature'

	SELECT @status = status, @timeStamp = timestamp,@value = value,@roomID = room_id
	FROM Inserted

	IF (@status = 'HIGH' OR @status = 'LOW')
		INSERT INTO dbo.warning (
	   [measurement_type]
      ,[status]
      ,[time_stamp]
      ,[value]
      ,[room_id]) values (
	  @type,
	  @status,
	  @timeStamp,
	  @value,
	  @roomID)
		


END
