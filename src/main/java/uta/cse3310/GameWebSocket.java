package uta.cse3310;

import java.net.InetSocketAddress;
import org.java_websocket.server.WebSocketServer;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.WebSocket;

public class GameWebSocket extends WebSocketServer {

    public GameWebSocket(int groupNumber) {
        super(new InetSocketAddress(9100 + groupNumber));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        System.out.println("New connection opened: " + conn.getRemoteSocketAddress());
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println("Message received: " + message);
        // Handle message logic
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.out.println("Connection closed: " + conn.getRemoteSocketAddress() + ", Reason: " + reason);
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

    public static void main(String[] args) {
        int groupNumber = Integer.parseInt(System.getenv().getOrDefault("GROUP_NUMBER", "3")); // Default to group 3
        GameWebSocket server = new GameWebSocket(groupNumber);
        server.start();
        System.out.println("WebSocket server started on port: " + (9100 + groupNumber));
    }
}
