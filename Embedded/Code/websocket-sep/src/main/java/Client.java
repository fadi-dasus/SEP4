import java.io.StringReader;
import java.net.URI;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;


@ClientEndpoint
public class Client {
	
	// dont this it s needed when if we dont send message back
	Session userSession = null;

	public Client(URI endpointURI) {
		try {
            WebSocketContainer container = ContainerProvider
                    .getWebSocketContainer();
            container.connectToServer(Client.class, endpointURI);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @OnOpen
    public void onOpen(Session userSession) {
        this.userSession = userSession;
    }
 
    @OnClose
    public void onClose(Session userSession, CloseReason reason) {
        this.userSession = null;
    }
    @OnMessage
    public void onMessage(String message) {
        // send to mongodb
    	System.out.println(message);
    	JsonObject jsonObject = Json.createReader(new StringReader(message)).readObject();
    	String EUI = jsonObject.getString("EUI");
    	String timestamp = jsonObject.getString("timestamp");
    	String data = jsonObject.getString("data");
    	//String EUI = jsonObject.getString("EUI");
    	//String EUI = jsonObject.getString("EUI");
    	
    	
    	MongoDBConnection db = new MongoDBConnection();
    	db.insertMeasurement(EUI, timestamp, data, data, data);
    	db.closeConnection();
    	db = null;
    }
 
}