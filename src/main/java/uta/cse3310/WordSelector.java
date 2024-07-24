package uta.cse3310;

import java.util.List;
import java.util.Random;

public class WordSelector {
  private WordSource wordSource;
  private Random random;

  public WordSelector(WordSource wordSource) {
    this.wordSource = wordSource;
    this.random = new Random();
  }

  public String selectRandomWord() {
    List<String> words = wordSource.getWords();
    return words.get(random.nextInt(words.size()));
  }

  public List<String> selectThreeRandomWords() {
    List<String> words = wordSource.getWords();
    // Select three random words logic
    return words.subList(0, 3);
  }

  public List<String> selectThreeMeaningfulWords() {
    List<String> words = wordSource.getWords();
    // Select three meaningful words logic
    return words.subList(0, 3);
  }
}
