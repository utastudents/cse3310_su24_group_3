package uta.cse3310;

import java.util.List;

public class WordSelector {
    private WordSource wordSource;

    public WordSelector(WordSource wordSource) {
        this.wordSource = wordSource;
    }

    public String selectWord() {
        List<String> words = wordSource.getWords();
        // Randomly select and return a word from the list
        return words.get((int) (Math.random() * words.size()));
    }
}
