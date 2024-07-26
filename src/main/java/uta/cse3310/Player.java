package uta.cse3310;

import java.util.ArrayList;

public class Player {

    private String name;
    private int score;
    private Boolean isActive;
    
    public Player(){
    this.name = "";
    this.score = 0;
    this.isActive = false;
    }

    public Player (String name, int score){
        this.name = name;
        this.score = score;
        this.isActive = true;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setScore(int score){
        this.score =score;
    }
    public int getScore(){
        return score;
    }
    public void addPoints(int points) {
        this.score += points;
    }


    public void resetPoints() {
        this.score =0;
        
    }
    public void updateScore(int points){
        this.score =points;
    }

    public Boolean isActivePlayers() {
        return isActive;
    }

    public Boolean setActivePlayer(Boolean isActive) {
        return isActive;
    }

    ArrayList<String> buyVowel(char vowel, ArrayList<String> words) {
        ArrayList<String> updatedWords = new ArrayList<>();
        for (String str : words) {
            if (str.indexOf(vowel) != -1) {
                updatedWords.add(str.replaceAll(String.valueOf(vowel), ""));
            } else {
                updatedWords.add(str);
            }
        }
        return updatedWords;
    }

    ArrayList<String> chooseConsonant(char consonant, ArrayList<String> words) {
        ArrayList<String> updatedWords = new ArrayList<>();
        for (String str : words) {
            if (str.indexOf(consonant) != -1) {
                updatedWords.add(str.replaceAll(String.valueOf(consonant), ""));
            } else {
                updatedWords.add(str);
            }
        }
        return updatedWords;
    }

    boolean solvePuzzle(ArrayList<String> solution, ArrayList<String> puzzle) {
        if (solution.equals(puzzle)) {
            this.addPoints(1000); //Any amount of points, just an example
            return true;
        } else {
            return false;
        }
    }

}