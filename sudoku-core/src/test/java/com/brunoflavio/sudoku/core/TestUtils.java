package com.brunoflavio.sudoku.core;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TestUtils {
    public static void assertNotNullThenPrint(final SudokuBoard board) {
        assertNotNull(board);
        System.out.println(SudokuBoardStringSerializer.prettyPrint(board));
    }
}
