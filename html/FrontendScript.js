document.addEventListener('DOMContentLoaded', function() {
    const startButton = document.querySelector('.StartButton');
    const game1Section = document.getElementById('Game1');
    const game2Section = document.getElementById('Game2');
    const game3Section = document.getElementById('Game3');
    const StartScreen = document.getElementById('StartScreen');
    const ResultsSectionContainer = document.getElementById('ResultsSectionContainer');
    const nextRound1Button = document.getElementById('NextRound1');
    const nextRound2Button = document.getElementById('NextRound2');
    const nextRound3Button = document.getElementById('NextRound3');
    const PlayAgainButton = document.getElementById('PlayAgain');
    const ShowServerId = document.getElementById("ServerID");
    var idx = -1;
    var gameId =-1;
    class UserEvents{
        button =-1;
        PlaerIdx=0;
        GameId = 1;
    }

    var connection = null;
    var serverUrl;
    serverUrl = "ws://"+window.location.hostname +":9103";

    connection = new WebSocket(serverUrl);
    connection.onopen = function(event){
        console.log("WebSocket connection opened");
    }
    connection.onclose = function(event){
        console.log("Websocket connection closed");
        document.getElementById("topMessage").innerHTML = "Server Offline"
    }

    connection.onmessage =function(event){
        var msg;
        msg=event.data;
        console.log("message received: "+ msg);
        const obj = JSON.parse(msg);

        if('ServerID' in obj){
            ShowServerId.innerHTML =obj.ServerID;
        }
    }



    startButton.addEventListener('click', function() {
        StartScreen.style.display = 'none';
        game1Section.style.display = 'block';

        const display = document.getElementById('CountdownTimer');
        const duration = 120;
        startTimer(duration, display);
        connection.send("Start Game");
    });

    nextRound1Button.addEventListener('click', function() {
        game1Section.style.display = 'none';
        game2Section.style.display = 'block';

        const display = document.getElementById('CountdownTimer');
        const duration = 120;
        startTimer(duration, display);
        connection.send("Next Round 1");
    });

    nextRound2Button.addEventListener('click', function() {
        game2Section.style.display = 'none';
        game3Section.style.display = 'block';

        const display = document.getElementById('CountdownTimer');
        const duration = 120;
        startTimer(duration, display);
        connection.send("Next Round 2");
    });

    nextRound3Button.addEventListener('click', function() {
        game3Section.style.display = 'none';
        ResultsSectionContainer.style.display = 'block';
        connection.send("Next Round 3");
    });
    PlayAgainButton.addEventListener('click', function() {
        ResultsSectionContainer.style.display = 'none';
        StartScreen.style.display = 'block';
        connection.send("Play again");
    });


});
/*
function startTimer(duration, display) {
    let timer = duration, minutes, seconds;
    setInterval(function() {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        if (--timer < 0) {
            timer = duration;
        }
    }, 1000);
} */
