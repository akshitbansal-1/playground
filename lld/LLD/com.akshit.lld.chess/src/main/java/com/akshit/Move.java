package com.akshit;

import com.akshit.piece.Piece;

public class Move {
    Cell start;

    Cell end;

    Piece piece;

    Player player;

    public Move(Cell start, Cell end, Piece piece, Player player) {
        this.start = start;
        this.end = end;
        this.piece = piece;
        this.player = player;
    }

    public Cell getStart() {
        return start;
    }

    public void setStart(Cell start) {
        this.start = start;
    }

    public Cell getEnd() {
        return end;
    }

    public void setEnd(Cell end) {
        this.end = end;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Player getPlayer() {
        return player;
    }
}
