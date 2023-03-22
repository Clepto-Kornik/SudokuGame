package sudoku;

import java.util.Arrays;
import java.util.Comparator;

public class SudokuRow {
    private SudokuField[] row;

    public SudokuRow(SudokuField[] row) {
        this.row = row;
    }

    public SudokuField[] getRow() {
        return row;
    }

    public boolean verify() {
        Arrays.sort(row, Comparator.comparingInt(SudokuField::getFieldValue));
        boolean isOk = true;
        int[] temp = {1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < 9; i++) {
            if (row[i].getFieldValue() != temp[i]) {
                isOk = false;
            }
        }
        return isOk;
    }
}