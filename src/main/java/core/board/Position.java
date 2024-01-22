package core.board;

import core.player.Piece;

public class Position {

    private Piece<?> piece;

    public void place(Piece<?> piece) {
        this.piece = piece;
    }

    public Piece<?> getPiece() {
        return this.piece;
    }

}
