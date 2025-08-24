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

    // --- Additional 10 tests ---

    @Test
    void testVerticalWin() {
        Board board = new Board(3);
        board.mark(0, 0, 'O');
        board.mark(1, 0, 'O');
        board.mark(2, 0, 'O');
        assertTrue(board.hasWon(2, 0, 'O'));
    }

    @Test
    void testDiagonalWinTopLeftToBottomRight() {
        Board board = new Board(3);
        board.mark(0, 0, 'X');
        board.mark(1, 1, 'X');
        board.mark(2, 2, 'X');
        assertTrue(board.hasWon(2, 2, 'X'));
    }

    @Test
    void testDiagonalWinTopRightToBottomLeft() {
        Board board = new Board(3);
        board.mark(0, 2, 'O');
        board.mark(1, 1, 'O');
        board.mark(2, 0, 'O');
        assertTrue(board.hasWon(2, 0, 'O'));
    }

    @Test
    void testNoWinYet() {
        Board board = new Board(3);
        board.mark(0, 0, 'X');
        board.mark(0, 1, 'O');
        board.mark(1, 1, 'X');
        assertFalse(board.hasWon(1, 1, 'X'));
    }

    @Test
    void testMarkAlreadyOccupied() {
        Board board = new Board(2);
        board.mark(0, 0, 'X');
        assertFalse(board.mark(0, 0, 'O')); // assuming mark returns false if occupied
    }

    @Test
    void testPartiallyFilledBoard() {
        Board board = new Board(3);
        board.mark(0, 0, 'X');
        board.mark(1, 1, 'O');
        assertFalse(board.isFilled());
    }

    @Test
    void testLargeBoardWin() {
        Board board = new Board(5);
        for (int i = 0; i < 5; i++) board.mark(2, i, 'X');
        assertTrue(board.hasWon(2, 4, 'X'));
    }

//    @Test
//    void testInvalidMarkOutOfBounds() {
//        Board board = new Board(3);
//        assertThrows(IndexOutOfBoundsException.class, () -> board.mark(3, 0, 'X'));
//        assertThrows(IndexOutOfBoundsException.class, () -> board.mark(0, 3, 'O'));
//    }

    @Test
    void testWinAfterLastMove() {
        Board board = new Board(3);
        board.mark(0, 0, 'X');
        board.mark(1, 1, 'X');
        board.mark(2, 2, 'X');
        assertTrue(board.hasWon(2, 2, 'X'));
    }

    @Test
    void testEmptyBoardNotFilled() {
        Board board = new Board(4);
        assertFalse(board.isFilled());
    }
}
