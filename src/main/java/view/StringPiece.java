package view;

import lib.StringPainter;
import core.player.Piece;

import static lib.StringPainter.paint;

public class StringPiece extends Piece<String> {

    public StringPiece(String graphic, StringPainter.TextColor textColor) {
        super(paint(graphic, textColor));
    }
}
