package uta.cse3310;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameStateTest {

    private GameState gameState;
    private Player player1;
    private Player player2;

    @BeforeEach
    public void setUp() {
        gameState = new GameState();
        player1 = new Player("Hannah");
        player2 = new Player("Montana");
    }

    @Test
    public void testSetAndGetPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        gameState.setPlayers(players);
        assertEquals(players, gameState.getPlayer());
    }

    @Test
    public void testSetAndGetCurrentWord() {
        gameState.setCurrentWord("example");
        assertEquals("example", gameState.getCurrentWord());
    }

    @Test
    public void testSetAndGetGuessedLetters() {
        List<String> guessedLetters = new ArrayList<>();
        guessedLetters.add("e");
        guessedLetters.add("x");
        gameState.setGuessedLetters(guessedLetters);
        assertEquals(guessedLetters, gameState.getGuessedLetters());
    }

    @Test
    public void testSetAndGetCurrentRound() {
        gameState.setCurrentRound(2);
        assertEquals(2, gameState.getCurrentRound());
    }

    @Test
    public void testRestartGameState() {
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        gameState.setPlayers(players);
        gameState.setCurrentWord("example");
        List<String> guessedLetters = new ArrayList<>();
        guessedLetters.add("e");
        guessedLetters.add("x");
        gameState.setGuessedLetters(guessedLetters);
        gameState.setCurrentRound(2);

        gameState.restartGameState();

        assertNull(gameState.getPlayer());
        assertEquals("", gameState.getCurrentWord());
        assertTrue(gameState.getGuessedLetters().isEmpty());
        assertEquals(0, gameState.getCurrentRound());
    }
}
