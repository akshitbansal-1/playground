package com.akshit;

public class Player {

    String playerName;

    Character symbol;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }
}
