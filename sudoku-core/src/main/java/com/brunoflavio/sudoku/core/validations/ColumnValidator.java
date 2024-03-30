package com.brunoflavio.sudoku.core.validations;

import com.brunoflavio.sudoku.core.CellValue;
import com.brunoflavio.sudoku.core.SudokuBoard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum ColumnValidator implements Validator {
    INSTANCE;

    public Validator getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean validate(SudokuBoard board) {
        return validateColumns(board);
    }

    private boolean validateColumns(SudokuBoard board) {
        for (int col=0; col < 9; col++){
            List<Integer> values = retrieveColumnValues(board, col);
            if (containsDuplicates(values)) return false;
        }
        return true;
    }

    private List<Integer> retrieveColumnValues(SudokuBoard board, int col) {
        List<Integer> values = new ArrayList<>(9);
        for (int row=0; row <9; row++){
            CellValue cellValue = board.getCellValueAt(row,col);
            if (cellValue != SudokuBoard.EMPTY)
                values.add(cellValue.value());
        }
        return values;
    }

    private boolean containsDuplicates(List<Integer> values) {
        Set<Integer> uniqueValues = new HashSet<>(values);
        return uniqueValues.size() < values.size();
    }
}
