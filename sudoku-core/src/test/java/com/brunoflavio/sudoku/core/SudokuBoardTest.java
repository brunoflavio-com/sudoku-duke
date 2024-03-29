package com.brunoflavio.sudoku.core;

import org.junit.jupiter.api.Test;

import static com.brunoflavio.sudoku.core.TestUtils.assertNotNullThenPrint;
import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {

    @Test
    void testSudokuBoard() {
        SudokuBoard board = new DefaultSudokuBoard();
        assertNotNullThenPrint(board);
        assertEquals(SudokuBoard.EMPTY, board.getCellValueAt(0, 0));
    }

    @Test
    void testSudokuBoardEmptyStateString() {
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

        SudokuBoard board = SudokuBoardStringDeserializer.createFromState(state);
        assertNotNullThenPrint(board);
        assertEquals(SudokuBoard.EMPTY, board.getCellValueAt(0, 0));
    }

    @Test
    void testSudokuBoardDiagonalValueString() {
        final String state = """
                -------+-------+-------
                 1 . . | . . . | . . .
                 . 2 . | . . . | . . .
                 . . 3 | . . . | . . .
                -------+-------+-------
                 . . . | 4 . . | . . .
                 . . . | . 5 . | . . .
                 . . . | . . 6 | . . .
                -------+-------+-------
                 . . . | . . . | 7 . .
                 . . . | . . . | . 8 .
                 . . . | . . . | . . 9
                """;

        SudokuBoard board = SudokuBoardStringDeserializer.createFromState(state);
        assertNotNullThenPrint(board);
        //check that the diagonal values are correct
        for (int i = 0; 9 > i; i++) {
            var cell = board.getCellValueAt(i, i);
            assertEquals(i + 1, cell.value());
            assertFalse(cell.isFixed());
        }

        //check that other values are empty
        for (int col = 0; 9 > col; col++) {
            for (int row = 0; 9 > row; row++) {
                if (row != col) {
                    assertEquals(SudokuBoard.EMPTY, board.getCellValueAt(row, col));
                }
            }
        }
    }

    @Test
    void testSudokuBoardFullBoardString() {
        final String state = """
                -------+-------+-------
                 1 2 3 | 4 5 6 | 7 8 9
                 4 5 6 | 7 8 9 | 1 2 3
                 7 8 9 | 1 2 3 | 4 5 6
                -------+-------+-------
                 2 3 4 | 5 6 7 | 8 9 1
                 5 6 7 | 8 9 1 | 2 3 4
                 8 9 1 | 2 3 4 | 5 6 7
                -------+-------+-------
                 3 4 5 | 6 7 8 | 9 1 2
                 6 7 8 | 9 1 2 | 3 4 5
                 9 1 2 | 3 4 5 | 6 7 8
                """;

        SudokuBoard board = SudokuBoardStringDeserializer.createFromState(state);
        assertNotNullThenPrint(board);

        //check that there are no empty cells
        for (int col = 0; 9 > col; col++) {
            for (int row = 0; 9 > row; row++) {
                assertNotEquals(SudokuBoard.EMPTY, board.getCellValueAt(row, col), "Cell at row " + row + " and column " + col + " is not empty");
            }
        }
    }

    @Test
    void testSudokuBoardFullBoardStringWithFixedValue() {
        final String state = """
                -------+-------+-------
                 1!. . | . . . | . . .
                 . 2!. | . . . | . . .
                 . . 3!| . . . | . . .
                -------+-------+-------
                 . . . | 4! . .| . . .
                 . . . | . 5!. | . . .
                 . . . | . . 6!| . . .
                -------+-------+-------
                 . . . | . . . | 7!. .
                 . . . | . . . | . 8!.
                 . . . | . . . | . . 9!
                """;

        SudokuBoard board = SudokuBoardStringDeserializer.createFromState(state);
        assertNotNullThenPrint(board);
        //check that the diagonal values are correct
        for (int i = 0; 9 > i; i++) {
            var cell = board.getCellValueAt(i, i);
            assertEquals(i + 1, cell.value());
            assertTrue(cell.isFixed());
        }

        //check that other values are empty
        for (int col = 0; 9 > col; col++) {
            for (int row = 0; 9 > row; row++) {
                if (row != col) {
                    assertEquals(SudokuBoard.EMPTY, board.getCellValueAt(row, col));
                }
            }
        }
    }
}