let activePlayer = 1;
let currentScores = [0, 0];
let savedScores = [0, 0];

// funtion for rolling the dice
function rollDice() {
    const ROLL = Math.floor(Math.random() * 6) + 1;
    document.getElementById('dice').src = `dice${ROLL}.png`;

    if (ROLL === 1) {
        currentScores[activePlayer - 1] = 0;
        updateScores();
        switchPlayer();
    } else {
        currentScores[activePlayer - 1] += ROLL;
        updateScores();
    }
}
//help button functions
function showRules() {
    document.getElementById('rulesPopup').style.display = 'flex';
}

function closeRules() {
    document.getElementById('rulesPopup').style.display = 'none';
}

// funtion for saving the score
function saveScore() {
    savedScores[activePlayer - 1] += currentScores[activePlayer - 1];
    currentScores[activePlayer - 1] = 0;
    updateScores();

    //winner annoucement
    if (savedScores[activePlayer - 1] >= 100) {
        const Winner_Div = document.getElementById('winner');
        const Player_Name = document.getElementById(`name${activePlayer}`).value;

        Winner_Div.innerHTML = `🎉 <strong>${Player_Name}</strong> Wins the Game! 🏆`;
        Winner_Div.style.display = 'block';

        disableControls();
    } else {
        switchPlayer();
    }
}

// funtion for switching the player
function switchPlayer() {
    document.getElementById(`player${activePlayer}`).classList.remove('active');
    activePlayer = activePlayer === 1 ? 2 : 1;
    document.getElementById(`player${activePlayer}`).classList.add('active');
}

// funtion for updating the score
function updateScores() {
    document.getElementById('current1').innerText = currentScores[0];
    document.getElementById('saved1').innerText = savedScores[0];
    document.getElementById('current2').innerText = currentScores[1];
    document.getElementById('saved2').innerText = savedScores[1];
}

// funtion to reset the game
function resetGame() {
    currentScores = [0, 0];
    savedScores = [0, 0];
    activePlayer = 1;
    document.getElementById('winner').innerText = '';
    document.getElementById('player1').classList.add('active');
    document.getElementById('player2').classList.remove('active');
    updateScores();
    enableControls();
}

//functions for  enabling and disabling game controls (roll,save,reset)
function disableControls() {
    document.querySelector('.rolling_dice').disabled = true;
    document.querySelector('.save_score').disabled = true;
}

function enableControls() {
    document.querySelector('.rolling_dice').disabled = false;
    document.querySelector('.save_score').disabled = false;
}