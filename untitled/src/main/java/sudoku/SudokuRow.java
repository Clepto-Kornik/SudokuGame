package sudoku;

import java.util.Arrays;

public class SudokuRow {
    private SudokuField[] row;

    public SudokuRow(SudokuField[] row) {
        this.row = row;
    }

    public boolean verify() {
        Arrays.sort(row);
        boolean isOk = true;
        for (int i = 0; i < 8; i++) {
            if (row[i].getFieldValue() == i + 1) {
                isOk = false;
            }
        }
        return isOk;
    }
}