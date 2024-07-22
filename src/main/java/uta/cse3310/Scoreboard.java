package uta.cse3310;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scoreboard  {
    private Map<String,Integer> scores ;

    public Scoreboard(){
        scores = new HashMap<>();
    }

    public void updateScore(String PlayerName, int score)
    {
        // Upsate Score & send a message
        scores.put(PlayerName, scores.getOrDefault(PlayerName, 0)+score);
        

    }
    public int getScore(String PlayerName)
    {
        
        return scores.getOrDefault(PlayerName, 0);
    }
}
