package view;

import core.board.Board;
import core.board.Indexes;
import core.board.Position;
import core.game.Game;
import core.game.Renderer;

import static core.board.Indexes.*;
import static lib.StringPainter.BackgroundColor.*;
import static lib.StringPainter.TextColor.TXT_BLACK;
import static lib.StringPainter.TextColor.TXT_YELLOW;
import static lib.StringPainter.paint;

public class TerminalRenderer implements Renderer {
    @Override
    public void renderGame(Game game) {
        System.out.println(mountBoardView(game.getBoard()));
    }

    @Override
    public void renderEndGame(Game game) {
        System.out.print(paint(" Ganhador: ", TXT_BLACK, BG_YELLOW));
        System.out.print(paint(" "));
        System.out.println(game.getWinner().getPiece().getGraphic());
    }

    @Override
    public void renderGameOver(Game game) {
        System.out.println(paint(" Nenhum ganhador ", TXT_BLACK, BG_WHITE));
    }

    private String mountBoardView(Board board) {
        Position[] positions = board.getPositions();

        return
                "\n\n\n\n\n " + renderPiece(positions, FIRST) + " | " + renderPiece(positions, SECOND) + " | " + renderPiece(positions, THIRD) + "\n" +
                "---+---+---\n" +
                " " + renderPiece(positions, FORTH) + " | " + renderPiece(positions, FIFTH) + " | " + renderPiece(positions, SIXTH) + "\n" +
                "---+---+---\n" +
                " " + renderPiece(positions, SEVENTH) + " | " + renderPiece(positions, EIGHTH) + " | " + renderPiece(positions, NINTH) + "\n";
    }

    private String renderPiece(Position[] positions, Indexes index) {
        if (positions[index.value].getPiece() instanceof StringPiece piece) {
            return piece.getGraphic();
        }

        return paint(String.valueOf(index.value + 1), TXT_YELLOW);
    }
}
