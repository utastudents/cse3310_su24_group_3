package uta.cse3310;


import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordSource {
    private List<String> words;

    public WordSource() {
        words = new ArrayList<>();
        loadWords();
    }

    private void loadWords() {
        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() >= 3 && line.matches("[a-z]+")) {
                    words.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getWords() {
        return words;
    }
}
