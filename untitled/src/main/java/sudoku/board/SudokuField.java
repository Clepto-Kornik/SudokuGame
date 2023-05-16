package sudoku.board;


public class SudokuField implements Comparable<SudokuField>, Cloneable {
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
    public SudokuField clone() {
        try {
            return (SudokuField) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int compareTo(SudokuField other) {
        return this.getFieldValue() - other.getFieldValue();
    }
}