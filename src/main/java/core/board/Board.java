package core.board;

import core.player.Piece;

import java.util.Objects;

import static core.board.Indexes.FIRST;
import static core.board.Indexes.SECOND;
import static core.board.Indexes.THIRD;
import static core.board.Indexes.FORTH;
import static core.board.Indexes.FIFTH;
import static core.board.Indexes.SIXTH;
import static core.board.Indexes.SEVENTH;
import static core.board.Indexes.EIGHTH;
import static core.board.Indexes.NINTH;

public class Board {

    private final Position[] positions;

    public Board() {
        this.positions = new Position[Indexes.values().length];
        for (Indexes index : Indexes.values()) {
            positions[index.value] = new Position();
        }
    }

    public void placeAtPosition(Piece<?> piece, Indexes index) {
        this.positions[index.value].place(piece);
    }

    public boolean canPlaceAt(Indexes index) {
        return this.positions[index.value].getPiece() == null;
    }

    public boolean hasMatchingHorizontally() {
        return (
                pieceAt(FIRST) != null
                        && Objects.equals(pieceAt(FIRST), pieceAt(SECOND))
                        && Objects.equals(pieceAt(SECOND), pieceAt(THIRD))
        ) || (
                pieceAt(FORTH) != null
                        && Objects.equals(pieceAt(FORTH), pieceAt(FIFTH))
                        && Objects.equals(pieceAt(FIFTH), pieceAt(SIXTH))
        ) || (
                pieceAt(SEVENTH) != null
                        && Objects.equals(pieceAt(SEVENTH), pieceAt(EIGHTH))
                        && Objects.equals(pieceAt(EIGHTH), pieceAt(NINTH))
        );
    }

    public boolean hasMatchingVertically() {
        return (
                pieceAt(FIRST) != null
                        && Objects.equals(pieceAt(FIRST), pieceAt(FORTH))
                        && Objects.equals(pieceAt(FORTH), pieceAt(SEVENTH))
        ) || (
                pieceAt(SECOND) != null
                        && Objects.equals(pieceAt(SECOND), pieceAt(FIFTH))
                        && Objects.equals(pieceAt(FIFTH), pieceAt(EIGHTH))
        ) || (
                pieceAt(THIRD) != null
                        && Objects.equals(pieceAt(THIRD), pieceAt(SIXTH))
                        && Objects.equals(pieceAt(SIXTH), pieceAt(NINTH))
        );
    }

    public boolean hasMatchingDiagonally() {
        return (
                pieceAt(FIRST) != null
                        && Objects.equals(pieceAt(FIRST), pieceAt(FIFTH))
                        && Objects.equals(pieceAt(FIFTH), pieceAt(NINTH))
        ) || (
                pieceAt(SEVENTH) != null
                        && Objects.equals(pieceAt(SEVENTH), pieceAt(FIFTH))
                        && Objects.equals(pieceAt(FIFTH), pieceAt(THIRD))
        );
    }

    public Position[] getPositions() {
        return positions;
    }

    private Piece<?> pieceAt(Indexes index) {
        return positions[index.value].getPiece();
    }
}
