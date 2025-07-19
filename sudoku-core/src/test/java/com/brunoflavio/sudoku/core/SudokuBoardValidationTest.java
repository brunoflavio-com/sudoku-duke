package com.brunoflavio.sudoku.core;

import com.brunoflavio.sudoku.core.boards.DefaultSudokuBoard;
import com.brunoflavio.sudoku.core.boards.DefaultValidatableSudokuBoard;
import com.brunoflavio.sudoku.core.boards.SudokuBoard;
import com.brunoflavio.sudoku.core.boards.ValidatableSudokuBoard;
import com.brunoflavio.sudoku.core.cells.EmptyCellValue;
import com.brunoflavio.sudoku.core.cells.FixedCellValue;
import com.brunoflavio.sudoku.core.cells.MutableCellValue;
import com.brunoflavio.sudoku.core.serializers.SudokuBoardStringDeserializer;
import org.junit.jupiter.api.Test;

import static com.brunoflavio.sudoku.core.TestUtils.assertNotNullThenPrint;
import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardValidationTest {

    @Test
    void shouldThrowExceptionWhenCreatingFixedCellValueWithInvalidValue() {
        // This should throw an exception when trying to create an invalid FixedCellValue
        assertThrows(IllegalArgumentException.class, () -> {
            new FixedCellValue(10);
        });
    }

    @Test
    void shouldPassWhenBoardIsCompletelyEmpty() {
        final String state = """
                -------+-------+-------
                 . . . | . . . | . . .
                 . . . | . . . | . . .
                 . . . | . . . | . . .
                -------+-------+-------
                 . . . | . . . | . . .
                 . . . | . . . | . . .
                 . . . | . . . | . . .
                -------+-------+-------
                 . . . | . . . | . . .
                 . . . | . . . | . . .
                 . . . | . . . | . . .
                """;

        final ValidatableSudokuBoard board = new DefaultValidatableSudokuBoard(SudokuBoardStringDeserializer.createFromState(state));
        assertNotNullThenPrint(board);
        assertTrue(board.isValid());
    }

    @Test
    void shouldThrowExceptionWhenCreatingFixedCellValueWithZero() {
        // This should throw an exception when trying to create a FixedCellValue with zero
        assertThrows(IllegalArgumentException.class, () -> {
            new FixedCellValue(0);
        });
    }

    @Test
    void shouldAllowEmptyValue() {
        // EmptyCellValue should be allowed
        assertDoesNotThrow(() -> {
            EmptyCellValue.getInstance();
        });
    }

    @Test
    void shouldThrowExceptionWhenCreatingFixedCellValueWithValueGreaterThanNine() {
        // This should throw an exception when trying to create a FixedCellValue > 9
        assertThrows(IllegalArgumentException.class, () -> {
            new FixedCellValue(15);
        });
    }

    @Test
    void shouldAllowValidSudokuValues() {
        // These should not throw exceptions
        assertDoesNotThrow(() -> new FixedCellValue(1));
        assertDoesNotThrow(() -> new FixedCellValue(5));
        assertDoesNotThrow(() -> new FixedCellValue(9));
    }

    @Test
    void shouldPassWhenBoardContainsValidValues() {
        // Create a board with valid values
        SudokuBoard board = new DefaultSudokuBoard();
        board.setCellValueAt(0, 0, new MutableCellValue(1));
        board.setCellValueAt(0, 1, new MutableCellValue(2));
        board.setCellValueAt(0, 2, new MutableCellValue(3));
        
        final ValidatableSudokuBoard validatableBoard = new DefaultValidatableSudokuBoard(board);
        assertNotNullThenPrint(validatableBoard);
        assertTrue(validatableBoard.isValid());
    }
} 