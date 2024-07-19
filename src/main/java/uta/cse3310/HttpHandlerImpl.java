package uta.cse3310;

public class HttpHandlerImpl implements HttpHandler {

    private int httpPort;
    private int websocketPort;

public HttpHandlerImpl(int httpPort) {
        this.httpPort = httpPort;
        this.websocketPort = httpPort + 100; // WebSocket port is HTTP port + 100
    }

 
public void startServer() {
      //Implement 
}

/**
 * Handles client requests to the server.
 * 
 */

  public void handle(){
          //Implement 
  }

  public void broadcastMessage(String message) {
        // Implementation  added later
  }
}


  
