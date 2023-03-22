package sudoku;

import java.util.Arrays;
import java.util.Comparator;

public class SudokuBox {
    private SudokuField[] box;

    public SudokuBox(SudokuField[] row) {
        this.box = row;
    }

    public SudokuField[] getBox() {
        return box;
    }

    public boolean verify() {
        Arrays.sort(box, Comparator.comparingInt(SudokuField::getFieldValue));
        boolean isOk = true;
        int[] temp = {1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < 9; i++) {
            if (box[i].getFieldValue() != temp[i]) {
                isOk = false;
            }
        }
        return isOk;
    }
}
