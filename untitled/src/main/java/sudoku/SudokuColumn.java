package sudoku;

import java.util.Arrays;

public class SudokuColumn {
    private SudokuField[] column;

    public SudokuColumn(SudokuField[] column) {
        this.column = column;
    }

    public boolean verify() {
        Arrays.sort(column);
        boolean isOk = true;
        for (int i = 0; i < 8; i++) {
            if (column[i].getFieldValue() == i + 1) {
                isOk = false;
            }
        }
        return isOk;
    }
}

