const ws = new WebSocket('ws://localhost:8091');

ws.onopen = () => {
    console.log('Connected to WebSocket server');
};

ws.onmessage = (event) => {
    const message = JSON.parse(event.data);
    console.log('Message from server:', message);

    if (message.action === 'gameStarted') {
        alert('Game has started!');
        // Update the game board based on server messages
    }
};

document.getElementById('play').addEventListener('click', () => {
    ws.send(JSON.stringify({ action: 'startGame' }));
});

document.getElementById('solve').addEventListener('click', () => {
    const solution = document.getElementById('solution').value;
    ws.send(JSON.stringify({ action: 'solve', solution: solution }));
});
