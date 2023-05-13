package sudoku.group;

import sudoku.board.SudokuField;

public class SudokuColumn extends SudokuGroup {
    public SudokuColumn(SudokuField[] fields) {
        super(fields);
    }

    @Override
    public SudokuColumn clone() {
        return (SudokuColumn) super.clone();
    }
}
