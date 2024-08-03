package uta.cse3310;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class GameServerTest {

    private GameServer gameServer;
    private Player player1;
    private Player player2;

    @BeforeEach
    public void setUp() {
        gameServer = new GameServer();
        player1 = new Player("Hannah");
        player2 = new Player("Montanna");
        gameServer.addPlayer(player1);
        gameServer.addPlayer(player2);
        gameServer.createSession();
    }
/*
    -- We need to look at this--
    @Test
    public void testStartGame() {
        gameServer.startGame();

        assertNotNull(gameServer);
    }
 */
    @Test
    public void testEndGame() {
        gameServer.endGame();
    }

    @Test
    public void testHandlePlayerAction() {
        gameServer.handlePlayerAction(player1.getId(), "spinWheel");
        
    }

    @Test
    public void testBroadcastGameState() {
        gameServer.broadcastGameState(gameServer.getSessionId());
    }
    
    @Test
    public void testAddPlayers() {
        Player newPlayer = new Player("Alice");
        gameServer.addPlayer(newPlayer);
        List<Player> players = gameServer.getPlayer();
        assertTrue(players.contains(newPlayer));
    }

    @Test
    public void testRemovePlayers() {
        gameServer.removePlayer(player1.getId());
        List<Player> players = gameServer.getPlayer();
        assertFalse(players.contains(player1));
    }

    @Test
    public void testCreateSession() {
        gameServer.createSession();
        int sessionId = gameServer.getSessionId();
        assertNotNull(sessionId);
    }
}