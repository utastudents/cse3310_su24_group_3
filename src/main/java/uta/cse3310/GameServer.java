package uta.cse3310;

import java.util.List;

public class GameServer {
    private int sessionId;
    private List<Player> players;
    private WordSource wordSource;
    private GameLogic gameLogic;

    public void startGame() {
        // Start game logic
    }

    public void endGame() {
        // End game logic
    }

    public void handlePlayerAction(int playerId, String action) {
        // Handle player action logic
    }

    public void broadcastGameState(int sessionId) {
        // Broadcast game state logic
    }

    public void addPlayers(Player player) {
        // Add player logic
    }

    public void removePlayers(int playerId) {
        // Remove player logic
    }

    public void createSession() {
        // Create session logic
    }
}
