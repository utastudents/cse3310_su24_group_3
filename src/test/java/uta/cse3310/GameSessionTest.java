package uta.cse3310;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;


//import junit.framework.Test;
import junit.framework.TestCase;
//import junit.framework.TestSuite;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class GameSessionTest extends TestCase {
    private GameSession gameSession;
    private WebSocket mockSocket1;
    private WebSocket mockSocket2;
    private Player mockPlayer1;
    private Player mockPlayer2;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // Initialize the GameSession with a test address
        gameSession = new GameSession(new InetSocketAddress(9103));

        // Create mock WebSocket 
        mockSocket1 = mock(WebSocket.class);
        mockSocket2 = mock(WebSocket.class);

        // Create mock Player 
        mockPlayer1 = mock(Player.class);
        mockPlayer2 = mock(Player.class);
        
        // Create a mapping between WebSockets and Players
        gameSession.playerConnections.put(mockSocket1, mockPlayer1);
        gameSession.playerConnections.put(mockSocket2, mockPlayer2);
    }

    @Test
    public void testAssignPlayerToSession() {
        gameSession.assignPlayerToSession(mockSocket1);

        // make sure that the player was added to the session
        assertTrue(gameSession.sessions.size() > 0);
        GameSession.Session session = gameSession.sessions.get(0);
        assertTrue(session.hasPlayer(mockPlayer1));
    }

    @Test
    public void testRemovePlayerFromSession() {
        GameSession.Session session = gameSession.getAvailableSession();
        session.addPlayer(mockPlayer1);
        gameSession.removePlayerFromSession(mockSocket1);

        // ceck if they have been removed
        assertFalse(session.hasPlayer(mockPlayer1));
    }

    @Test
    public void testHandleNextRound() {
        GameSession.Session session = gameSession.getAvailableSession();
        session.addPlayer(mockPlayer1);
        session.addPlayer(mockPlayer2);

        session.nextRound();

        // Verify the next round message is broadcast
        verify(mockSocket1).send("{\"type\": \"next_round\", \"round\": 2}");
        verify(mockSocket2).send("{\"type\": \"next_round\", \"round\": 2}");
    }

    @Test
    public void testStartGame() {
        GameSession.Session session = gameSession.getAvailableSession();
        session.addPlayer(mockPlayer1);
        session.addPlayer(mockPlayer2);

        gameSession.startGame(session);

        // Verify that the start game message is sent to all players
        verify(mockSocket1).send("{\"type\": \"start_game\"}");
        verify(mockSocket2).send("{\"type\": \"start_game\"}");
    }

    @Test
    public void testHandleMessage() {
        String message = "{\"type\": \"start_game_button\"}";
        gameSession.handleMessage(mockSocket1, message);

        // Verify that the broadcast message is sent
        verify(mockSocket1).send("{\"type\": \"start_game\"}");
    }

//     @Test
//     public static Test suite() {
//         TestSuite suite = new TestSuite(GameSessionTest.class);
//         return suite;
//     }
 }
