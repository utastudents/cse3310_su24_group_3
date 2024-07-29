package uta.cse3310;

import junit.framework.TestCase;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSelectorTest extends TestCase {

    private WordSource wordSourceMock;
    private WordSelector wordSelector;


    public void setUp() throws Exception {
        super.setUp();
        wordSourceMock = Mockito.mock(WordSource.class);
        wordSelector = new WordSelector(wordSourceMock);
    }


    public void testSelectRandomWord() {
        List<String> words = Arrays.asList("example","test"); // mock list of words
        Mockito.when(wordSourceMock.getWords()).thenReturn(words);

        String selectedWord = wordSelector.selectRandomWord();
        assertTrue(words.contains(selectedWord));// checks if it contains the random word 
    }


    public void testSelectThreeRandomWords() {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));
        Mockito.when(wordSourceMock.getWords()).thenReturn(words);
        ArrayList<String> selectedWords = wordSelector.selectThreeRandomWords();
        assertEquals(3,selectedWords.size()); // checks if the size of the slected words are three
        assertTrue(words.containsAll(selectedWords)); // checks if the words are in there
    }

    public void testSelectThreeMeaningfulWords() {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("love", "hope", "faith"));
        Mockito.when(wordSourceMock.getWords()).thenReturn(words);
        ArrayList<String> selectedWords = wordSelector.selectThreeMeaningfulWords();// still need to make the logic for this and test it.
        assertEquals(3,selectedWords.size());// checks if the size of the slected words are three
        assertTrue(words.containsAll(selectedWords));// checks if the words are in there
    }
}
