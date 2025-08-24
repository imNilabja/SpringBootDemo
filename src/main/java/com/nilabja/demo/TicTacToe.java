//Game
//Board
//Player
package com.nilabja.demo;
import java.util.*;

class Player {
    public String name;
    public char mark;

    public Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

}

class Board {
    public int size;
    public char[][] grid;

    public Board(int size) {
        this.size = size;
        grid = new char[size][size];

        for (int i = 0; i < size; i++) {
            Arrays.fill(grid[i], '.');
        }
    }

    public void printGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean mark(int row, int col, char mark) {
        if (row >= 0 && row < size && col >= 0 && col < size && grid[row][col] == '.') {

            grid[row][col] = mark;
            return true;
        }

        return false;
    }

    public boolean isFilled() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;

    }

    public boolean hasWon(int row, int col, char mark) {
        boolean rowFill = true, colFill = true, diagonalFill = true, antiDiagonalFill = true;

        for (int i = 0; i < size; i++) {
            if (grid[row][i] != mark)
                rowFill = false;
            if (grid[i][col] != mark)
                colFill = false;
            if (grid[i][i] != mark)
                diagonalFill = false;
            if (grid[i][size - 1 - i] != mark)
                antiDiagonalFill = false;
        }

        return rowFill || colFill || diagonalFill || antiDiagonalFill;
    }
}

class Game {
    private ArrayList<Player> players = new ArrayList<>();
    private Board board;

    public Game(ArrayList<Player> players, Board board) {
        this.players = players;
        this.board = board;
    }

    public void play() {
        boolean won = false;
        Random rand = new Random();
        while (!won && !board.isFilled()) {
            // board.printGrid();
            for (Player p : players) {

                System.out.println(p.name + " is choosing...");

                boolean placed = false;
                int row = 0;
                int col = 0;
                while (!placed) {
                    if (board.isFilled()) break;

                    row = rand.nextInt(board.size);
                    col = rand.nextInt(board.size);
                    placed = board.mark(row, col, p.mark);
                }
                System.out.println("Marked grid:");
                board.printGrid();

                won = board.hasWon(row, col, p.mark);
                if (won) {
                    System.out.println(p.name + " (" + p.mark + ") wins!");

                    break;

                }
            }
        }
        if (won == false) {
            System.out.println("It is a Draw!");
        }
    }
}

public class TicTacToe {
    public static void main(String[] args) {
        Board board = new Board(10);
        // board.printGrid();
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Nilabja", 'X'));
        players.add(new Player("Rimil", 'O'));

        Game newGame = new Game(players, board);
        newGame.play();
    }
}
