package uta.cse3310;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PlayerTest extends TestCase {
    private Player player;

    public PlayerTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(PlayerTest.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // Initialize player with 
        player = new Player();
        player.setName("TestPlayer");
        player.setScore(0);
    }

    public void testConstructor() {
        // Test default constructor
        Player defaultPlayer = new Player();
        assertNotNull(defaultPlayer);
        assertEquals("", defaultPlayer.getName());
        assertEquals(0, defaultPlayer.getScore());
    }

    public void testConstructorWithParameters() {
        // Test parameterized constructor initialization
        Player paramPlayer = new Player("TestPlayer", 100);
        assertNotNull(paramPlayer);
        assertEquals("TestPlayer", paramPlayer.getName());
        assertEquals(100, paramPlayer.getScore());
        assertTrue(paramPlayer.isActivePlayers());
    }

    public void testSetName() {
        player.setName("NewName");
        assertEquals("NewName", player.getName());
    }

    public void testSetScore() {
        player.setScore(100);
        assertEquals(100, player.getScore());
    }

    public void testAddPoints() {
        player.addPoints(50);
        assertEquals(50, player.getScore());
    }

    public void testResetPoints() {
        player.setScore(100);
        player.resetPoints();
        assertEquals(0, player.getScore());
    }

    public void testUpdateScore() {
        player.updateScore(50);
        assertEquals(50, player.getScore());
    }

    public void testIsActivePlayers() {
        assertFalse(player.isActivePlayers());
    }

    public void testSetActivePlayer() {
        player.setActivePlayer(false);
        assertFalse(player.isActivePlayers());
    }
}