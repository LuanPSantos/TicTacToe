package view;

import core.player.Control;
import core.player.Player;
import core.board.Indexes;

import java.util.Scanner;

public class TerminalKeyboardControl implements Control {
    private final Scanner scanner;

    public TerminalKeyboardControl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Play readPlayMadeBy(Player player) {
        Indexes playerInput = null;

        do {
            StringPiece piece = (StringPiece) player.getPiece();
            System.out.print("Vez do " + piece.getGraphic() + ": ");
            var input = scanner.nextLine();

            if (input.length() == 1) {
                playerInput = parseToIndex(input.charAt(0));
            }
        } while (playerInput == null);

        return new Play(playerInput);
    }


    public Indexes parseToIndex(Character character) {
        return switch (character) {
            case '1' -> Indexes.FIRST;
            case '2' -> Indexes.SECOND;
            case '3' -> Indexes.THIRD;
            case '4' -> Indexes.FORTH;
            case '5' -> Indexes.FIFTH;
            case '6' -> Indexes.SIXTH;
            case '7' -> Indexes.SEVENTH;
            case '8' -> Indexes.EIGHTH;
            case '9' -> Indexes.NINTH;
            default -> null;
        };
    }
}
