package com.akshit;

import java.util.HashSet;
import java.util.Set;

public class Board {

    Cell[][] cells;

    int rows;
    int cols;

    public Board(int rows, int cols, int snakesCount, int laddersCount) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Invalid number of rows and columns");
        }
        if (snakesCount <= 0 || laddersCount <= 0) {
            throw new IllegalArgumentException("Invalid number of snakes and ladders");
        }
        this.rows = rows;
        this.cols = cols;
        initCells();
        initializeSnakesAndLadders(snakesCount, laddersCount);
    }

    private void initCells() {
        cells = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    private void initializeSnakesAndLadders(int snakesCount, int laddersCount) {
        int boardSize = this.rows * this.cols;

        while (snakesCount > 0) {
            int start = (int) (Math.random() * boardSize);
            int end = 1 + (int) (Math.random() * (start - 1));
            Cell startCell = getCell(start);
            if (startCell.jump != null) {
                continue;
            }
            startCell.jump = new Jump(start, end);
            snakesCount--;
        }

        while (laddersCount > 0) {
            int start = (int) (Math.random() * boardSize);
            int end = start + (int) (Math.random() * (boardSize - start + 1));
            Cell startCell = getCell(start);
            if (startCell.jump != null) {
                continue;
            }
            startCell.jump = new Jump(start, end);
            laddersCount--;
        }

    }

    public Cell getCell(int position) {
        int row = position / rows;
        int col = position % cols;
        return cells[row][col];
    }


    public boolean isPositionOutOfBoard(int newPlayerPosition) {
        return newPlayerPosition >= rows * cols;
    }
}
