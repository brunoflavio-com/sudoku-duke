package com.brunoflavio.sudoku.core;

public interface SudokuBoard {
    CellValue EMPTY = new CellValue(-1, false);

    CellValue getCellValueAt(int row, int col);

    void setCellValueAt(int row, int col, CellValue value);
}
