package sudoku;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SudokuClassTest {

    @Test
    public void CompareSudoku() {

        int rows = 9;
        int columns = 9;

        SudokuBoard sudoku1 = new SudokuBoard(rows, columns);
        SudokuBoard sudoku2 = new SudokuBoard(rows, columns);
        int flag = 0;
        sudoku1.solveGame();
        sudoku1.printBoard();
       // sudoku2.solveGame();
        /*for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(sudoku1.get(i,j) == sudoku2.get(i,j)){
                    flag ++;
                }
            }
        }
        if (flag == 81) fail("The 2 sudokus are the same");*/
    }
}
