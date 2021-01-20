package dssc.project.freedom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StoneTests {

    @Test
    void checkWhite() {
        Stone stone = new Stone(Colour.WHITE);
        assertTrue(stone.isWhite());
    }

    @Test
    void checkBlack() {
        Stone stone = new Stone(Colour.BLACK);
        assertTrue(stone.isBlack());
    }

    @Test
    void checkNotBlack() {
        Stone stone = new Stone(Colour.WHITE);
        assertFalse(stone.isBlack());
    }

    @Test
    void checkIfLive() {
        Stone stone = new Stone(Colour.WHITE);
        assertFalse(stone.isLive());
    }

    @Test
    void checkIfColoured() {
        Stone stone = new Stone(Colour.NONE);
        stone.makeColoured(Colour.WHITE);
        assertTrue(stone.isWhite());
    }
}
