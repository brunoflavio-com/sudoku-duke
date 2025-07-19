package com.brunoflavio.sudoku.core.cells;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedCellValueTest {

    @Test
    void shouldCreateFixedCellValueWithValidValue() {
        FixedCellValue cellValue = new FixedCellValue(5);
        assertEquals(5, cellValue.getValue());
        assertTrue(cellValue.isFixed());
    }

    @Test
    void shouldThrowExceptionWhenCreatingFixedCellValueWithInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new FixedCellValue(10);
        });
    }

    @Test
    void shouldThrowExceptionWhenCreatingFixedCellValueWithZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new FixedCellValue(0);
        });
    }

    @Test
    void shouldThrowExceptionWhenCreatingFixedCellValueWithNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new FixedCellValue(-1);
        });
    }

    @Test
    void shouldAllowAllValidSudokuValues() {
        assertDoesNotThrow(() -> new FixedCellValue(1));
        assertDoesNotThrow(() -> new FixedCellValue(5));
        assertDoesNotThrow(() -> new FixedCellValue(9));
    }

    @Test
    void shouldHaveValue() {
        FixedCellValue cellValue = new FixedCellValue(5);
        assertTrue(cellValue.hasValue());
    }

    @Test
    void shouldHaveCorrectEquality() {
        FixedCellValue cell1 = new FixedCellValue(5);
        FixedCellValue cell2 = new FixedCellValue(5);
        FixedCellValue cell3 = new FixedCellValue(3);
        
        assertEquals(cell1, cell2);
        assertNotEquals(cell1, cell3);
        assertEquals(cell1.hashCode(), cell2.hashCode());
    }
} 