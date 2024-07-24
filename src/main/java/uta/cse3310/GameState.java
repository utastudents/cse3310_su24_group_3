package uta.cse3310;

import java.util.List;

public class GameState {
    private List<Player> players;
    private String currentWord;
    private List<String> guessedLetters;
    private int currentRound;
    private int maxRound;

    public GameState() {
        // Initialize game state
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public void setCurrentWord(String word) {
        this.currentWord = word;
    }

    public List<String> getGuessedLetters() {
        return guessedLetters;
    }

    public void setGuessedLetters(List<String> guessedLetters) {
        this.guessedLetters = guessedLetters;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int round) {
        this.currentRound = round;
    }

    public void restartGameState() {
        // Restart game state logic
    }
}
