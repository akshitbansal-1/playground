package com.akshit;

public class Dice {
    int diceCount;

    Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int sum = 0;
        for (int i = 0; i < diceCount; i++) {
            int num = 1 + (int) (Math.random()*6);
            sum += num;
        }
        return sum;
    }

    public boolean canRetry(int diceCounter) {
        return diceCounter == 6;
    }
}
