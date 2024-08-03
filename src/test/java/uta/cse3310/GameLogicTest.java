package uta.cse3310;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameLogicTest {

    private GameLogic gameLogic;
    private WordSource wordSource;

    @BeforeEach
    public void setUp() {

        wordSource = new WordSource() {
            @Override
            public String chooseRandomWord() {
                return "testWord"; 
            }
        };
        gameLogic = new GameLogic(wordSource);
    }

    @Test
    public void testInitialization() {
        assertNotNull(gameLogic.getPlayers());
        assertEquals(0, gameLogic.getPlayers().size());
        assertNull(gameLogic.GetCurrentWord());
        
    }

    @Test
    public void testStartGame() {
        gameLogic.startGame();
        String currentWord = gameLogic.GetCurrentWord();
        assertEquals("testWord", currentWord);
    }

    @Test
    public void testAdvanceRound() {
        gameLogic.startGame(); // Initialize the game and round
        
        WordSource newWordSource = new WordSource() {
            @Override
            public String chooseRandomWord() {
                return "nextWord";
            }
        };
        gameLogic.setWordSource(newWordSource);
        gameLogic.advanceRound();

        String currentWord = gameLogic.GetCurrentWord();
        assertEquals("nextWord", currentWord);
        
    }

    @Test
    public void testGetCurrentWord() {
        gameLogic.startGame();
        
        String currentWord = gameLogic.GetCurrentWord();
        assertEquals("testWord", currentWord);
    }

    @Test
    public void testStartRound() {
        gameLogic.startRound();
    }

    @Test
    public void testEndRound() {
        gameLogic.endRound();
    }

    @Test
    public void testPlayerAction() {
        Player player = new Player("Player1");
        gameLogic.addPlayers(player);

        
        // This exampleis about player points change if action is "correct_guess"
        gameLogic.playerAction(player, "correct_guess");
    }

    @Test
    public void testGetGameState() {
        gameLogic.startGame();
        Player player1 = new Player("null");
        player1.setScore(100);
        gameLogic.addPlayers(player1);
        String expectedState = "Current round: 1\nCurrent Word: testWord\nPlayers:\n - null100points\n";
        assertEquals(expectedState, gameLogic.getGameState());
    }
}
