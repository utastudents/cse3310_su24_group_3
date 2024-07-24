package uta.cse3310;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WordSourceTest {

    @Test
    public void testReadWordsFromFile() throws IOException {
        WordSource wordSource = new WordSource();
        Files.write(Paths.get("words.txt"), "apple\nbanana\ncherry".getBytes());
        wordSource.getSource("words.txt");
        List<String> words = wordSource.getWords();
        assertEquals(3, words.size());
        assertTrue(words.contains("apple"));
        assertTrue(words.contains("banana"));
        assertTrue(words.contains("cherry"));
    }

    @Test
    public void testChooseRandomWord() {
        WordSource wordSource = new WordSource();
        wordSource.getSource("words.txt");
        String word = wordSource.chooseRandomWord();
        assertNotNull(word);
    }
}
