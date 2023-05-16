package sudoku.group;

import sudoku.board.SudokuField;

public abstract class SudokuGroup implements Cloneable {
    private SudokuField[] fields;

    public SudokuGroup(SudokuField[] fields) {
        this.fields = fields;
    }

    public boolean verify() {
        int[] counters = new int[10];
        for (SudokuField field : fields) {
            int value = field.getFieldValue();
            counters[value]++;
            if (value != 0 && counters[value] > 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public SudokuGroup clone() {
        try {
            SudokuGroup clone = (SudokuGroup) super.clone();
            clone.fields = clone.fields.clone();
            for (int i = 0; i < clone.fields.length; i++) {
                clone.fields[i] = clone.fields[i].clone();
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setValue(int index, int value) {
        fields[index].setFieldValue(value);
    }

    public int getValue(int index) {
        return fields[index].getFieldValue();
    }
}
