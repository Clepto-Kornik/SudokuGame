package sudoku.board;

import sudoku.group.SudokuBox;
import sudoku.group.SudokuColumn;
import sudoku.group.SudokuRow;
import sudoku.solver.BacktrackSudokuSolver;

public class SudokuBoard implements Cloneable {
    public static final int SIZE = 9;
    private SudokuField[][] fields = new SudokuField[SIZE][SIZE];

    public SudokuBoard() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                fields[y][x] = new SudokuField();
            }
        }
    }

    public static SudokuBoard copyBoard(SudokuBoard otherBoard) {
        return otherBoard.clone();
    }

    public void printBoard() {
        for (int y = 0; y < SIZE; y++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(get(j, y) + " ");
                if (j == 2 || j == 5) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if (y == 2 || y == 5) {
                System.out.println("---------------------");
            }
        }
        System.out.println();
    }

    public void set(int x, int y, int value) {
        fields[y][x].setFieldValue(value);
    }

    public int get(int x, int y) {
        return fields[y][x].getFieldValue();
    }

    public void solveGame() {
        BacktrackSudokuSolver solver = new BacktrackSudokuSolver();
        solver.solve(this);
    }

    public SudokuRow getRow(int y) {
        return new SudokuRow(fields[y]);
    }

    public SudokuColumn getColumn(int x) {
        SudokuField[] columnFields = new SudokuField[SIZE];
        for (int i = 0; i < SIZE; i++) {
            columnFields[i] = fields[i][x];
        }
        return new SudokuColumn(columnFields);
    }

    public SudokuBox getBox(int x, int y) {
        int startX = x * 3;
        int startY = y * 3;

        SudokuField[] boxFields = new SudokuField[9];
        for (int offsetY = 0; offsetY < 3; offsetY++) {
            for (int offsetX = 0; offsetX < 3; offsetX++) {
                int linearIndex = offsetY * 3 + offsetX;
                boxFields[linearIndex] = fields[startY + offsetY][startX + offsetX];
            }
        }

        return new SudokuBox(boxFields);
    }

    public boolean checkBoard() {
        for (int i = 0; i < SIZE; i++) {
            if (!getColumn(i).verify() || !getRow(i).verify()) {
                return false;
            }
        }

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (!getBox(x, y).verify()) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public SudokuBoard clone () {
        try {
            SudokuBoard clone = (SudokuBoard) super.clone();

            clone.fields = new SudokuField[SIZE][SIZE];
            for(int y=0; y<SIZE; y++) {
                for(int x=0; x<SIZE; x++) {
                    clone.fields[y][x] = this.fields[y][x].clone();
                }
            }

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
