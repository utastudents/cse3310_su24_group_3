package uta.cse3310;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WordSource {
  private String filePath;
  private List<String> words;

  public WordSource() {
    this.filePath = "words.txt"; // Default file path
  }

  public void getSource(String filePath) {
    this.filePath = filePath;
    readWordsFromFile();
  }

  public void readWordsFromFile() {
    try {
      words = Files.readAllLines(Paths.get(filePath));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<String> getWords() {
    return words;
  }

  public String chooseRandomWord() {
    return words.get((int) (Math.random() * words.size()));
  }
}
