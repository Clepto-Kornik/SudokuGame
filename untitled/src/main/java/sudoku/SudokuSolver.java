package sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SudokuSolver {
    public void fillBoard(SudokuField[][] board) {
        //clearBoard(board);

        backtrack(0, 0,board);
    }

    private boolean backtrack(int row, int col, SudokuField[][] board) {
        //clearBoard(board);
        if (row == 9) {
            return true;
        }

        int nextRow = col == 8 ? row + 1 : row;
        int nextCol = col == 8 ? 0 : col + 1;

        if (board[row][col].getFieldValue() != 0) {
            return backtrack(nextRow, nextCol, board);
        }

        List<Integer> candidates = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(candidates);
        for (int candidate : candidates) {
            if (isValid(row, col, candidate, board)) {
                board[row][col].setFieldValue(candidate);
                if (backtrack(nextRow, nextCol, board)) {
                    return true;
                }
                board[row][col].setFieldValue(0);
            }
        }

        return false;
    }

    private boolean isValid(int row, int col, int num, SudokuField [][]board) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i].getFieldValue() == num || board[i][col].getFieldValue() == num) {
                return false;
            }
        }

        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j].getFieldValue() == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private void clearBoard(SudokuField[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j].setFieldValue(0);
            }
        }
    }
}
