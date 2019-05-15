package websocket;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.bson.Document;

import com.google.gson.Gson;

import mongodb.MongoDbHandler;
import sqlServer.SQLDatabaseConnection;


public class LoRaClient implements WebSocket.Listener {

	private MongoDbHandler mongoHandler;
	private Gson gson;
	private SQLDatabaseConnection sql;
	
    @SuppressWarnings("unused")
	public LoRaClient() {
        HttpClient client = HttpClient.newHttpClient();
        CompletableFuture<WebSocket> ws = client.newWebSocketBuilder()
                .buildAsync(URI.create("wss://iotnet.teracom.dk/app?token=vnoRdgAAABFpb3RuZXQudGVyYWNvbS5kawxTf4lxpFpToHDb5b5vLKk="), this);
//                .buildAsync(URI.create("wss://iotnet.teracom.dk/app?token=vnoRLgAAABFpb3RuZXQudGVyYWNvbS5kazamWO1sXD3jq2ov9DGJBNA="), this);
        
        // mongo connection
        mongoHandler = new MongoDbHandler();
        gson = new Gson();
        
        // sql connection
		sql = new SQLDatabaseConnection();
    }
    //onOpen()
    public void onOpen(WebSocket webSocket) {
        // This WebSocket will invoke onText, onBinary, onPing, onPong or onClose methods on the associated listener (i.e. receive methods) up to n more times
        webSocket.request(1);
        System.out.println("WebSocket Listener has been opened for requests.");
    }

    //onError()
    public void onError(WebSocket webSocket, Throwable error) {
        System.out.println("A " + error.getCause() + " exception was thrown.");
        System.out.println("Message: " + error.getLocalizedMessage());
        webSocket.abort();
    };
    //onClose()
    public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
        System.out.println("WebSocket closed!");
        System.out.println("Status:" + statusCode + " Reason: " + reason);
        return null; //new CompletableFuture().completedFuture("onClose() completed.").thenAccept(System.out::println);
    };
    //onPing()
    public CompletionStage<?> onPing(WebSocket webSocket, ByteBuffer message) {
        webSocket.request(1);
        System.out.println("Ping: Client ---> Server");
        System.out.println(message.asCharBuffer().toString());
        return null; // new CompletableFuture().completedFuture("Ping completed.").thenAccept(System.out::println);
    };
    //onPong()
    public CompletionStage<?> onPong(WebSocket webSocket, ByteBuffer message) {
        webSocket.request(1);
        System.out.println("Pong: Client ---> Server");
        System.out.println(message.asCharBuffer().toString());
        return null; // new CompletableFuture().completedFuture("Pong completed.").thenAccept(System.out::println);
    };
    //onText()
    public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
        System.out.println(data);
    	LoRaMessage message = gson.fromJson(data.toString(), LoRaMessage.class);
    	Document doc = message.transformToMongo(sql);
    	if(doc != null)
    		mongoHandler.insertDoc(doc);
    	//System.out.println(message.toString());
    	webSocket.request(1);
        return null; // new CompletableFuture().completedFuture("onText() completed.").thenAccept(System.out::println);
    };
}
