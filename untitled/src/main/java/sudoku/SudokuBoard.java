package sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SudokuBoard {
    private SudokuField[][] board;

    private SudokuField[] temp;

    public SudokuBoard(int rows, int columns) {
        board = new SudokuField[rows][columns];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = new SudokuField();
            }
        }
    }

    //  public void set(int x, int y, SudokuField input) {
    //     board[x][y] = input;
    //  }
    public SudokuField get(int x, int y) {
        return board[x][y];
    }

    public void solveGame() {
        SudokuSolver sudokucheck = new SudokuSolver();
        sudokucheck.fillBoard(board);
    }

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j].getFieldValue() + " ");
                if (j == 2 || j == 5) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if (i == 2 || i == 5) {
                System.out.println("---------------------");
            }
        }
        System.out.println();
    }

    public SudokuRow getRow(int row) {
        temp = new SudokuField[9];
        for (int i = 0; i < 9; i++) {
            temp[i] = board [row][i];
        }
        SudokuRow sudokuRow = new SudokuRow(temp);
        return sudokuRow;
    }

    public SudokuColumn getColumn(int column) {
        temp = new SudokuField[9];
        for (int i = 0; i < 9; i++) {
            temp[i] = board [i][column];
        }
        SudokuColumn sudokuColumn = new SudokuColumn(temp);
        return sudokuColumn;
    }

}
