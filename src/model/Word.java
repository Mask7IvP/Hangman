package model;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private final char MASK_LETTER = '*';
    private String hiddenWord;
    private List<Character> maskWord;
    private List<Integer> letterIndices = new ArrayList<>();

    public String getHiddenWord() {
        return hiddenWord;
    }

    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    public void setMaskWord() {
        maskWord = new ArrayList<>();
        for (int i = 0; i < hiddenWord.length(); i++) {
            maskWord.add(MASK_LETTER);
        }
    }

    public List<Character> getMaskWord() {
        return maskWord;
    }

    public boolean isCheckLetterInWord(char selectedLetter) {
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (selectedLetter == hiddenWord.charAt(i)) {
                letterIndices.add(i);
            }
        }
        return !letterIndices.isEmpty();
    }

    public void openLetter(char selectedLetter) {
        for (int index : letterIndices) {
            if (maskWord.get(index) == MASK_LETTER) {
                maskWord.set(index, selectedLetter);
            }
        }
        letterIndices.clear();
    }

    public boolean isNotGuessed(int counterAttempts) {
        return (counterAttempts != 0) && (maskWord.contains(MASK_LETTER));
    }
}