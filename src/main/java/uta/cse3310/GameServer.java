package uta.cse3310;

import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private int sessionId;
    private List<Player> players;

    private GameLogic gameLogic;


    public GameServer() {
        players = new ArrayList<>();

        gameLogic = new GameLogic();

    }

    public void startGame() {
        gameLogic.startGame();
        broadcastGameState(sessionId);
    }

    public void endGame() {

        System.out.println("Game has ended.");
        broadcastMessage("Game has ended.");
    }

    public void handlePlayerAction(int playerId, String action) {
        Player player = getPlayerById(playerId);
        if (player != null) {
            gameLogic.playerAction(player, action);
            broadcastGameState(sessionId);
        }
    }

    public void broadcastGameState(int sessionId) {
        String gameState = gameLogic.getGameState();
        broadcastMessage(gameState);
    }

    public void addPlayer(Player player) {
        players.add(player);
        System.out.println("Player " + player.getName() + " added.");
    }

    public void removePlayer(int playerId) {
        Player player = getPlayerById(playerId);
        if (player != null) {
            players.remove(player);
            System.out.println("Player " + player.getName() + " removed.");
        }
    }
    public List<Player> getPlayer(){
        return players;
    }
    public int getSessionId(){
        return sessionId;
    }
    public void createSession() {
        sessionId = generateSessionId();
        System.out.println("Session " + sessionId + " created.");
    }

    private Player getPlayerById(int playerId) {
        for (Player player : players) {
            if (player.getId() == playerId) {
                return player;
            }
        }
        return null;
    }

    private int generateSessionId() {
        // Generate a unique/random session ID
        return (int) (Math.random() * 10000);
    }

    private void broadcastMessage(String message) {
        // Send message to all connected players
        for (Player player : players) {
            player.sendMessage(message);
        }
    }
}
