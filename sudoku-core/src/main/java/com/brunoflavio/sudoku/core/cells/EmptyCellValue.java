package com.brunoflavio.sudoku.core.cells;

public final class EmptyCellValue implements CellValue {
    private static final EmptyCellValue INSTANCE = new EmptyCellValue();
    
    private EmptyCellValue() {}
    
    public static EmptyCellValue getInstance() {
        return INSTANCE;
    }
    
    @Override
    public boolean hasValue() {
        return false;
    }
    
    @Override
    public boolean isFixed() {
        return false;
    }
    
    @Override
    public int getValue() {
        throw new UnsupportedOperationException("EmptyCellValue has no numeric value");
    }
    
    @Override
    public boolean equals(Object obj) {
        return this == obj; // Singleton pattern
    }
    
    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }
    
    @Override
    public String toString() {
        return "EmptyCellValue";
    }
} 