const StartButton = document.getElementById('StartScreen');
const GameSection = document.getElementById('Game1');
StartButton.addEventListener('click', function() 
{
    StartButton.style.display = 'none';
    GameSection.style.display = 'block';

    const display = document.getElementById('CountdownTimer');
    const duration = 120;
    startTimer(duration,display);
});


function startTimer(duration,display)
{
    let timer = duration, minutes,seconds;
    setInterval(function () 
    {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        display.textContent = minutes + ":"+ seconds;
        
        if(--timer<0)
            {
                timer = duration;
            }
    }, 1000);
}

