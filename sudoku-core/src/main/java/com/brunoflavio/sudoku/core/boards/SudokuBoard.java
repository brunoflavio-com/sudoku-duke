package com.brunoflavio.sudoku.core.boards;

import com.brunoflavio.sudoku.core.cells.CellValue;
import com.brunoflavio.sudoku.core.cells.EmptyCellValue;

public interface SudokuBoard {
    CellValue EMPTY = EmptyCellValue.getInstance();

    CellValue getCellValueAt(int row, int col);

    void setCellValueAt(int row, int col, CellValue value);
}
