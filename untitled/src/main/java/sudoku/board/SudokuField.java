package sudoku.board;

import sudoku.group.SudokuGroup;

public class SudokuField {
    private int value;

    public SudokuField(int value) {
        this.value = value;
    }

    public SudokuField() {
        this(0);
    }

    public int getFieldValue() {
        return value;
    }

    public void setFieldValue(int value) {
        this.value = value;
    }

    @Override
    public SudokuField clone () throws CloneNotSupportedException {
        SudokuField clone = (SudokuField) super.clone();
        return clone;
    }
}