package com.brunoflavio.sudoku.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SudokuBoardStringDeserializer {
    public static SudokuBoard createFromState(final String state) {
        final SudokuBoard newBoard = new DefaultSudokuBoard();

        //get all 1-9 digits, which may be followed by the fixed (!) symbol
        final String regex = "(\\.|[1-9]!?)";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(state);

        int i = 0;
        while (matcher.find()) {
            final var cell = matcher.group();

            newBoard.setCellValueAt(i / 9, i % 9, parseCellValue(cell));
            i++;
        }

        return newBoard;
    }

    private static CellValue parseCellValue(final String cell) {

        if (SudokuBoardStringSerializer.EMPTY_INDICATOR.equals(cell)) return SudokuBoard.EMPTY;

        return new CellValue(Integer.parseInt(cell.substring(0,1)), cell.contains(SudokuBoardStringSerializer.FIXED_INDICATOR));
    }
}
