package uta.cse3310;

import java.util.List;

public class GameLogic {

    private List<Player> players;
    private int currentRound;
    private WordSource wordSource;
    private String currentWord;

    public void addPlayers(String name) {
        // Add player logic
    }

    public void startGame() {
        // Start game logic
    }

    public void advanceRound() {
        // Advance round logic
    }

    public void chooseNewWord() {
        currentWord = wordSource.chooseRandomWord();
    }

    public String getCurrentWord() {
        return currentWord;
    }

    void startRound() {
        // Start round logic
    }

    void endRound() {
        // End round logic
    }

    void playerAction(Player player, String action) {
        // Player action logic
    }
}
