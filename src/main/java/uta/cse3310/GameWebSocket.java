//DRAFT*** comment to be removed when ready for turn in
package uta.cse3310;

import java.net.InetSocketAddress;
import org.java_websocket.server.WebSocketServer;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.WebSocket;

public class GameWebSocket extends WebSocketServer {


    
    public GameWebSocket(int port) {
        super(new InetSocketAddress(port));
    }

    @Override
    // Websocket session is opening
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        System.out.println("New connection opened: " + conn.getRemoteSocketAddress());
    }

    @Override
    // Incoming WebSocket messages
    public void onMessage(WebSocket conn, String message) {
        System.out.println("Message received: " + message);

        switch (message) {
            case "Start Game":
                //handle start game logic
                System.out.println(message);
                break;
            case "Next Round 1":
                //handle  Round 1 logic
                System.out.println(message);
                break;
            case "Next Round 2":
                //handle  Round 2 logic
                System.out.println(message);
                break;
            case "Next Round 3":
                //handle Round 3 logic
                System.out.println(message);
                break;
            case "Play again":
                //handle Round 3 logic
                System.out.println(message);
                break;
        
            default:
                System.out.println("Unknown message recived "+ message);
                break;
        }
    }

    @Override
    // WebSocket session is closing
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.out.println("Connection closed: " + conn.getRemoteSocketAddress() + ", Reason: " + reason);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
        if (conn != null) {
            System.out.println("Error occurred on connection " +conn.getRemoteSocketAddress());
        }
    }
    @Override
    public void onStart(){
        System.out.println("Websocket server started successfully");
    }

    public static void main(String[] args) {
        int defaultHttpPort =9003;
        int port = Integer.parseInt(System.getenv().getOrDefault("HTTP_PORT", String.valueOf(defaultHttpPort))) + 100; // Default port used as of
         System.out.println("Websocket server port: "+ port);
        GameWebSocket server = new GameWebSocket(port);
        // begin execution of thread
        server.start();
        System.out.println("WebSocket server started on port: " + port);
    }
}
