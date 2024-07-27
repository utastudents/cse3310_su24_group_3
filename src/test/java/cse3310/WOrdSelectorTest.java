/*package uta.cse3310;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

public class WordSelectorTest {

    private WordSource wordSourceMock;
    private WordSelector wordSelector;

    @Before
    public void setUp() {
        wordSourceMock = Mockito.mock(WordSource.class);
        wordSelector = new WordSelector(wordSourceMock);
    }

    @Test
    public void testSelectRandomWord() {
        String word = "example";
        String selectedWord = wordSelector.selectRandomWord(word);
        assertEquals("example", selectedWord);
    }

    @Test
    public void testSelectThreeRandomWords() {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));
        ArrayList<String> selectedWords = wordSelector.selectThreeRandomWords(words);
        assertEquals(words, selectedWords);
    }

    @Test
    public void testSelectThreeMeaningfulWords() {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("love", "hope", "faith"));
        ArrayList<String> selectedWords = wordSelector.selectThreeMeaningfulWords(words);
        assertEquals(words, selectedWords);
    }
}
*/