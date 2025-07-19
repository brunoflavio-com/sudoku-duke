package com.brunoflavio.sudoku.core.cells;

public final class MutableCellValue implements CellValue {
    private final int value;
    
    public MutableCellValue(int value) {
        if (value < 1 || value > 9) {
            throw new IllegalArgumentException("Mutable cell value must be between 1 and 9. Got: " + value);
        }
        this.value = value;
    }
    
    @Override
    public boolean hasValue() {
        return true;
    }
    
    @Override
    public boolean isFixed() {
        return false;
    }
    
    @Override
    public int getValue() {
        return value;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MutableCellValue that = (MutableCellValue) obj;
        return value == that.value;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
    
    @Override
    public String toString() {
        return "MutableCellValue[value=" + value + "]";
    }
} 