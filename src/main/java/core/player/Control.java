package core.player;

import core.board.Indexes;

public interface Control {
    Play readPlayMadeBy(Player player);

    record Play(
            Indexes chosenIndexPosition
    ) {
    }
}
