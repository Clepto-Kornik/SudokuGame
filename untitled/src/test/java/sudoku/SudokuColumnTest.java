package sudoku;

import org.junit.jupiter.api.Test;
import sudoku.board.SudokuField;
import sudoku.group.SudokuColumn;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SudokuColumnTest {

    @Test
    public void testVerifyReturnsTrueForValidColumn() {

        SudokuColumn column = createSudokuColumn(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        assertTrue(column.verify());
    }

    @Test
    public void testVerifyReturnsFalseForInvalidColumn() {
        SudokuColumn column = createSudokuColumn(new int[]{1, 2, 2, 4, 5, 6, 7, 8, 9});
        assertFalse(column.verify());
    }

    @Test
    public void testCloneHasProperValue() {
        SudokuColumn column = createSudokuColumn(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        SudokuColumn clone = column.clone();

        for (int i = 0; i < 9; i++) {
            assertEquals(column.getValue(i), clone.getValue(i));
        }
    }

    @Test
    public void testCloneReturnsNewObjects() {
        SudokuColumn column = createSudokuColumn(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        SudokuColumn clone = column.clone();

        int oldValue = column.getValue(0);
        column.setValue(0, 5);

        assertEquals(clone.getValue(0), oldValue);
    }

    private SudokuColumn createSudokuColumn(int[] values) {
        SudokuField[] fields = new SudokuField[values.length];

        for (int i = 0; i < 9; i++) {
            fields[i] = new SudokuField(values[i]);
        }

        return new SudokuColumn(fields);
    }
}
