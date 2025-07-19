package com.brunoflavio.sudoku.core.cells;

public interface CellValue {
    boolean hasValue();
    boolean isFixed();
    int getValue();
}
