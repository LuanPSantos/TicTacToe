package core.player;

import core.board.Board;

public class HumanPlayer extends Player{
    public HumanPlayer(Piece<?> piece, Control control) {
        super(piece, control);
    }

    @Override
    public void play(Board board) {

        Control.Play play;
        do {
            play = control.readPlayMadeBy(this);
        } while (!board.canPlaceAt(play.chosenIndexPosition()));

        board.placeAtPosition(piece, play.chosenIndexPosition());
    }
}
