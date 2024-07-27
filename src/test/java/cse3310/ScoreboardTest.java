/*package uta.cse3310;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ScoreboardTest {

    private Scoreboard scoreboard;

    @Before
    public void setUp() {
        scoreboard = new Scoreboard();
    }

    @Test
    public void testUpdateScoreNewPlayer() {
        scoreboard.updateScore("Hannah", 10);
        int score = scoreboard.getScore("Hannah");
        assertEquals(10, score);
    }

    @Test
    public void testUpdateScoreExistingPlayer() {
        scoreboard.updateScore("Hannah", 10);
        scoreboard.updateScore("Hannah", 5);
        int score = scoreboard.getScore("Hannah");
        assertEquals(15, score);
    }

    @Test
    public void testGetScoreNonExistentPlayer() {
        int score = scoreboard.getScore("Montana");
        assertEquals(0, score);
    }

    @Test
    public void testUpdateScoreMultiplePlayers() {
        scoreboard.updateScore("Hannah", 10);
        scoreboard.updateScore("Montana", 5);
        int scoreHannah = scoreboard.getScore("Hannah");
        int scoreMontana = scoreboard.getScore("Montana");
        assertEquals(10, scoreHannah);
        assertEquals(5, scoreMontana);
    }
}
*/