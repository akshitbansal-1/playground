package com.akshit.piece;

import com.akshit.Board;
import com.akshit.Cell;
import com.akshit.Color;
import com.akshit.State;

public class PawnPiece extends Piece {

    public PawnPiece(Color color, State state) {
        super(color, state);
    }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        if (start.getRow() < end.getRow() || end.getRow() - start.getRow() > 2) {
            return false;
        }

        return true;
    }
}
