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
  private GameSession gameSession;

  private int connectionId =0;
  public String serverId; // serverID

  public App(int port ,String serverId) {
      super(new InetSocketAddress(port));
      gameSession = new GameSession(new InetSocketAddress(port+100));
      this.serverId =serverId;
  }

  public App(InetSocketAddress address) {
      super(address);
  }

  public App(int port, Draft_6455 draft) {
      super(new InetSocketAddress(port), Collections.<Draft>singletonList(draft));
  }

  @Override
  public void onOpen(WebSocket conn, ClientHandshake handshake) {
    connectionId++;
    System.out.println(conn.getRemoteSocketAddress().getAddress().getHostAddress() + " connected");
    ServerEvent E = new ServerEvent();
    gameSession.assignPlayerToSession(conn);
    conn.send("you are conneected to " + serverId);

  }

  @Override
  public void onClose(WebSocket conn, int code, String reason, boolean remote) {
      System.out.println(conn + " has closed");
      gameSession.removePlayerFromSession(conn);
  }

  @Override
  public void onMessage(WebSocket conn, String message) {
    gameSession.handleMessage(conn, message);
  }

  @Override
  public void onMessage(WebSocket conn, ByteBuffer message) {
  }

  @Override
  public void onError(WebSocket conn, Exception ex) {
      ex.printStackTrace();
      if (conn != null) {
          // some errors like port binding failed may not be assignable to a specific websocket
      }
  }

  @Override
  public void onStart() {
      System.out.println("server started");
      setConnectionLostTimeout(0);
      gameSession.start();
  }

  public static void main(String[] args) {
      int port = 9003;
      HttpServer H = new HttpServer(port, "HTML");
      H.start();
      System.out.println("http server started on port: 9003");
      // create and start websocket server
      port = 9003;
      App A = new App(port + 100,"Server 1");
      A.start();
      System.out.println("Websocket Server 1 started on port: " + (port + 100));
  }
}