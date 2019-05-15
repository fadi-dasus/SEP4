package websocket;

import java.util.Date;

import org.bson.Document;

import sqlServer.SQLDatabaseConnection;

public class LoRaMessage {

	private String cmd;
	private String EUI;
	private long ts;
	private String data;
	
	public Document transformToMongo(SQLDatabaseConnection sql) {
			
		if(!cmd.equals("rx"))
			return null;
		
		return new Document("UIE", EUI)
				.append("Room", sql.getRoomId(EUI))	// change room to room id from sql server
				.append("Name", "RAND_NAME")
				.append("Timestamp", new Date(ts))
				.append("CO2", getCO2())
				.append("Humidity", getHum())
				.append("Temperature", getTemp());			
	}

	
	public String getHum() {
		return (Integer.parseUnsignedInt(data.substring(0, 4), 16)/10)+"";
	}
	
	public String getTemp() {
		return (Integer.parseUnsignedInt(data.substring(4, 8), 16)/10)+"";
	}
	
	public String getCO2() {
		return Integer.parseUnsignedInt(data.substring(8, 12), 16)+"";
	}
	
	public String toString() {
		return "cmd: " + cmd + "\nEUI: " + EUI + "\nData: " + data + "\nts: " + ts; 
	}
}
