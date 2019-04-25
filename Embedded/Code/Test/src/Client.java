import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;



//Client class is responsible for receiving measurements from Loriet server using a socket connection

public class Client
{

   private static final JsonElement takeCo2Measurement = null;
   private int port = 80;
   private Socket socket;
   private String ip = "";
   
   private DataOutputStream out;
   private DataInputStream in;
   
  
   Gson gson;

   public void connect()
   {

      try
      {
    	 
         socket = new Socket(ip, port);
         out = new DataOutputStream(socket.getOutputStream());
         in = new DataInputStream(socket.getInputStream());
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }

   

   public void get(Co2Measurement co2) throws Exception
   {

      in.read(gson.toJson(co2).getBytes(StandardCharsets.UTF_8));

   }

   // Closing the connection.

   public void disconnet()
   {
      try
      {
         out.close();
         in.close();
         socket.close();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }

}
