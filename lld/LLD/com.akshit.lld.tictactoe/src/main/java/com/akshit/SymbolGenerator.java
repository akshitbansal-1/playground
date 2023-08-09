package com.akshit;

import java.util.HashSet;
import java.util.Set;

public class SymbolGenerator {

    Set<Character> usedSymbols;

    SymbolGenerator() {
        usedSymbols = new HashSet<>();
    }

    public Character generateSymbol() {
        Character val = null;
        while (val == null) {
            int randomNum = (int) (Math.random()*26);
            Character ch = (char)(randomNum+65);
            if (!usedSymbols.contains(ch)) {
                usedSymbols.add(ch);
                val = ch;
            }
        }
        return val;
    }

}
