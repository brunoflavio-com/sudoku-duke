package com.brunoflavio.sudoku.core.cells;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MutableCellValueTest {

    @Test
    void shouldCreateMutableCellValueWithValidValue() {
        MutableCellValue cellValue = new MutableCellValue(5);
        assertEquals(5, cellValue.getValue());
        assertFalse(cellValue.isFixed());
        assertTrue(cellValue.hasValue());
    }

    @Test
    void shouldThrowExceptionWhenCreatingMutableCellValueWithInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> new MutableCellValue(10));
        assertThrows(IllegalArgumentException.class, () -> new MutableCellValue(0));
        assertThrows(IllegalArgumentException.class, () -> new MutableCellValue(-1));
    }

    @Test
    void shouldAllowAllValidSudokuValues() {
        assertDoesNotThrow(() -> new MutableCellValue(1));
        assertDoesNotThrow(() -> new MutableCellValue(5));
        assertDoesNotThrow(() -> new MutableCellValue(9));
    }

    @Test
    void shouldHaveValue() {
        MutableCellValue cellValue = new MutableCellValue(5);
        assertTrue(cellValue.hasValue());
    }

    @Test
    void shouldHaveCorrectEquality() {
        MutableCellValue cell1 = new MutableCellValue(5);
        MutableCellValue cell2 = new MutableCellValue(5);
        MutableCellValue cell3 = new MutableCellValue(3);
        assertEquals(cell1, cell2);
        assertNotEquals(cell1, cell3);
        assertEquals(cell1.hashCode(), cell2.hashCode());
    }

    @Test
    void shouldHaveCorrectToString() {
        MutableCellValue cell = new MutableCellValue(7);
        assertEquals("MutableCellValue[value=7]", cell.toString());
    }
} 