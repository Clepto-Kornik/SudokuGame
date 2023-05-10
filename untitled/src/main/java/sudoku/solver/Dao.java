package sudoku.solver;

import sudoku.board.SudokuBoard;

public interface Dao {
    SudokuBoard read();

    void write(SudokuBoard temp);
}
