package com.brunoflavio.sudoku.core.boards;

import com.brunoflavio.sudoku.core.cells.CellValue;
import com.brunoflavio.sudoku.core.validations.StopAtFirstErrorValidationStrategy;
import com.brunoflavio.sudoku.core.validations.ValidationStrategy;

public class DefaultValidatableSudokuBoard implements ValidatableSudokuBoard {

    private final SudokuBoard board;
    private final ValidationStrategy validationStrategy;

    public DefaultValidatableSudokuBoard (SudokuBoard board) {
        this(board, new StopAtFirstErrorValidationStrategy());
    }

    public DefaultValidatableSudokuBoard (SudokuBoard board, ValidationStrategy validationStrategy) {
        this.board = board;
        this.validationStrategy = validationStrategy;
    }

    @Override
    public CellValue getCellValueAt(int row, int col) {
        return board.getCellValueAt(row, col);
    }

    @Override
    public void setCellValueAt(int row, int col, CellValue value) {
        board.setCellValueAt(row, col, value);
    }


    @Override
    public boolean isValid() {
        return validationStrategy.validate(this);
    }

}
