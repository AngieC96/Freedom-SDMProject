package dssc.project.freedom;

import dssc.project.freedom.players.Player;
import dssc.project.freedom.utilities.Utility;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationRunner {

    private static class FakeGameHandler extends GameHandler {

        public FakeGameHandler(Scanner in) {
            super(in);
        }

        @Override
        protected void playGameWithGivenSettings(int boardSize, Player player1, Player player2) {
            do {
                System.out.print("Do you want to play again with the same settings? (0 = no, 1 = yes) ");
                if (Utility.getInteger(in) == 1) {
                    System.out.print("Do you want to switch colours? (0 = no, 1 = yes) ");
                    if (Utility.getInteger(in) == 1) {
                        swapColours(player1, player2);
                    }
                } else
                    break;
            } while (true);
        }

    }

    private final ByteArrayOutputStream outputStream;
    private final GameHandler gameHandler;

    public ApplicationRunner(String input) {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Scanner in = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        gameHandler = new FakeGameHandler(in);
    }

    public void parseBoardSize(String expectedOutput, int expectedValue) {
        int value = gameHandler.getBoardSize();
        assertAll(
                () -> assertEquals(expectedOutput, outputStream.toString()),
                () -> assertEquals(expectedValue, value)
        );
    }

    public void parseTypeOfPlayer(String expectedOutput, char expectedValue) {
        int value = gameHandler.getTypeOfPlayer();
        assertAll(
                () -> assertEquals(expectedOutput, outputStream.toString()),
                () -> assertEquals(expectedValue, value)
        );
    }

    public void parseGameWithGivenSettings() {
    }

}