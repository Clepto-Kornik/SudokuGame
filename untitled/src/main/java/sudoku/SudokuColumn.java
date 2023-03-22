package sudoku;

import java.util.Arrays;
import java.util.Comparator;

public class SudokuColumn {
    private SudokuField[] column;

    public SudokuColumn(SudokuField[] column) {
        this.column = column;
    }

    public SudokuField[] getColumn() {
        return column;
    }

    public boolean verify() {
        Arrays.sort(column, Comparator.comparingInt(SudokuField::getFieldValue));
        boolean isOk = true;
        int[] temp = {1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < 9; i++) {
            if (column[i].getFieldValue() != temp[i]) {
                isOk = false;
            }
        }
        return isOk;
    }
}

