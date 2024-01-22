package core.player;

import core.board.Board;

public abstract class Player {
    protected final Piece<?> piece;
    protected final Control control;

    protected Player(Piece<?> piece, Control control) {
        this.piece = piece;
        this.control = control;
    }

    public abstract void play(Board board);

    public Piece<?> getPiece() {
        return piece;
    }
}
