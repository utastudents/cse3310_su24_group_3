package uta.cse3310;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

public class HttpHandlerImpl implements HttpHandler {

    private HttpServer server;
    private int port;

    public HttpHandlerImpl(int httpPort) {
        this.port = httpPort;
    }

    public void startServer() {
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
            server.createContext("/", this);
            server.setExecutor(Executors.newFixedThreadPool(10)); // Creates a thread pool of 10 threads
            server.start();
            System.out.println("HTTP server started on port: " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "Server is up and running!";
        exchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);
        exchange.getResponseBody().write(response.getBytes(StandardCharsets.UTF_8));
        exchange.getResponseBody().close();
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(System.getenv().getOrDefault("HTTP_PORT", "8080"));
        HttpHandlerImpl httpHandler = new HttpHandlerImpl(port);
        httpHandler.startServer();
    }
}
