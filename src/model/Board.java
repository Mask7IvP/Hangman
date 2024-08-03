package model;

import java.util.*;

public class Board {

    final char HIDDEN_LETTER = '*';
    List<Character> lettersOnBoard = new ArrayList<>();

    List<Character> fill(String s) {
        for (int i = 0; i < s.length(); i++) {
            lettersOnBoard.add(HIDDEN_LETTER);
        }
        return lettersOnBoard;
    }
}