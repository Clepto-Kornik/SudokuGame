package sudoku.solver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import sudoku.board.SudokuBoard;

public class FileSudokuBoardDao implements Dao {

    private String fileName;

    public FileSudokuBoardDao(String fileName) {
        this.fileName = fileName;
    }

    public SudokuBoard read() {
        SudokuBoard board = new SudokuBoard();
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String line;
            int row;
            int column;
            for (row = 0; row < 9; row++) {
                line = in.readLine();
                for (column = 0; column < line.length(); column++) {
                    int value = Character.getNumericValue(line.charAt(column));
                    board.set(row, column, value);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        return board;
    }

    public void write(SudokuBoard board) {
        int row;
        int column;
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            for (row = 0; row < 9; row++) {
                for (column = 0; column < 9; column++) {
                    out.print(board.get(row,column));
                }
                out.println();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public void finalise() {
        String kappa;
    }
}
