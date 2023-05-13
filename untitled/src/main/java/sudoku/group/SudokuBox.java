package sudoku.group;

import sudoku.board.SudokuField;

public class SudokuBox extends SudokuGroup {
    public SudokuBox(SudokuField[] fields) {
        super(fields);
    }

    @Override
    public SudokuBox clone() {
        return (SudokuBox) super.clone();
    }
}
