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


    startButton.addEventListener('click', function() {
        StartScreen.style.display = 'none';
        game1Section.style.display = 'block';

        const display = document.getElementById('CountdownTimer');
        const duration = 120;
        startTimer(duration, display);
    });

    nextRound1Button.addEventListener('click', function() {
        game1Section.style.display = 'none';
        game2Section.style.display = 'block';

        const display = document.getElementById('CountdownTimer');
        const duration = 120;
        startTimer(duration, display);
    });

    nextRound2Button.addEventListener('click', function() {
        game2Section.style.display = 'none';
        game3Section.style.display = 'block';

        const display = document.getElementById('CountdownTimer');
        const duration = 120;
        startTimer(duration, display);
    });

    nextRound3Button.addEventListener('click', function() {
        game3Section.style.display = 'none';
        ResultsSectionContainer.style.display = 'block';
    });
    PlayAgainButton.addEventListener('click', function() {
        resultsScreenSection.style.display = 'none';
        StartScreen.style.display = 'block';
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
