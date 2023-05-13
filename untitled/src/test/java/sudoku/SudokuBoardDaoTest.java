package sudoku;

import org.junit.jupiter.api.Test;
import sudoku.board.SudokuBoard;
import sudoku.solver.SudokuBoardDaoFactory;

import static org.junit.jupiter.api.Assertions.*;
class SudokuBoardDaoTest {

    @Test
    public void testSavingAndReadingDao() {
        SudokuBoard board = new SudokuBoard();
        SudokuBoard board2 = new SudokuBoard();
        board = board2;
        board.solveGame();
        board.printBoard();
        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
        String fileName = "sudokuSaveFile.txt";

        //FileSudokuBoardDao BoardDao = new FileSudokuBoardDao(fileName);
        factory.getFileDao(fileName).write(board);
        board = factory.getFileDao(fileName).read();
        boolean flag = true;
        for (int x=0;x<9;x++) {
            for (int y=0;y<9;y++) {
                if (board.get(x,y) != board2.get(x,y)) {
                        flag = false;
                }
            }
        }
        System.out.println("\nKURWA\n");
        board.printBoard();
        assertTrue(flag);
    }
}

