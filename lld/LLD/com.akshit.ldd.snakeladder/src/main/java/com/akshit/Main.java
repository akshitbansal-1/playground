package com.akshit;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("1");
        Player player2 = new Player("2");
//        Player player3 = new Player("3");

        Game game = new Game(10, 10, 4, 4, 1);
        game.join(player1);
        game.join(player2);
//        game.join(player3);
        game.startGame();
    }
}