import core.game.Game;
import core.game.Renderer;
import core.player.HumanPlayer;
import view.TerminalKeyboardControl;
import view.TerminalRenderer;
import view.StringPiece;

import java.util.Scanner;

import static lib.StringPainter.TextColor.TXT_BLUE;
import static lib.StringPainter.TextColor.TXT_RED;

public class TicTacToe {

    private static Game game;
    private static Renderer renderer;

    public static void main(String[] args) {
        setUp();
        run();
    }

    private static void run() {
        game.start();

        while (game.isRunning()) {
            renderer.renderGame(game);

            game.update();
        }

        if (game.hasWinner()) {
            renderer.renderEndGame(game);
        } else {
            renderer.renderGameOver(game);
        }
    }

    private static void setUp() {
        var scanner = new Scanner(System.in);
        var control = new TerminalKeyboardControl(scanner);

        var player1 = new HumanPlayer(new StringPiece("X", TXT_BLUE), control);
        var player2 = new HumanPlayer(new StringPiece("O", TXT_RED), control);

        game = new Game(player1, player2);
        renderer = new TerminalRenderer();
    }
}
