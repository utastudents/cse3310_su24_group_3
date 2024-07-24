
// This is example code provided to CSE3310 Fall 2022
// You are free to use as is, or changed, any of the code provided

// Please comply with the licensing requirements for the
// open source packages being used.

// This code is based upon, and derived from the this repository
//            https:/thub.com/TooTallNate/Java-WebSocket/tree/master/src/main/example

// http server include is a GPL licensed package from
//            http://www.freeutils.net/source/jlhttp/

/*
 * Copyright (c) 2010-2020 Nathan Rajlich
 *
 *  Permission is hereby granted, free of charge, to any person
 *  obtaining a copy of this software and associated documentation
 *  files (the "Software"), to deal in the Software without
 *  restriction, including without limitation the rights to use,
 *  copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the
 *  Software is furnished to do so, subject to the following
 *  conditions:
 *
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 *  OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 *  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 *  FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 *  OTHER DEALINGS IN THE SOFTWARE.
 */

 package uta.cse3310;

 import org.java_websocket.WebSocket;
 import org.java_websocket.drafts.Draft_6455;
 import org.java_websocket.handshake.ClientHandshake;
 import org.java_websocket.server.WebSocketServer;
 
 import com.google.gson.Gson;
 import com.google.gson.GsonBuilder;
 
 import java.net.InetSocketAddress;
 import java.nio.ByteBuffer;
 import java.time.Instant;
 import java.util.Vector;
 
 public class App extends WebSocketServer {
 
     // All games currently underway on this server are stored in
     // the vector ActiveGames
     private Vector<GameSession> ActiveGames;
     private int GameId;
     private int connectionId;
     private Instant startTime;
     private Gson gson;
 
     public App(int port) {
         super(new InetSocketAddress(port));
         this.ActiveGames = new Vector<>();
         this.GameId = 0;
         this.connectionId = 0;
         this.startTime = Instant.now();
         this.gson = new GsonBuilder().create();
     }
 
     @Override
     public void onOpen(WebSocket conn, ClientHandshake handshake) {
         System.out.println("New connection opened: " + conn.getRemoteSocketAddress());
     }
 
     @Override
     public void onClose(WebSocket conn, int code, String reason, boolean remote) {
         System.out.println("Connection closed: " + conn.getRemoteSocketAddress() + ", Reason: " + reason);
     }
 
     @Override
     public void onMessage(WebSocket conn, String message) {
         System.out.println("Message received: " + message);
         // Handle message logic
         Message msg = gson.fromJson(message, Message.class);
         // Process message based on type
         if (msg.type.equals("startGame")) {
             startGame(conn, msg);
         }
         // Add other message types as needed
     }
 
     @Override
     public void onMessage(WebSocket conn, ByteBuffer message) {
         System.out.println("ByteBuffer message received");
         // Handle ByteBuffer message logic
     }
 
     @Override
     public void onError(WebSocket conn, Exception ex) {
         ex.printStackTrace();
         if (conn != null) {
             System.out.println("Error occurred on connection " + conn.getRemoteSocketAddress());
         }
     }
 
     @Override
     public void onStart() {
         System.out.println("WebSocket server started successfully");
     }
 
     private void startGame(WebSocket conn, Message msg) {
         // Start game logic
         GameSession gameSession = new GameSession(new WordSource(), new GameLogic());
         ActiveGames.add(gameSession);
         gameSession.addPlayer(new Player(msg.playerName));
         // Notify client
         conn.send(gson.toJson(new Message("gameStarted", "Game started successfully", msg.playerName)));
     }
 
     public static void main(String[] args) {
         int port = Integer.parseInt(System.getenv().getOrDefault("HTTP_PORT", "8080"));
         App webSocketServer = new App(port);
         webSocketServer.start();
         System.out.println("WebSocket server started on port: " + port);
     }
 }
 
 class Message {
     String type;
     String content;
     String playerName;
 
     public Message(String type, String content, String playerName) {
         this.type = type;
         this.content = content;
         this.playerName = playerName;
     }
 }
 