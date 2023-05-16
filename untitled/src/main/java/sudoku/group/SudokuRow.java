package sudoku.group;

import sudoku.board.SudokuField;

public class SudokuRow extends SudokuGroup {
    public SudokuRow(SudokuField[] fields) {
        super(fields);
    }

    @Override
    public SudokuRow clone() {
        return (SudokuRow) super.clone();
    }
}
