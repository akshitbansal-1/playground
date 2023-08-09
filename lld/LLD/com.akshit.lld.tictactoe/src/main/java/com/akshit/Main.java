package com.akshit;

public class Main {
    public static void main(String[] args) {
        SymbolGenerator symbolGenerator = new SymbolGenerator();

        Game game = new Game(3, symbolGenerator);

        Player player1 = new Player("Akshit");
        Player player2 = new Player("Ayush");

        game.addPlayer(player1);
        game.addPlayer(player2);
        game.startGame();
    }
}