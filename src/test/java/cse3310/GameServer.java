package uta.cse3310;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GameServerTest {

    private GameServer gameServer;

    @Before
    public void setUp() {
        gameServer = new GameServer();
    }

    @Test
    public void testServerStart() {
        try {
            gameServer.start();
        } catch (Exception e) {
            fail("Server failed to start: " + e.getMessage());
        }
    }

    @Test
    public void testHandleClientRequest() {
        //IMPLEMENT
    }

    @Test
    public void testBroadcastMessage() {
        try {
            gameServer.broadcastMessage("Test message");
        } catch (Exception e) {
            fail("Broadcast message failed: " + e.getMessage());
        }
    }
}
