package com.brunoflavio.sudoku.core.validations;

import com.brunoflavio.sudoku.core.SudokuBoard;

public interface Validator {
    boolean validate(SudokuBoard defaultSudokuBoard);
}
