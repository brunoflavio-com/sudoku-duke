package com.brunoflavio.sudoku.core.validations;

import com.brunoflavio.sudoku.core.boards.SudokuBoard;

import java.util.Arrays;
import java.util.List;

public class StopAtFirstErrorValidationStrategy implements ValidationStrategy {

    private final List<Validator> validators;

    public StopAtFirstErrorValidationStrategy() {
        this(new Validator[] {
                ColumnValidator.INSTANCE.getInstance(),
                RowValidator.INSTANCE.getInstance(),
                BoxValidator.INSTANCE.getInstance()
        });
    }

    public StopAtFirstErrorValidationStrategy(Validator[] validators) {
        this.validators = Arrays.asList(validators);
    }

    @Override
    public boolean validate(SudokuBoard board) {
        for (Validator validator : validators) {
            if (!validator.validate(board)) {
                return false; // Stop and return on the first failure
            }
        }
        return true; // All validators passed
    }
}

