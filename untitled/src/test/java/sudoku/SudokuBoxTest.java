package sudoku;

import org.junit.jupiter.api.Test;
import sudoku.board.SudokuField;
import sudoku.group.SudokuBox;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SudokuBoxTest {

    @Test
    public void testVerifyReturnsTrueForValidBox() {
        SudokuBox box = createSudokuBox(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        assertTrue(box.verify());
    }

    @Test
    public void testVerifyReturnsFalseForInvalidBox() {
        SudokuBox box = createSudokuBox(new int[]{1, 2, 2, 4, 5, 6, 7, 8, 9});
        assertFalse(box.verify());
    }

    @Test
    public void testCloneHasProperValue() {
        SudokuBox box = createSudokuBox(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        SudokuBox clone = box.clone();

        for (int i = 0; i < 9; i++) {
            assertEquals(box.getValue(i), clone.getValue(i));
        }
    }

    @Test
    public void testCloneReturnsNewObjects() {
        SudokuBox box = createSudokuBox(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        SudokuBox clone = box.clone();

        int oldValue = box.getValue(0);
        box.setValue(0, 5);

        assertEquals(clone.getValue(0), oldValue);
    }

    private SudokuBox createSudokuBox(int[] values) {
        SudokuField[] fields = new SudokuField[values.length];
        for (int i = 0; i < 9; i++) {
            fields[i] = new SudokuField(values[i]);
        }

        return new SudokuBox(fields);
    }
}
