package uta.cse3310;

import org.java_websocket.drafts.Draft_6455;

public class MainServer {

    public static void main(String[] args) {
        int port = Integer.parseInt(System.getenv().getOrDefault("HTTP_PORT", "8080"));

        // Start HTTP server
        HttpHandlerImpl httpHandler = new HttpHandlerImpl(port);
        httpHandler.startServer();

        // Start WebSocket server
        App webSocketServer = new App(port);
        webSocketServer.start();
        System.out.println("WebSocket server started on port: " + port);
    }
}
