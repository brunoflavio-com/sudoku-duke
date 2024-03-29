package com.brunoflavio.sudoku.core;

public class SudokuBoardStringSerializer {

    public static final String WHOLE_LINE_SEPARATOR = "|-------+-------+-------|\n";
    public static final String SEPARATOR = "| ";
    public static final String FIXED_INDICATOR = "!";
    public static final String EMPTY_INDICATOR = ".";


    public static String prettyPrint(final SudokuBoard board) {
        final StringBuilder builder = new StringBuilder();
        for (int row = 0; 9 > row; row++) {
            if (0 == row % 3) {
                builder.append(WHOLE_LINE_SEPARATOR);
            }
            for (int col = 0; 9 > col; col++) {
                if (0 == col % 3) {
                    builder.append(SEPARATOR);
                }
                final CellValue cellValue = board.getCellValueAt(row, col);
                final String value = -1 == cellValue.value() ? EMPTY_INDICATOR : Integer.toString(cellValue.value());
                builder.append(value);

                if (cellValue.isFixed()) builder.append(FIXED_INDICATOR);
                else builder.append(" ");
            }
            builder.append(SEPARATOR).append("\n");
        }
        builder.append(WHOLE_LINE_SEPARATOR);
        return builder.toString();
    }

}
