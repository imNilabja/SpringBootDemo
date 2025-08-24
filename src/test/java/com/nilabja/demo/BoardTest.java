package com.nilabja.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testMarkAndHasWonRow() {
        Board board = new Board(3);
        board.mark(0, 0, 'X');
        board.mark(0, 1, 'X');
        board.mark(0, 2, 'X');
        assertTrue(board.hasWon(0, 2, 'X'), "X should win on the first row");
    }

    @Test
    void testMarkAndHasWonColumn() {
        Board board = new Board(3);
        board.mark(0, 1, 'O');
        board.mark(1, 1, 'O');
        board.mark(2, 1, 'O');
        assertTrue(board.hasWon(2, 1, 'O'), "O should win on the second column");
    }

    @Test
    void testMarkAndHasWonDiagonal() {
        Board board = new Board(3);
        board.mark(0, 0, 'X');
        board.mark(1, 1, 'X');
        board.mark(2, 2, 'X');
        assertTrue(board.hasWon(2, 2, 'X'), "X should win on the diagonal");
    }

    @Test
    void testMarkAndHasWonAntiDiagonal() {
        Board board = new Board(3);
        board.mark(0, 2, 'O');
        board.mark(1, 1, 'O');
        board.mark(2, 0, 'O');
        assertTrue(board.hasWon(2, 0, 'O'), "O should win on the anti-diagonal");
    }

    @Test
    void testIsFilledTrue() {
        Board board = new Board(2);
        board.mark(0, 0, 'X');
        board.mark(0, 1, 'O');
        board.mark(1, 0, 'X');
        board.mark(1, 1, 'O');
        assertTrue(board.isFilled(), "Board should be filled");
    }

    @Test
    void testIsFilledFalse() {
        Board board = new Board(2);
        board.mark(0, 0, 'X');
        assertFalse(board.isFilled(), "Board should not be filled");
    }

    @Test
    void testInvalidMarkOutsideBounds() {
        Board board = new Board(3);
        assertFalse(board.mark(-1, 0, 'X'), "Marking outside bounds should fail");
        assertFalse(board.mark(0, 3, 'O'), "Marking outside bounds should fail");
    }

    @Test
    void testInvalidMarkOnOccupiedCell() {
        Board board = new Board(3);
        board.mark(0, 0, 'X');
        assertFalse(board.mark(0, 0, 'O'), "Cannot mark on an occupied cell");
    }

    @Test
    void testNoWinnerInitially() {
        Board board = new Board(3);
        board.mark(0, 0, 'X');
        board.mark(0, 1, 'O');
        assertFalse(board.hasWon(0, 1, 'O'), "No winner yet");
    }

    @Test
    void testMultipleMovesAndWinner() {
        Board board = new Board(3);
        board.mark(0, 0, 'X');
        board.mark(1, 0, 'O');
        board.mark(0, 1, 'X');
        board.mark(1, 1, 'O');
        board.mark(0, 2, 'X'); // X wins
        assertTrue(board.hasWon(0, 2, 'X'), "X should win after multiple moves");
    }
}
