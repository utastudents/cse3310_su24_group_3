package uta.cse3310;

import java.util.HashMap;
import java.util.Map;

public class Scoreboard {
    private Map<Integer, Integer> scores;

    public Scoreboard() {
        scores = new HashMap<>();
    }

    public void updateScore(int playerId, int score) {
        scores.put(playerId, scores.getOrDefault(playerId, 0) + score);
    }

    public int getScore(int playerId) {
        return scores.getOrDefault(playerId, 0);
    }

    public void sortScores() {
        // Sort scores logic
    }
}
