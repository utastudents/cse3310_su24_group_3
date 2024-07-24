package uta.cse3310;

import java.util.List;

public class GameSession {
    private List<Player> players;
    private String currentWord;
    private String guessedWord;
    private GameLogic gameLogic;
    private boolean gameStarted;
    private boolean gameEnded;

    public GameSession(WordSource wordSource, GameLogic gameLogic) {
        // Initialize session with word source and game logic
    }

    public void addPlayer(Player player) {
        // Add player to session logic
    }

    public void start() {
        // Start session logic
    }

    public void end() {
        // End session logic
    }

    public String processAction(Player player, String action) {
        // Process player action logic
        return action;
    }

    public String getGameState() {
        // Get current game state logic
        return "State";
    }
}
