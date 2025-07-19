package com.brunoflavio.sudoku.core.validations;

import com.brunoflavio.sudoku.core.cells.CellValue;
import com.brunoflavio.sudoku.core.boards.SudokuBoard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum BoxValidator implements Validator {
    INSTANCE;

    public Validator getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean validate(SudokuBoard board) {
        return validateBoxes(board);
    }

    private boolean validateBoxes(SudokuBoard board) {
        final int boxSize = 3;

        for (int row=0; row < 9; row+=boxSize){
            for (int col=0; col < 9; col+=boxSize) {
                List<Integer> values = retrieveBoxValues(board, row, col, boxSize);
                if (containsDuplicates(values)) return false;
            }
        }
        return true;
    }

    private List<Integer> retrieveBoxValues(SudokuBoard board, int rowStart, int colStart, int boxSize) {
        List<Integer> values = new ArrayList<>(boxSize*boxSize);
        for(int row=rowStart; row < rowStart+boxSize; row++) {
            for (int col = colStart; col < colStart + boxSize; col++) {
                CellValue cellValue = board.getCellValueAt(row, col);
                if (cellValue.hasValue())
                    values.add(cellValue.getValue());
            }
        }
        return values;
    }

    private boolean containsDuplicates(List<Integer> values) {
        Set<Integer> uniqueValues = new HashSet<>(values);
        return uniqueValues.size() < values.size();
    }
}
