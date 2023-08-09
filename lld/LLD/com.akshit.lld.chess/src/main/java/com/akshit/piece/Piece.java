package com.akshit.piece;

import com.akshit.Board;
import com.akshit.Cell;
import com.akshit.Color;
import com.akshit.State;

public abstract class Piece {
    Color color;

    State state;

    public Piece(Color color, State state) {
        this.color = color;
        this.state = state;
    }

    public abstract boolean canMove(Board board, Cell start, Cell end);

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
