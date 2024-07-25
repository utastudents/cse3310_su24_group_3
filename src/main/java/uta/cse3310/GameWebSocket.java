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
        int port = Integer.parseInt(System.getenv().getOrDefault("HTTP_PORT", "8080")) + 100; // Default port used as of
                                                                                              // now
        GameWebSocket server = new GameWebSocket(port);
        // begin execution of thread
        server.start();
        System.out.println("WebSocket server started on port: " + port);
    }
}