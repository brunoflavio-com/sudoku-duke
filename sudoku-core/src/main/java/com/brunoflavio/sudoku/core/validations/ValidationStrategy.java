package com.brunoflavio.sudoku.core.validations;

import com.brunoflavio.sudoku.core.boards.SudokuBoard;

public interface ValidationStrategy {
    boolean validate(SudokuBoard board);
}
