package sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SudokuBoard {
    private int[][] board;

    public SudokuBoard() {
        board = new int[9][9];
    }

    public void set(int x, int y, int input) {
        board[x][y] = input;
    }

    public int get(int x, int y) {
        return board[x][y];
    }

    public void solveGame() {
        SudokuSolver sudokucheck = new SudokuSolver();
        sudokucheck.fillBoard(board);
    }

}
