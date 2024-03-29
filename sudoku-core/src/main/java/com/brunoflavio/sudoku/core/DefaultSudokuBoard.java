package com.brunoflavio.sudoku.core;

import java.util.Arrays;

class DefaultSudokuBoard implements SudokuBoard {

    private final CellValue[] board = new CellValue[9 * 9];

    public DefaultSudokuBoard() {
        Arrays.fill(this.board, SudokuBoard.EMPTY);
    }

    @Override
    public CellValue getCellValueAt(final int row, final int col) {
        return board[this.locateBoard(row, col)];
    }

    @Override
    public void setCellValueAt(final int row, final int col, final CellValue value) {
        board[this.locateBoard(row, col)] = value;
    }

    private int locateBoard(final int row, final int col) {
        return row * 9 + col;
    }
}

