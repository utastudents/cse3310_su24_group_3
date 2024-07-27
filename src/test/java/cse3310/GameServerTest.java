/*package uta.cse3310;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class GameServerTest {

    private GameServer gameServer;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        gameServer = new GameServer();
        player1 = new Player("Hannah");
        player2 = new Player("Montanna");
        gameServer.addPlayers(player1);
        gameServer.addPlayers(player2);
        gameServer.createSession();
    }

    @Test
    public void testStartGame() {
        gameServer.startGame();
        // add asssertions to verify game stasrt logic
        assertNotNull(gameServer);
    }

    @Test
    public void testEndGame() {
        gameServer.endGame();
        // make sure game ends correctly
        // might need check state 
    }

    @Test
    public void testHandlePlayerAction() {
        gameServer.handlePlayerAction(player1.getId(), "spinWheel");
        // mke sure action was handled correctly
    }

    @Test
    public void testBroadcastGameState() {
        gameServer.broadcastGameState(gameServer.getSessionId());
    }

    @Test
    public void testAddPlayers() {
        Player newPlayer = new Player("Alice");
        gameServer.addPlayers(newPlayer);
        List<Player> players = gameServer.getPlayers();
        assertTrue(players.contains(newPlayer));
    }

    @Test
    public void testRemovePlayers() {
        gameServer.removePlayers(player1.getId());
        List<Player> players = gameServer.getPlayers();
        assertFalse(players.contains(player1));
    }

    @Test
    public void testCreateSession() {
        gameServer.createSession();
        int sessionId = gameServer.getSessionId();
        assertNotNull(sessionId);
    }
}
*/