package websocket;

import java.util.Date;

import org.bson.Document;

public class LoRaMessage {

	private String cmd;
	private String EUI;
	private String data;
	private int timestamp;
	
	public Document transformToMongo() {
			
		if(!cmd.equals("rx"))
			return null;
		
		
		return new Document("UIE", EUI)
				.append("Room", 1)	// change room to room id from sql server
				.append("Name", "RAND_NAME")
				.append("Timestamp", new Date(timestamp))
				.append("CO2", getCO2())
				.append("Humidity", getHum())
				.append("Temperature", getTemp());			
	}

	
	public String getHum() {
		return Integer.parseUnsignedInt(data.substring(0, 4), 16)+"";
	}
	
	public String getTemp() {
		return Integer.parseUnsignedInt(data.substring(4, 8), 16)+"";
	}
	
	public String getCO2() {
		return Integer.parseUnsignedInt(data.substring(8, 12), 16)+"";
	}
}
