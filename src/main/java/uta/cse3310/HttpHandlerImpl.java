package uta.cse3310;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HttpHandlerImpl implements HttpHandler {

    public HttpHandlerImpl(int httpPort) {
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


@Override
public void handle(HttpExchange exchange) throws IOException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'handle'");
}
}


  
