 package uta.cse3310;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class WordSourceTest {

    @Test
    public void testReadWordsFromFile() throws IOException {
        WordSource wordSource = new WordSource();
        wordSource.getSource("words.txt");
        List<String> words = wordSource.getWords();
        assertEquals(9895, words.size());
        assertTrue(words.contains("celebrity"));
        assertTrue(words.contains("cell"));
        assertTrue(words.contains("cest"));
        assertFalse(words.contains("brat"));// not in the words.txt file and should return false
    }
    @Test
    public void testChooseRandomWord() {
        WordSource wordSource = new WordSource();
        wordSource.getSource("words.txt");
        String word = wordSource.chooseRandomWord();
        assertNotNull(word);
    }
}