package uta.cse3310;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int score;
    private int id;
    private boolean isActive;
    private static List<Player> playerList = new ArrayList<>();
    private PlayerType type;
    
    public Player(String name) {
        if (verifyName(name)) {
            this.name = name;
            this.id = playerList.size() + 1;
            this.isActive = true;
            this.score = 0;
            playerList.add(this);
        } else {
            this.name = null;
            this.id = -1;  // invalid id since the name is not valid
        }
    }

    public boolean verifyName(String playerName) {
        for (Player player : playerList) {
            if (playerName.equals(player.getName())) {
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void removePlayer(int playerId) {
        playerList.removeIf(player -> player.id == playerId);
    }

    public PlayerType getPlayerOrder() {
        return type;
    }

    public void setPlayerOrder(PlayerType type) {
        this.type = type;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addPoints(int points) {
        this.score += points;
    }

    public void resetPoints() {
        this.score = 0;
    }

    public void updateScore(int points) {
        this.score = points;
    }

    public boolean isActivePlayer() {
        return isActive;
    }

    public void setActivePlayer(boolean isActive) {
        this.isActive = isActive;
    }

    public List<String> buyVowel(char vowel, List<String> words) {
        List<String> updatedWords = new ArrayList<>();
        for (String str : words) {
            if (str.indexOf(vowel) != -1) {
                updatedWords.add(str.replaceAll(String.valueOf(vowel), ""));
            } else {
                updatedWords.add(str);
            }
        }
        return updatedWords;
    }

    public List<String> chooseConsonant(char consonant, List<String> words) {
        List<String> updatedWords = new ArrayList<>();
        for (String str : words) {
            if (str.indexOf(consonant) != -1) {
                updatedWords.add(str.replaceAll(String.valueOf(consonant), ""));
            } else {
                updatedWords.add(str);
            }
        }
        return updatedWords;
    }

    public boolean solvePuzzle(List<String> solution, List<String> puzzle) {
        if (solution.equals(puzzle)) {
            this.addPoints(1000); // Example points
            return true;
        } else {
            return false;
        }
    }


    public static void clearPlayerList(){
        playerList.clear();
    }
    public static List<Player> getPlayerList(){
        return playerList;
    }

    public void sendMessage(String message){
        System.out.print("Message is: " + message);
    }
}
