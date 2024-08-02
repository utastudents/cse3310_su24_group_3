package uta.cse3310;

import java.util.ArrayList;
import java.util.List;


public class GameLogic {

    private List<Player> players;
    private int currentRound;
    private WordSource wordSorce;
    private String currentWord;



    public GameLogic() {
        players = new ArrayList<>();
        wordSorce = new WordSource();
        currentRound=0;
    }

    public void addPlayers(Player player) {
        players.add(player);
    }

    public void startGame() {
        currentRound = 1;
        chooseNewWord();
        startRound();
    }

    public void advanceRound() {
        currentRound++;
        chooseNewWord();
        startRound();
    }

    public void chooseNewWord() {
        currentWord = wordSorce.chooseRandomWord();
    }

    public String GetCurrentWord() {
        return currentWord;
    }

    public void startRound() {
        System.out.println("Round " + currentRound + " has started.");
    }

    public void endRound() {
        System.out.println("Round "+currentRound+ " has ended.");
    }

    void playerAction(Player player, String action) {
        System.out.println("Player " + player.getName() + " performed action: " + action);

        /*Example updating player score based on thier action
         * if(action.equals("correct_guess")){
         * player.addPoints(100);
         * }
         * else if(action.equals("incorrect_guess")){
         * player.addPoints(-5);
         * }
         */
    }

    public String getGameState()
    {
        StringBuilder gameState = new StringBuilder();
        gameState.append("Current round: ").append(currentRound).append("\n");
        gameState.append("Current Word: ").append(currentWord).append("\n");
        gameState.append("Players:\n");
        for (Player player : players) {
            gameState.append(" - ").append(player.getName()).append(player.getScore()).append("points\n");
        }
        return gameState.toString();
    }

    public List<Player> getPlayers() {
        return players;
    }


}