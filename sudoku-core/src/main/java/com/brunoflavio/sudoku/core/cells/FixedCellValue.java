package com.brunoflavio.sudoku.core.cells;

public final class FixedCellValue implements CellValue {
    private final int value;
    
    public FixedCellValue(int value) {
        if (value < 1 || value > 9) {
            throw new IllegalArgumentException("Fixed cell value must be between 1 and 9. Got: " + value);
        }
        this.value = value;
    }
    
    @Override
    public boolean hasValue() {
        return true;
    }
    
    @Override
    public boolean isFixed() {
        return true;
    }
    
    @Override
    public int getValue() {
        return value;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FixedCellValue that = (FixedCellValue) obj;
        return value == that.value;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
    
    @Override
    public String toString() {
        return "FixedCellValue[value=" + value + "]";
    }
} 