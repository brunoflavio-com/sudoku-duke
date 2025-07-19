package com.brunoflavio.sudoku.core.cells;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmptyCellValueTest {

    @Test
    void shouldReturnSameInstance() {
        EmptyCellValue instance1 = EmptyCellValue.getInstance();
        EmptyCellValue instance2 = EmptyCellValue.getInstance();
        
        assertSame(instance1, instance2);
    }

    @Test
    void shouldNotBeFixed() {
        EmptyCellValue emptyCell = EmptyCellValue.getInstance();
        assertFalse(emptyCell.isFixed());
    }

    @Test
    void shouldHaveCorrectEquality() {
        EmptyCellValue instance1 = EmptyCellValue.getInstance();
        EmptyCellValue instance2 = EmptyCellValue.getInstance();
        
        assertEquals(instance1, instance2);
        assertEquals(instance1.hashCode(), instance2.hashCode());
    }

    @Test
    void shouldHaveCorrectToString() {
        EmptyCellValue emptyCell = EmptyCellValue.getInstance();
        assertEquals("EmptyCellValue", emptyCell.toString());
    }

    @Test
    void shouldNotHaveValue() {
        EmptyCellValue emptyCell = EmptyCellValue.getInstance();
        assertFalse(emptyCell.hasValue());
    }

    @Test
    void shouldThrowWhenGettingValue() {
        EmptyCellValue emptyCell = EmptyCellValue.getInstance();
        assertThrows(UnsupportedOperationException.class, emptyCell::getValue);
    }
} 