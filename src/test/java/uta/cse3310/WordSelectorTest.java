
package uta.cse3310;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

public class WordSelectorTest {
    private WordSelector wordSelector;
    private WordSource wordSource;

    @BeforeEach
    public void setUp() throws IOException {
        // Initialize WordSource and load words from the file
        wordSource = new WordSource();
        wordSource.getSource("words.txt");

        // Initialize WordSelector with the WordSource
        wordSelector = new WordSelector(wordSource);
    }

    @Test
    public void testSelectRandomWord() {
        // Test selection of a random word from the list
        String word = wordSelector.selectRandomWord();
        assertNotNull(word, "Selected word should not be null");
        assertTrue(wordSource.getWords().contains(word), "Selected word should be from the word source");
    }
    
    @Test
    public void testSelectThreeRandomWords() {
        // Test selection of three random words
        ArrayList<String> words = wordSelector.selectThreeRandomWords();
        assertNotNull(words, "Selected words should not be null");
        assertEquals(3, words.size(), "Three words should be selected");
        for (String word : words) {
            assertTrue(wordSource.getWords().contains(word), "Each selected word should be from the word source");
            System.out.println("Three Random words: "+word);
        }
    }
    // Still need to implemnt the logic for selecting meaningful words: current logic is the same as three random words.
    @Test
    public void testSelectThreeMeaningfulWords() {
        // Test selection of three meaningful words
        ArrayList<String> words = wordSelector.selectThreeMeaningfulWords();
        assertNotNull(words, "Selected words should not be null");
        assertEquals(3, words.size(), "Three words should be selected");
        for (String word : words) {
            assertTrue(wordSource.getWords().contains(word), "Each selected word should be from the word source");
            System.out.println("Meaningful words: "+word);
        }
    }
}