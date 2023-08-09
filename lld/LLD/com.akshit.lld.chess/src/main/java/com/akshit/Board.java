package com.akshit;

import com.akshit.piece.PawnPiece;
import com.akshit.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {

    Cell[][] cells;

    List<Piece> pieces;

    int rows, cols;

    Board(int rows, int cols) {
        cells = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
        this.rows = rows;
        this.cols = cols;
        initPieces();
    }

    private void initPieces() {
        pieces = new ArrayList<>();
        for (int i = 0; i < cols; i++) {
            Piece piece1 = new PawnPiece(Color.WHITE, State.ALIVE);
            Piece piece2 = new PawnPiece(Color.WHITE, State.ALIVE);
            cells[1][i].setPiece(piece1);
            cells[rows-2][i].setPiece(piece2);
        }

        // TODO: init another pieces

    }

    public void setPiece(int row, int col, Piece piece) {
        cells[row][col].setPiece(piece);
    }

    public boolean canSetPiece(int row, int col, Piece piece) {
        return cells[row][col].getPiece() == null;
    }

    public Cell getCell(int newRow, int newCol) {
        return cells[newRow][newCol];
    }
}
