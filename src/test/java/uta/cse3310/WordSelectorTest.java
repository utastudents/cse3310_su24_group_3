/*
package uta.cse3310;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSelectorTest  {

    private WordSource wordSource;
    private WordSelector wordSelector;

    @BeforeEach
    public void setUp() throws Exception {
        wordSource = new WordSource();
        setWordsForTesting(wordSource,Arrays.asList("example","test","apple","banana","cherry","love","hope","faith"));
        wordSelector = new WordSelector(wordSource);
    }

    @Test
    public void testSelectRandomWord() {
        List<String> words = wordSource.getWords();
        String selectedWord = wordSelector.selectRandomWord();
        assertTrue(words.contains(selectedWord));// checks if it contains the random word 
    }

    @Test
    public void testSelectThreeRandomWords() {
        List<String> words = wordSource.getWords();
        ArrayList<String> selectedWords = wordSelector.selectThreeRandomWords();
        assertEquals(3,selectedWords.size()); // checks if the size of the slected words are three
        assertTrue(words.containsAll(selectedWords)); // checks if the words are in there
    }
    @Test
    public void testSelectThreeMeaningfulWords() {
        List<String> meaningfulWords = Arrays.asList("love", "hope", "faith");
        setWordsForTesting(wordSource, meaningfulWords);
        List<String> selectedWords = wordSelector.selectThreeMeaningfulWords();
        assertEquals(3,selectedWords.size());// checks if the size of the slected words are three
        assertTrue(meaningfulWords.containsAll(selectedWords));// checks if the words are in there
    }
     private void setWordsForTesting(WordSource wordSource,List<String> words){
        try{
            java.lang.reflect.Field wordsField = WordSource.class.getDeclaredField("words");
            wordsField.setAccessible(true);
            wordsField.set(wordSource,words);
        }catch(NoSuchFieldException|IllegalAccessException e){
            e.printStackTrace();
            fail("failed to set words field for testing");
        }
    }

}
    */
