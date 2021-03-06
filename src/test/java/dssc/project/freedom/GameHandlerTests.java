package dssc.project.freedom;

import dssc.project.freedom.basis.Colour;
import org.junit.jupiter.api.Test;

import static java.lang.System.lineSeparator;

public class GameHandlerTests {

    @Test
    void testWrongBoardSize() {
        String input = "2 4";
        ApplicationRunner application = new ApplicationRunner(input);
        String output = "Enter the board size (minimum 4): "
                + "The size of the board must be an integer >= 4! ";
        application.testBoardSize(output, 4);
    }

    @Test
    void testWrongTypeOfPlayer() {
        String input = "t" + lineSeparator() + "g" + lineSeparator();
        ApplicationRunner application = new ApplicationRunner(input);
        String output = "Choose the player: 'h' for a Human Player, 'r' for a Random Player or 'g' for a Greedy Player. "
                + "Wrong type of player! Reenter it: ";
        application.testTypeOfPlayer(output, 'g');
    }

    @Test
    void replayGameWithSwitchedColours() {
        String input = "1 1 0";
        ApplicationRunner application = new ApplicationRunner(input);
        application.testGameWithGivenSettings(Colour.BLACK, Colour.WHITE);
    }

    @Test
    void replayGameWithoutSwitchingColours() {
        String input = "1 0 0";
        ApplicationRunner application = new ApplicationRunner(input);
        application.testGameWithGivenSettings(Colour.WHITE, Colour.BLACK);
    }
}