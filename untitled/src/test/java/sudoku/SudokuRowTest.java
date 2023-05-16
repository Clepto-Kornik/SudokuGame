package sudoku;

import org.junit.jupiter.api.Test;
import sudoku.board.SudokuField;
import sudoku.group.SudokuRow;

import static org.junit.jupiter.api.Assertions.*;
class SudokuRowTest {

    @Test
    public void testVerifyReturnsTrueForValidRow() {

        SudokuRow row = createSudokuRow(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        assertTrue(row.verify());
    }

    @Test
    public void testVerifyReturnsFalseForInvalidRow() {
        SudokuRow row = createSudokuRow(new int[]{1, 2, 2, 4, 5, 6, 7, 8, 9});
        assertFalse(row.verify());
    }

    @Test
    public void testCloneHasProperValue() {
        SudokuRow row = createSudokuRow(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        SudokuRow clone = row.clone();

        for (int i = 0; i < 9; i++) {
            assertEquals(row.getValue(i), clone.getValue(i));
        }
    }

    @Test
    public void testCloneReturnsNewObjects() {
        SudokuRow row = createSudokuRow(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        SudokuRow clone = row.clone();

        int oldValue = row.getValue(0);
        row.setValue(0, 5);

        assertEquals(clone.getValue(0), oldValue);
    }

    private SudokuRow createSudokuRow(int[] values) {
        SudokuField[] fields = new SudokuField[values.length];
        for (int i = 0; i < 9; i++) {
            fields[i] = new SudokuField(values[i]);
        }

        return new SudokuRow(fields);
    }
}
