package com.brunoflavio.sudoku.core.validations;

import com.brunoflavio.sudoku.core.boards.SudokuBoard;

public interface Validator {
    boolean validate(SudokuBoard defaultSudokuBoard);
}
