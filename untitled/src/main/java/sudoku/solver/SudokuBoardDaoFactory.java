package sudoku.solver;

import sudoku.board.SudokuBoard;

public class SudokuBoardDaoFactory {
    public FileSudokuBoardDao getFileDao(String fileName) {
        FileSudokuBoardDao fileSudoku = new FileSudokuBoardDao(fileName);
        return fileSudoku;
    }
}
