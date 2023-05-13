package sudoku;

import org.junit.jupiter.api.Test;
import sudoku.board.SudokuField;

import static org.junit.jupiter.api.Assertions.*;

class SudokuFieldTest {

    @Test
    public void testCompareToReturnsZero() {
        SudokuField field = new SudokuField(5);
        SudokuField other = new SudokuField(5);
        assertEquals(field.compareTo(other), 0);
    }

    @Test
    public void testCompareToReturnsPositive() {
        SudokuField field = new SudokuField(5);
        SudokuField other = new SudokuField(3);
        assertTrue(field.compareTo(other) > 0);
    }

    @Test
    public void testCompareToReturnsNegative() {
        SudokuField field = new SudokuField(5);
        SudokuField other = new SudokuField(7);
        assertTrue(field.compareTo(other) < 0);
    }
}
