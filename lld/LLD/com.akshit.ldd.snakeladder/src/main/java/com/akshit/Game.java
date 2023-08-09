package com.akshit;

import java.util.ArrayList;
import java.util.List;

public class Game {
    String id;

    List<Player> playerList;

    Board board;

    Dice dice;

    Player winner;

    boolean started;


    Game(int rows, int cols, int snakesCount, int laddersCount, int diceCount) {
        if (diceCount <= 0) {
            throw new IllegalArgumentException("Invalid dice count.");
        }
        dice = new Dice(diceCount);
        board = new Board(rows, cols, snakesCount, laddersCount);
        playerList = new ArrayList<>();
    }

    public void join(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        if (started) {
            throw new IllegalStateException("Can't access already started game");
        }
        playerList.add(player);
    }

    public void startGame() {
        if (playerList.size() < 1) {
            throw new IllegalStateException("Not enough players in the game");
        }

        started = true;
        int turnCounter = 0;
        while (winner == null) {
            Player currentPlayer = getPlayer(turnCounter);
            int diceCounter;
            do {
                diceCounter = dice.rollDice();
                int newPlayerPosition = currentPlayer.currentPosition + diceCounter;
                if (isPlayerWinning(currentPlayer, newPlayerPosition, diceCounter)) {
                    break;
                }

                Cell cell = board.getCell(newPlayerPosition);
                if (cell.jump != null) {
                    String who = cell.jump.start < cell.jump.end ? "Ladder" : "Snake";
                    System.out.println(who + " at " + cell.jump.start + " going to " + cell.jump.end);
                    newPlayerPosition = cell.jump.end;
                }
                System.out.println("Player: " + currentPlayer.id + " got " + diceCounter + " moving from " + currentPlayer.currentPosition + " to " + newPlayerPosition);
                currentPlayer.currentPosition = newPlayerPosition;
            } while (dice.canRetry(diceCounter));

            turnCounter++;
        }

    }

    private boolean isPlayerWinning(Player currentPlayer, int newPlayerPosition, int diceCounter) {
        if (board.isPositionOutOfBoard(newPlayerPosition)) {
            System.out.println("Player: " + currentPlayer.id + " got " + diceCounter + " moving from " + currentPlayer.currentPosition + " to " + newPlayerPosition);
            System.out.println("Player " + currentPlayer.id + " has won");
            winner = currentPlayer;
            return true;
        }
        return false;
    }

    private Player getPlayer(int turnCounter) {
        int playerTurn = turnCounter % playerList.size();
        return playerList.get(playerTurn);
    }

}
