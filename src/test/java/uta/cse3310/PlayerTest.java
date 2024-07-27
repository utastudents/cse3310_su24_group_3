package uta.cse3310;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.List;

public class PlayerTest extends TestCase {

    public PlayerTest(String name) {
        super(name);
    }

    protected void setUp() {
        // Clear the player list before each test
        Player.clearPlayerList();
    }

    public void testPlayerCreation() {
        Player player = new Player("Alice");
        assertEquals("Alice", player.getName());
        assertEquals(1, player.getId());
        assertTrue(player.isActivePlayer());
        assertEquals(0, player.getScore());
    }

    public void testVerifyName() {
        Player player1 = new Player("Bob");
        Player player2 = new Player("Charlie");
        assertTrue(player1.verifyName("Bob"));
        assertFalse(player2.verifyName("Bob"));  // Bob already exists -T
        assertTrue(player2.verifyName("Dave"));  // Dave does not exist -F
    }

    public void testSetName() {
        Player player = new Player("Eve");
        player.setName("Eva");
        assertEquals("Eva", player.getName()); // should be true
    }

    public void testRemovePlayer() {
        Player player1 = new Player("Frank");// new players
        Player player2 = new Player("Grace");
        assertEquals(2, Player.getPlayerList().size()); // check if the 2nd player was hadded
        player1.removePlayer(player1.getId()); // removes Frank
        assertEquals(1, Player.getPlayerList().size());
        assertEquals("Grace", Player.getPlayerList().get(0).getName());
        player2.removePlayer(player1.getId());
        assertEquals(2, Player.getPlayerList().size());
    }

    public void testSetAndGetPlayerOrder() {
        Player player = new Player("Henry");
        player.setPlayerOrder(PlayerType.ONE);
        assertEquals(PlayerType.ONE, player.getPlayerOrder());
    }

    public void testSetAndGetScore() {
        Player player = new Player("Isla");
        player.setScore(50);
        assertEquals(50, player.getScore());
    }

    public void testAddPoints() {
        Player player = new Player("Jack");
        player.addPoints(20);
        assertEquals(20, player.getScore());
    }

    public void testResetPoints() {
        Player player = new Player("Kara");
        player.addPoints(50);
        player.resetPoints();
        assertEquals(0, player.getScore());
    }

    public void testUpdateScore() {
        Player player = new Player("Liam");
        player.updateScore(100);
        assertEquals(100, player.getScore());
    }

    public void testSetAndIsActivePlayer() {
        Player player = new Player("Mia");
        player.setActivePlayer(false);
        assertFalse(player.isActivePlayer());// shoud return false
    }

    public void testBuyVowel() {
        Player player = new Player("Nina");
        List<String> words = new ArrayList<>();
        words.add("apple");
        words.add("banana");
        List<String> updatedWords = player.buyVowel('a', words);
        assertEquals("pple", updatedWords.get(0));
        assertEquals("bnn", updatedWords.get(1));
    }

    public void testChooseConsonant() {
        Player player = new Player("Oscar");
        List<String> words = new ArrayList<>();
        words.add("cat");
        words.add("dog");
        List<String> updatedWords = player.chooseConsonant('c', words);
        assertEquals("at", updatedWords.get(0));
        assertEquals("dog", updatedWords.get(1));
    }

    public void testSolvePuzzle() {
        Player player = new Player("Paul");
        List<String> solution = new ArrayList<>();
        solution.add("hello");
        List<String> puzzle = new ArrayList<>();
        puzzle.add("hello");
        assertTrue(player.solvePuzzle(solution, puzzle));
        assertEquals(1000, player.getScore());
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite(PlayerTest.class);
        return suite;
    }
}
