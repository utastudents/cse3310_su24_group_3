package uta.cse3310;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.server.WebSocketServer;

import static org.mockito.Mockito.*;

public class AppTest extends TestCase {
    private App app;
    private GameSession mockGameSession;
    private WebSocket mockSocket;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // Mock the GameSession and WebSocket
        mockGameSession = mock(GameSession.class);
        mockSocket = mock(WebSocket.class);

        // Initialize App with mock GameSession
        app = new App(9003, "TestServer") {
            @Override
            public void start() {
            }

            @Override
            public void onOpen(WebSocket conn, ClientHandshake handshake) {
                // Use the test GameSession
                mockGameSession.assignPlayerToSession(conn);
                conn.send("you are conneected to " + serverId);
            }

            @Override
            public void onClose(WebSocket conn, int code, String reason, boolean remote) {
                mockGameSession.removePlayerFromSession(conn);
            }

            @Override
            public void onMessage(WebSocket conn, String message) {
                mockGameSession.handleMessage(conn, message);
            }
        };
    }

    public void testOnOpen() {
        // start a connection
        app.onOpen(mockSocket, mock(ClientHandshake.class));

        // Verify that GameSession's assignPlayerToSession method is called
        verify(mockGameSession).assignPlayerToSession(mockSocket);
        // Verify that the connection received a welcome message
        verify(mockSocket).send("you are conneected to TestServer");
    }

    public void testOnClose() {
        // Simulate a disconnection
        app.onClose(mockSocket, 1000, "Normal closure", true);

        // Verify that GameSession's removePlayerFromSession method is called
        verify(mockGameSession).removePlayerFromSession(mockSocket);
    }

    public void testOnMessage() {
        String testMessage = "{\"type\": \"start_game_button\"}";
        // Simulate a message
        app.onMessage(mockSocket, testMessage);

        // Verify that GameSession's handleMessage method is called
        verify(mockGameSession).handleMessage(mockSocket, testMessage);
    }

    public void testOnError() {
        Exception testException = new Exception("Test exception");
        app.onError(mockSocket, testException);

        // Check that the exception is printed (you might need to capture the output)
        // This test may require more specific validation depending on your logging setup
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(AppTest.class);
        return suite;
    }
}
