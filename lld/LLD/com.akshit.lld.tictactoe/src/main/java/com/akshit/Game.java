package com.akshit;

import java.util.*;

public class Game {

    List<Player> players;

    Cell[][] cells;

    int size;

    boolean started;

    Player winner;

    SymbolGenerator symbolGenerator;

    boolean draw;

    Game(int size, SymbolGenerator symbolGenerator) {
        players = new ArrayList<>();
        initCells(size);
        this.size = size;
        this.symbolGenerator = symbolGenerator;
    }

    private void initCells(int size) {
        cells = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void addPlayer(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        if (players.size() == size) {
            throw new IllegalStateException("Can't add more players");
        }
        if (started) {
            throw new IllegalStateException("Game is already started. Can't add more players");
        }
        player.setSymbol(symbolGenerator.generateSymbol());
        System.out.println("Assigned " + player.getSymbol() + " to player " + player.playerName);
        players.add(player);
    }

    public void startGame() {
        System.out.println("Started game");
        started = true;
        int turnCounter = 0;
        int totalSize = size * size;
        while (winner == null && !draw) {
            playTurn(turnCounter, totalSize);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(cells[i][j].getCh());
                }
                System.out.println();
            }
            System.out.println("\n\n");
            turnCounter++;
        }
    }

    private void playTurn(int turnCounter, int totalSize) {
        Player currentPlayer = getPlayer(turnCounter);
        Cell selectedCell = null;
        Set<Cell> visited = new HashSet<>();
        while (selectedCell == null && visited.size() < size * size) {
            int randomIndex = (int) (Math.random() * totalSize);
//            System.out.println("Random index: " + randomIndex + " " + visited.size());
            Cell cell = getCell(randomIndex);
            if (visited.contains(cell)) {
                continue;
            }
            visited.add(cell);
            if (cell.getCh() != '1') {
                continue;
            }
            selectedCell = cell;
            System.out.println("Setting " + currentPlayer.getSymbol() + " at " + randomIndex/size + " " + randomIndex%size);
            selectedCell.setCh(currentPlayer.getSymbol());
        }

        if (hasWon(currentPlayer)) {
            System.out.println(currentPlayer.playerName + " player has won");
            winner = currentPlayer;
        }
    }

    private boolean hasWon(Player currentPlayer) {
        boolean sameAcrossLine = false;
        boolean hasDrawn = true;
        for (int i = 0; i < size; i++) {
            boolean same = true;
            for (int j = 0; j < size; j++) {
                if (cells[i][j].getCh() != currentPlayer.getSymbol()) {
                    same = false;
                }
                if (cells[i][j].getCh() == '1') {
                    hasDrawn = false;
                }
            }
            sameAcrossLine = sameAcrossLine || same;
        }

        for (int j = 0; j < size; j++) {
            boolean same = true;
            for (int i = 0; i < size; i++) {
                if (cells[i][j].getCh() != currentPlayer.getSymbol()) {
                    same = false;
                    break;
                }
            }
            sameAcrossLine = sameAcrossLine || same;
        }

        boolean same = true;
        for (int i = 0; i < size; i++) {
            if (cells[i][i].getCh() != currentPlayer.getSymbol()) {
                same = false;
                break;
            }
        }
        sameAcrossLine = sameAcrossLine || same;
        same = true;
        for (int i = 0; i < size; i++) {
            if (cells[size-i-1][size-1-i].getCh() != currentPlayer.getSymbol()) {
                same = false;
                break;
            }
        }

        if (hasDrawn) {
            System.out.println("Draw");
            draw = true;
        }
        return sameAcrossLine || same;
    }

    private Cell getCell(int randomIndex) {
        return cells[randomIndex/size][randomIndex%size];
    }

    private Player getPlayer(int turnCounter) {
        return players.get(turnCounter % players.size());
    }


}
