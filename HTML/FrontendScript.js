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
    const buyLetterButtons = document.querySelectorAll('.BuyLetter');
    const solveButtons = document.querySelectorAll('.Solve');
    const endTurnButtons = document.querySelectorAll('.EndTurn');
    const leaveGameButtons = document.querySelectorAll('.LeaveGame');
    const socket = new WebSocket('ws://localhost:9103');

    socket.onopen = function(event) {
        console.log('Connection opened');
        socket.send('Hello Server');
    };

    socket.onmessage = function(event) {
        console.log('Message received: ', event.data);
        const messages = JSON.parse(event.data);
        switch (messages.type) {
            case 'start_game':
                handleStartGame(messages.data);
                break;
            case 'next_round':
                handleNextRound(messages.data);
                break;
            case 'game_result':
                handleGameResult(messages.data);
                break;
            case 'play_again':
                // handle play again
                break;
           
            // more cases ...
            default:
                console.log('Unknown message type ' + messages.type);
        }
    };

    socket.onclose = function(event) {
        console.log('Connection closed');
    };

    socket.onerror = function(error) {
        console.log('WebSocket Error: ' + error);
    };

    startButton.addEventListener('click', function() {
        StartScreen.style.display = 'none';
        game1Section.style.display = 'block';
    
        const display = document.getElementById('CountdownTimer1');
        const duration = 120;
        startTimer(duration, display);
        socket.send(JSON.stringify({ type: 'start_game_button' }));
    });

    nextRound1Button.addEventListener('click', function() {
        game1Section.style.display = 'none';
        game2Section.style.display = 'block';

        const display = document.getElementById('CountdownTimer2');
        const duration = 120;
        startTimer(duration, display);
        socket.send(JSON.stringify({ type: 'next_round', round: 1 }));
    });

    nextRound2Button.addEventListener('click', function() {
        game2Section.style.display = 'none';
        game3Section.style.display = 'block';

        const display = document.getElementById('CountdownTimer3');
        const duration = 120;
        startTimer(duration, display);
        socket.send(JSON.stringify({ type: 'next_round', round: 2 }));
    });

    nextRound3Button.addEventListener('click', function() {
        game3Section.style.display = 'none';
        ResultsSectionContainer.style.display = 'block';
        socket.send(JSON.stringify({ type: 'next_round', round: 3 }));
    });

    PlayAgainButton.addEventListener('click', function() {
        ResultsSectionContainer.style.display = 'none';
        StartScreen.style.display = 'block';
        socket.send(JSON.stringify({ type: 'play_again' }));
    });

    // Game buttons
    buyLetterButtons.forEach(button => {
        button.addEventListener('click', function() {
            const gameId = this.id.replace('BuyLetter', '');
            socket.send(JSON.stringify({ type: 'buy_letter', game: gameId }));
        });
    });

    solveButtons.forEach(button => {
        button.addEventListener('click', function() {
            const gameId = this.id.replace('Solve', '');
            socket.send(JSON.stringify({ type: 'solve', game: gameId }));
        });
    });

    endTurnButtons.forEach(button => {
        button.addEventListener('click', function() {
            const gameId = this.id.replace('EndTurn', '');
            socket.send(JSON.stringify({ type: 'end_turn', game: gameId }));
        });
    });

    leaveGameButtons.forEach(button => {
        button.addEventListener('click', function() {
            const gameId = this.id.replace('LeaveGame', '');
            socket.send(JSON.stringify({ type: 'leave_game', game: gameId }));
            if(window.confirm('Are you sure you want to leave the game?'));{
                window.location.href = 'about:blank'// redirects to blankpage
            }
        });
    });
    
    function handleStartGame(data) {
        console.log('Game started:', data);
        StartScreen.style.display = 'none';
        game1Section.style.display = 'block';
    
        const display = document.getElementById('CountdownTimer1');
        const duration = 120;
        startTimer(duration, display);
    }

    function handleNextRound(data) {
        console.log('Next round:', data.round);
        
    }

    function handleGameResult(data) {
        console.log('Game result:', data);
    }

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
    }

});
