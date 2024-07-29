package uta.cse3310;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordSelector {
    private WordSource wordSource;
    private Random random;

    public WordSelector(WordSource wordSource)
    {
        this.wordSource =wordSource;
        this.random = new Random();// to get the random words by the indext of the list
    }
    public String selectRandomWord()
    {
        List<String> words = wordSource.getWords();
        if(words ==null||words.isEmpty()){
            return null;
        }
        int index = random.nextInt(words.size());

        return words.get(index);
    }

    public ArrayList<String> selectThreeRandomWords()
    {
        List<String> words = wordSource.getWords();
        ArrayList<String> selectedWords = new ArrayList<>();

        if(words !=null&&words.size()>=3){ // checks if the words is there and if it it has more than 3 words in the list so that it could not get a sngle, or two words
            for(int i=0; i<3;i++){
                int index = random.nextInt(words.size());
                selectedWords.add(words.get(index));
            }
        }
        return selectedWords;
    }

    // need to make logic for deteriming if a word is meaningful
    public ArrayList<String> selectThreeMeaningfulWords()
    {
        List<String> words = wordSource.getWords();
        ArrayList<String> selectedWords = new ArrayList<>();

        if(words !=null&&words.size()>=3){
            for(int i=0; i<3;i++){
                int index = random.nextInt(words.size());
                selectedWords.add(words.get(index));
            }
        }
        return selectedWords;
    }
    
}