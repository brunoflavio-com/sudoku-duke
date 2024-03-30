package com.brunoflavio.sudoku.core;

import org.junit.jupiter.api.Test;

import static com.brunoflavio.sudoku.core.TestUtils.assertNotNullThenPrint;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SudokuBoardColumnValidationTest {


    @Test
    void testValidBoard() {
        final String state = """
                -------+-------+-------
                 1!5 2 | 4!8!9!| 3 7 6!
                 7!3!9 | 2 5!6 | 8 4!1
                 4 6 8 | 3 7 1!| 2!9!5!
                -------+-------+-------
                 3 8 7!| 1!2!4 | 6!5 9
                 5!9 1 | 7!6 3!| 4 2 8!
                 2 4 6!| 8 9!5!| 7!1 3
                -------+-------+-------
                 9!1!4!| 6!3 7 | 5 8 2
                 6 2! 5| 9 4 8 | 1 3!7!
                 8!7 3 | 5!1!2!| 9 6 4!
                """;

        final ValidatableSudokuBoard board = new DefaultValidatableSudokuBoard(SudokuBoardStringDeserializer.createFromState(state));
        assertNotNullThenPrint(board);
        assertTrue(board.isValid());
    }


    @Test
    void testSameNumberTwiceInColumn() {
        final String state = """
                -------+-------+-------
                 1!. . | . . . | . . .
                 1 . . | . . . | . . .
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
        assertFalse(board.isValid());
    }

    @Test
    void testSameNumberTwiceInColumn2() {
        final String state = """
                -------+-------+-------
                 6!. . | . . . | . . 1
                 . . . | . . . | . . 2
                 . . . | . . . | . . 3
                -------+-------+-------
                 . . . | . . . | . . 4
                 5 . . | . . . | . . 9
                 . . . | . . . | . . 6
                -------+-------+-------
                 . . . | . . . | . . 7
                 9 . . | . . . | . . 8
                 . . . | . . . | . . 9
                """;

        final ValidatableSudokuBoard board = new DefaultValidatableSudokuBoard(SudokuBoardStringDeserializer.createFromState(state));
        assertNotNullThenPrint(board);
        assertFalse(board.isValid());
    }

    @Test
    void testSameNumberTwiceInRow() {
        final String state = """
                -------+-------+-------
                 1!. . | . . . | . . 1
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
        assertFalse(board.isValid());
    }

    @Test
    void testSameNumberTwiceInRow2() {
        final String state = """
                -------+-------+-------
                 . . . | . . . | . . .
                 . 4 . | . 6 . | . 9 .
                 . . . | . . . | . . .
                -------+-------+-------
                 . . . | . . . | . . .
                 . . . | . . . | . . .
                 . . . | . . . | . . .
                -------+-------+-------
                 . . . | . . . | . . .
                 . . . | . . . | . . .
                 1 2 3 | 4 5 6 | 7 8 6
                """;

        final ValidatableSudokuBoard board = new DefaultValidatableSudokuBoard(SudokuBoardStringDeserializer.createFromState(state));
        assertNotNullThenPrint(board);
        assertFalse(board.isValid());
    }
}
