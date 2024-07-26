package uta.cse3310;

import java.util.ArrayList;
import java.util.List;

public class GameServer {
   private int sessionId;
    private List<Player> players;
    private WordSource wordSource;
    private GameLogic gameLogic;

   public GameServer() {
        players = new ArrayList<>();
        wordSource = new WordSource();
        gameLogic = new GameLogic();
    }

    public void StartGame()
    {
        gameLogic.startGame();
        broadcastGameState(sessionId);
    }
    public void endGame()
    {
        System.out.println("Game has ended.");
        broadcastMessage("Game has ended.");
    }
    public void handlePlayerAction(int playerid, String action)
    {
        Player player = getPlayerById(playerId);
        if (player != null) {
            gameLogic.playerAction(player, action);
            broadcastGameState(sessionId);
        }
    }
    public void broadcastGameState(int sessionid)
    {
         String gameState = gameLogic.getGameState();
         broadcastMessage(gameState);
    }
    public void addPlayers(Player players)
    {
         players.add(player);
         System.out.println("Player " + player.getPlayerName() + " added.");
    }
    public void removePlayers(int playerid)
    {
        Player player = getPlayerById(playerId);
        if (player != null) {
            players.remove(player);
            System.out.println("Player " + player.getPlayerName() + " removed.");
        }
    }
    public void createSession()
    {
         sessionId = generateSessionId();
         System.out.println("Session " + sessionId + " created.");
    }
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
        // generateS a unique/rand session ID
        return (int) (Math.random() * 10000);
    }

    private void broadcastMessage(String message) {
        // message to all connected players
        for (Player player : players) {
            player.sendMessage(message);
        }
    }
}
