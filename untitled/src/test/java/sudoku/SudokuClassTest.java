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
        //sudoku1.printBoard();  uncomment this to print board
        SudokuRow sudokuRow = new SudokuRow (sudoku1.getRow(0).getRow());
        if (sudokuRow.verify() == false) fail("The row is broken"); //test checking if sudokuRow finds any errors in good sudoku
        SudokuColumn sudokuColumn = new SudokuColumn (sudoku1.getColumn(0).getColumn());
        if (sudokuColumn.verify() == false) fail("The column is broken"); //test checking if sudokuColumn finds any errors in good sudoku
        SudokuField newField = new SudokuField (1);
        for (int i = 0; i < 9; i++){
            sudoku1.set(0,i,newField);
        }
        //sudoku1.printBoard(); uncomment this to print board
        SudokuColumn sudokuColumnBroken = new SudokuColumn (sudoku1.getColumn(0).getColumn());
        SudokuRow sudokuRowBroken = new SudokuRow (sudoku1.getRow(0).getRow());
        if (sudokuRowBroken.verify() != false) fail("The row is broken but I dont see it");  //test checking if sudokuRow finds any errors in bad sudoku
        if (sudokuColumnBroken.verify() != false) fail("The column is broken but I dont see it"); //test checking if sudokuColumn finds any errors in bad sudoku
        sudoku2.solveGame();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(sudoku1.get(i,j).getFieldValue() == sudoku2.get(i,j).getFieldValue()){
                    flag ++;
                }
            }
        }
        if (flag == 81) fail("The 2 sudokus generated are the same"); //test checking if 2 generated sudoku are the same
    }
}
