package core.game;

import core.player.Player;
import core.board.Board;

import java.util.Random;

public class Game {

    private final Board board;
    private final Player[] players;

    private Integer currentPlayerIndex;
    private Integer round;
    private State state;
    private Player winner;

    public Game(Player player1, Player player2) {
        this.board = new Board();
        this.players = new Player[]{player1, player2};
    }

    public void start() {
        this.currentPlayerIndex = new Random().nextInt(players.length);
        this.state = State.RUNNING;
        this.round = 1;
    }

    public void update() {

        validateGameConditions();

        if (isRunning()) {
            gameplay();

            round++;
        }
    }

    public boolean isRunning() {
        return state == State.RUNNING;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean hasWinner() {
        return winner != null;
    }

    public Board getBoard() {
        return board;
    }

    private void gameplay() {
        setCurrentPlayer();

        currentPlayer().play(board);
    }

    private void setCurrentPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % 2;
    }

    private void validateGameConditions() {
        if (board.hasMatchingHorizontally()
                || board.hasMatchingVertically()
                || board.hasMatchingDiagonally()) {
            winGame();
        }else if (round == 10) {
            gameOver();
        }
    }

    private void winGame() {
        this.state = State.ENDED;

        winner = currentPlayer();
    }

    private void gameOver() {
        this.state = State.ENDED;
    }

    public Player currentPlayer() {
        return players[currentPlayerIndex];
    }

    public enum State {
        RUNNING, ENDED
    }
}
