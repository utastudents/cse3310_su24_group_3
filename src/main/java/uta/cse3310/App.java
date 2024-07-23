package uta.cse3310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.time.Instant;
import java.util.Collections;

import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App extends WebSocketServer {

  // All games currently underway on this server are stored in
  // the vector ActiveGames
  private Vector<String> ActiveGames;

  private int GameId;

  private int connectionId;

  private Instant startTime;


  public App(int port) {
    super(new InetSocketAddress(port));
  }

  public App(InetSocketAddress address) {
   super(address);
  }

  public App(int port, Draft_6455 draft) {
    super(new InetSocketAddress(port), Collections.<Draft>singletonList(draft));
  }

  @Override
  public void onOpen(WebSocket conn, ClientHandshake handshake) 
  {
    System.out.println(conn.getRemoteSocketAddress().getAddress().getHostAddress()+ " connected");
  }

  @Override
  public void onClose(WebSocket conn, int code, String reason, boolean remote) 
  {
  System.out.println(conn + " has closed");
  }

  @Override
  public void onMessage(WebSocket conn, String message) 
  {

  }

  @Override
  public void onMessage(WebSocket conn, ByteBuffer message)
  {

  }

  @Override
  public void onError(WebSocket conn, Exception ex)
  {
    ex.printStackTrace();
    if(conn != null){
      // some errors like port binding faild may not be assignable to a specifif websocket
    }
  }

  @Override
  public void onStart() 
  {
    System.out.println("server started");
    setConnectionLostTimeout(0);
  }

  public static void main(String[] args) 
  {
    int port = 9003;
    HttpServer H = new HttpServer(port, "./html");
    H.start();
    System.out.println("http server started on port: 9003");
    // create and start websocket server
    port =9003;
    App A = new App(port+100);
    A.start();
    System.out.println("Websocket Server started on port: " + (port +100)  );
  }
}
