package websocket;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class WebSocketHandler implements WebSocket.Listener {
	public CompletableFuture<WebSocket> ws;
	public WebSocket webSocket;
	
	public WebSocketHandler() {

		HttpClient client = HttpClient.newHttpClient();
		 ws = client.newWebSocketBuilder()
					//.buildAsync(URI.create("wss://app?token=vnoRdgAAABFpb3RuZXQudGVyYWNvbS5kawxTf4lxpFpToHDb5b5vLKk="), this);
			.buildAsync(URI.create("wss://iotnet.teracom.dk/app?token=vnoRdgAAABFpb3RuZXQudGVyYWNvbS5kawxTf4lxpFpToHDb5b5vLKk="), this);
			
	//wss:///app?id=BE7A1176&token=vnoRdgAAABFpb3RuZXQudGVyYWNvbS5kawxTf4lxpFpToHDb5b5vLKk=
	}
		
    // onOpen()
    public void onOpen(WebSocket webSocket) {

        // This WebSocket will invoke onText, onBinary, onPing, onPong or onClose methods on the associated listener (i.e. receive methods) up to n more times
        webSocket.request(1);
        System.out.println("WebSocket Listener has been opened for requests.");
        this.webSocket = webSocket;
    }

    // onError()
    public void onError​(WebSocket webSocket, Throwable error) {
        System.out.println("A " + error.getCause() + " exception was thrown.");
        System.out.println("Message: " + error.getLocalizedMessage());
        webSocket.abort();
    };
    
    // onClose()
    public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
        System.out.println("WebSocket closed!");
        System.out.println("Status:" + statusCode + " Reason: " + reason);
        return null; //new CompletableFuture().completedFuture("onClose() completed.").thenAccept(System.out::println);
    };
    
    // onPing()
    public CompletionStage<?> onPing​(WebSocket webSocket, ByteBuffer message) {
        webSocket.request(1);
        System.out.println("Ping: Client ---> Server");
        System.out.println(message.asCharBuffer().toString());
        return null; // new CompletableFuture().completedFuture("Ping completed.").thenAccept(System.out::println);
    };
    
    // onPong()
    public CompletionStage<?> onPong​(WebSocket webSocket, ByteBuffer message) {
        webSocket.request(1);
        System.out.println("Pong: Client ---> Server");
        System.out.println(message.asCharBuffer().toString());
        return null; // new CompletableFuture().completedFuture("Pong completed.").thenAccept(System.out::println);
    };
    
    // onText()
    public CompletionStage<?> onText​(WebSocket webSocket, CharSequence data, boolean last) {
    	System.out.println(data);
        
    	webSocket.request(1);
        return null; //new CompletableFuture().completedFuture("onText() completed.").thenAccept(System.out::println);
    };

	
}
