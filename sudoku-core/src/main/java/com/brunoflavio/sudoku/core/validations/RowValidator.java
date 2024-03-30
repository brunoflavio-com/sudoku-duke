package com.brunoflavio.sudoku.core.validations;

import com.brunoflavio.sudoku.core.CellValue;
import com.brunoflavio.sudoku.core.SudokuBoard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum RowValidator implements Validator {
    INSTANCE;

    public Validator getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean validate(SudokuBoard board) {
        return validateRows(board);
    }

    private boolean validateRows(SudokuBoard board) {
        for (int row=0; row < 9; row++){
            List<Integer> values = retrieveRowValues(board, row);
            if (containsDuplicates(values)) return false;
        }
        return true;
    }

    private List<Integer> retrieveRowValues(SudokuBoard board, int row) {
        List<Integer> values = new ArrayList<>(9);
        for (int col=0; col <9; col++){
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
