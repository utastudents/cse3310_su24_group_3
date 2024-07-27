package uta.cse3310;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GameSession extends WebSocketServer {
    private static final int MAX_PLAYERS_PER_SESSION = 4;
    public List<Session> sessions = new ArrayList<>();
    public Map<WebSocket, Player> playerConnections = new HashMap<>();
    private Gson gson =new Gson();

    public class Session {
        private static final int MAX_PLAYERS = 4;
        private List<Player> players = new ArrayList<>();
        private int currentRound =1;

        public void addPlayer(Player player) {
            if (players.size() < MAX_PLAYERS) {
                players.add(player);
            }
        }

        public boolean removePlayer(Player player) {
            return players.remove(player);
        }

        public boolean isFull() {
            return players.size() == MAX_PLAYERS;
        }

        public boolean hasPlayer(Player player) {
            return players.contains(player);
        }

        public List<Player> getPlayers() {
            return players;
        }

        public void handleMessage(Player player, String message) {
            // Handle messages from players
        }
        public void nextRound() {
            if (currentRound < 3) {
                currentRound++;
                // Notify players about the next round
                JsonObject message = new JsonObject();
                message.addProperty("type", "next_round");
                message.addProperty("round", currentRound);
                broadcast(message.toString());
            } else {
                // End of the game
                JsonObject message = new JsonObject();
                message.addProperty("type", "game_result");
                // Include game results here
                broadcast(message.toString());
            }
        }
        private void broadcast(String message) {
            for (Player player : players) {
                for (Map.Entry<WebSocket, Player> entry : playerConnections.entrySet()) {
                    if (entry.getValue().equals(player)) {
                        entry.getKey().send(message);
                        break;
                    }
                }
            }
        }
    }

    public GameSession(InetSocketAddress address) {
        super(address);
    }

    public void assignPlayerToSession(WebSocket conn) {
        Session session = getAvailableSession();
        Player newPlayer = new Player("Player" + (Player.getPlayerList().size() + 1));
        playerConnections.put(conn, newPlayer);
        session.addPlayer(newPlayer);
        conn.send("Welcome to the game session, " + newPlayer.getName() + "!");
        if (session.isFull()) {
            startGame(session);
        }
    }

    public void removePlayerFromSession(WebSocket conn) {
        Player player = playerConnections.get(conn);
        for (Session session : sessions) {
            if (session.removePlayer(player)) {
                break;
            }
        }
        playerConnections.remove(conn);
    }
    

   public void handleMessage(WebSocket conn, String message) {
        System.out.println("Raw message received: " + message);
        Player player = playerConnections.get(conn);
        JsonObject jsonMessage = JsonParser.parseString(message).getAsJsonObject();
        System.out.println("Parsed message: " + jsonMessage.toString());
        String messageType = jsonMessage.get("type").getAsString();

        switch (messageType) {
            case "start_game_button":
                broadcastMessage("{\"type\": \"start_game\"}");
                break;
            // Handle other message types...
            default:
                System.out.println("Unknown message type: "+ messageType);
        }

        for (Session session : sessions) {
            if (session.hasPlayer(player)) {
                session.handleMessage(player, message);
                break;
            }
        }
    }

    private void broadcastMessage(String message) {
        for (WebSocket client : playerConnections.keySet()) {
            client.send(message);
        }
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        // Not used in this context, handled by App.java
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        // Not used in this context, handled by App.java
    }

    @Override
    public void onMessage(WebSocket conn, String message) {

        // Not used in this context, handled by App.java
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
    }

    @Override
    public void onStart() {
        System.out.println("GameSession server started!");
    }

    public Session getAvailableSession() {
        for (Session session : sessions) {
            if (!session.isFull()) {
                return session;
            }
        }
        Session newSession = new Session();
        sessions.add(newSession);
        return newSession;
    }

    public void startGame(Session session) {
        // Notify all players in the session to start the game
        for (Player player : session.getPlayers()) {
            // Send start game message to each player's WebSocket connection
            for (Map.Entry<WebSocket, Player> entry : playerConnections.entrySet()) {
                if (entry.getValue().equals(player)) {
                    entry.getKey().send("{\"type\": \"start_game\"}");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        WebSocketServer server = new GameSession(new InetSocketAddress(9103));
        server.run();
    }
}
