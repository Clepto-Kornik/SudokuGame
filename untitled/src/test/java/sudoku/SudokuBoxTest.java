package sudoku;

import org.junit.jupiter.api.Test;
import sudoku.board.SudokuField;
import sudoku.group.SudokuBox;
import sudoku.group.SudokuColumn;
import sudoku.group.SudokuRow;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SudokuBoxTest {

    @Test
    public void testVerifyReturnsTrueForValidBox() {
        SudokuBox box = createSudokuBox();
        assertTrue(box.verify());
    }

    @Test
    public void testVerifyReturnsFalseForInvalidBox() {
        int[] values = {1, 2, 2, 4, 5, 6, 7, 8, 9};

        SudokuField[] fields = new SudokuField[9];
        for(int i=0; i<9; i++) {
            fields[i] = new SudokuField(values[i]);
        }

        SudokuBox box = new SudokuBox(fields);
        assertFalse(box.verify());
    }

    @Test
    public void testCloneHasProperValue() {
        SudokuBox row = createSudokuBox();
        SudokuBox clone = row.clone();

        for(int i=0; i<9; i++) {
            assertEquals(row.getValue(i), clone.getValue(i));
        }
    }

    @Test
    public void testCloneReturnsNewObjects() {
        SudokuBox row = createSudokuBox();
        SudokuBox clone = row.clone();

        int oldValue = row.getValue(0);
        row.setValue(0, 5);

        assertEquals(clone.getValue(0), oldValue);
    }

    private SudokuBox createSudokuBox() {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        SudokuField[] fields = new SudokuField[9];
        for(int i=0; i<9; i++) {
            fields[i] = new SudokuField(values[i]);
        }

        return new SudokuBox(fields);
    }
}
