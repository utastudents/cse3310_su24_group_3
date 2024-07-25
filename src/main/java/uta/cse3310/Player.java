package uta.cse3310;

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

    void buyVowel(char vowel) {

    }

    void chooseConsonant(char consonant) {

    }

    void solvePuzzle(String solution) {

    }

}