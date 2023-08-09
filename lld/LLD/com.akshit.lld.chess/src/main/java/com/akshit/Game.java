package com.akshit;

import com.akshit.piece.PawnPiece;
import com.akshit.piece.Piece;

import java.util.List;

public class Game {

    Board board;

    Player player1;
    Player player2;

    Player playerTurn;

    Player winner;

    boolean started;

    public void addPlayer(Player player) {
        if (started) {
            throw new IllegalStateException("Game is already started");
        }
        if (player == null) {
            throw new IllegalArgumentException("Invalid value for player");
        }
        if (player1 == null) {
            player1 = player;
            playerTurn = player1;
            player1.setColor(Color.WHITE);
            return;
        }
        if (player2 == null) {
            player2 = player;
            player2.setColor(Color.BLACK);
            return;
        }
        throw new IllegalArgumentException("Can't have more than two players");
    }

    public void startGame() {
        started = true;
        if (player1 == null || player2 == null) {
            throw new IllegalStateException("Not enough players to start the game");
        }
    }

    public boolean makeMove(Player player, int currentRow, int currentCol, int newRow, int newCol, Piece piece) {
        if (winner != null) {
            return false;
        }

        if (piece == null || player == null) {
            throw new IllegalArgumentException("Invalid values given");
        }
        Move move = getMove(player, currentRow, currentCol, newRow, newCol, piece);

        if (move.getPlayer() != playerTurn) {
            return false;
        }

        if (move.getPiece().getColor() != player.color) {
            return false;
        }

        if (!move.getPiece().canMove(move.getStart(), move.getEnd())) {
            return false;
        }

        // same cell two pieces not possible
        if (move.getEnd().getPiece().getColor() == player.getColor()) {
            return false;
        }

        if (move.getEnd().getPiece() != null) {
            move.getEnd().getPiece().setState(State.KILLED);
        }
        move.getStart().setPiece(null);
        move.getEnd().setPiece(piece);

        // make it king piece
        if (move.getEnd().getPiece() instanceof PawnPiece) {
            winner = player;
        }

        return true;
    }

    private Move getMove(Player player, int currentRow, int currentCol, int newRow, int newCol, Piece piece) {
        Cell start = board.getCell(currentRow, currentCol);
        Cell end = board.getCell(newRow, newCol);
        return new Move(start, end, piece, player);
    }
}
