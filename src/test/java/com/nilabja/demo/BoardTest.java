package com.nilabja.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testMarkAndHasWon() {
        Board board = new Board(3);
        board.mark(0, 0, 'X');
        board.mark(0, 1, 'X');
        board.mark(0, 2, 'X');
        assertTrue(board.hasWon(0, 2, 'X'));
    }

    @Test
    void testIsFilled() {
        Board board = new Board(2);
        board.mark(0, 0, 'X');
        board.mark(0, 1, 'O');
        board.mark(1, 0, 'X');
        board.mark(1, 1, 'O');
        assertTrue(board.isFilled());
    }
}
