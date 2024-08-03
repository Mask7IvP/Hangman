package model;

import controller.ReaderText;
import view.View;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    Set<Character> selectedLetters = new HashSet<>();
    int counterError = 0;

    public int makeMove(ReaderText readerText, String REG_EX_LETTER, String hiddenWord, List<Character> hiddenLetters, View view, Board board) {
        view.printEnterLetter();
        char selectedLetter = readerText.readSymbol(REG_EX_LETTER, view);
        if (!isLetterMatched(hiddenWord, hiddenLetters, selectedLetter, board)) {
            counterError++;
        }
        selectedLetters.add(selectedLetter);
        return counterError;
    }

    private boolean isLetterMatched(String hiddenWord, List<Character> hiddenLetters, char selectedLetter, Board board) {
        boolean letterMatched = false;
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (selectedLetter == hiddenWord.charAt(i)) {
                letterMatched = true;
                openLetterOnBoard(hiddenLetters, selectedLetter, board, i);
            } else if (selectedLetters.contains(selectedLetter)) {
                letterMatched = true;
            }
        }
        return letterMatched;
    }

    private void openLetterOnBoard(List<Character> hiddenLetters, char selectedLetter, Board board, int letterIndex) {
        if (hiddenLetters.get(letterIndex) == board.HIDDEN_LETTER) {
            hiddenLetters.set(letterIndex, selectedLetter);
        }
    }
}