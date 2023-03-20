package sudoku;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SudokuClassTest {

    @Test
    public void CompareSudoku() {
        SudokuClass sudoku1 = new SudokuClass();
        SudokuClass sudoku2 = new SudokuClass();
        sudoku1.fillBoard();
        sudoku2.fillBoard();
        assertNotSame(sudoku1, sudoku2);
    }
}
