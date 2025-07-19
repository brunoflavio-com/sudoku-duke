package com.brunoflavio.sudoku.core;

import com.brunoflavio.sudoku.core.boards.SudokuBoard;
import com.brunoflavio.sudoku.core.serializers.SudokuBoardStringSerializer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestUtils {
    public static void assertNotNullThenPrint(final SudokuBoard board) {
        assertNotNull(board);
        System.out.println(SudokuBoardStringSerializer.prettyPrint(board));
    }
}
