package uta.cse3310;

public class userEvent {
    int gameId;
    PlayerType playerIdx;
    

    userEvent(){

    }
    userEvent(int _gameId, PlayerType _PlayerIdx){
        gameId =_gameId;
        playerIdx = _PlayerIdx;
    }
}
