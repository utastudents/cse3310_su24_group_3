package uta.cse3310;

import java.util.List;

public class GameState {
    private List<Player> players;
    private String currentWord;
    private List<String> guessedLetters;
    private int currentRound;
    private int maxRound;

    public GameState()
    {
        this.players = null;
        this.currentWord = "";
        this.guessedLetters = null;
        this.currentRound = 0;
        this.maxRound = 0;
    }

    public List<Player> getPlayer()
    {
        return players;
    }
    public void setPlayers(List<Player> players)
    {
        this.players = players;
    }
    public String getCurrentWord()
    {
        return currentWord;
    }
    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    public List<String> getGuessedLetters() {
        return guessedLetters;
    }
    
    public void setGuessedLetters(List<String> guessedLetters)
    {
        this.guessedLetters = guessedLetters;
    }

    public int getCurrentRound()
    {
        return currentRound;
    }
    public void setCurrentRound(int currentRound)
    {
        this.currentRound = currentRound;
    }
    public void restartGameState()
    {
        this.players = null;
        this.currentWord = "";
        this.guessedLetters.clear();
        this.currentRound = 0;
    }
    

}