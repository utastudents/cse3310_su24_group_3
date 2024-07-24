package uta.cse3310;

public class Player {
    private String name;
    private int score;
    private Boolean isActive;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.isActive = true;
    }

    public void addPoints(int points) {
        this.score += points;
    }

    public void resetPoints() {
        this.score = 0;
    }

    public Boolean isActivePlayer() {
        return isActive;
    }

    public void setActivePlayer(Boolean isActive) {
        this.isActive = isActive;
    }

    public void buyVowel(char vowel) {
        // Buy vowel logic
    }

    public void chooseConsonant(char consonant) {
        // Choose consonant logic
    }

    public void solvePuzzle(String solution) {
        // Solve puzzle logic
    }
}
