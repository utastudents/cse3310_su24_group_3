/*package uta.cse3310;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WordSelectorTest {

    private WordSource wordSource;
    private WordSelector wordSelector;

    @BeforeEach
    public void setup() {
        wordSource = mock(WordSource.class);
        wordSelector = new WordSelector(wordSource);
    }

    @Test
    public void testSelectRandomWord() {
        when(wordSource.getWords()).thenReturn(Arrays.asList("apple", "banana", "cherry"));
        String word = wordSelector.selectRandomWord();
        assertTrue(Arrays.asList("apple", "banana", "cherry").contains(word));
    }

    @Test
    public void testSelectThreeRandomWords() {
        when(wordSource.getWords()).thenReturn(Arrays.asList("apple", "banana", "cherry"));
        List<String> words = wordSelector.selectThreeRandomWords();
        assertEquals(3, words.size());
    }

    @Test
    public void testSelectThreeMeaningfulWords() {
        when(wordSource.getWords()).thenReturn(Arrays.asList("apple", "banana", "cherry"));
        List<String> words = wordSelector.selectThreeMeaningfulWords();
        assertEquals(3, words.size());
    }
}
*/