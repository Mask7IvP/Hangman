package model;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private final char MASK_LETTER = '*';
    private String hiddenText;
    private List<Character> mask;
    private List<Integer> letterIndices = new ArrayList<>();

    public String getHiddenText() {
        return hiddenText;
    }

    public void setHiddenText(String hiddenText) {
        this.hiddenText = hiddenText;
    }

    public void setMaskWord() {
        mask = new ArrayList<>();
        for (int i = 0; i < hiddenText.length(); i++) {
            mask.add(MASK_LETTER);
        }
    }

    public List<Character> getMask() {
        return mask;
    }

    public boolean isCheckLetterInWord(char selectedLetter) {
        for (int i = 0; i < hiddenText.length(); i++) {
            if (selectedLetter == hiddenText.charAt(i)) {
                letterIndices.add(i);
            }
        }
        return !letterIndices.isEmpty();
    }

    public void openLetter(char selectedLetter) {
        for (int index : letterIndices) {
            if (mask.get(index) == MASK_LETTER) {
                mask.set(index, selectedLetter);
            }
        }
        letterIndices.clear();
    }

    public boolean isNotGuessed(int counterAttempts) {
        return (counterAttempts != 0) && (mask.contains(MASK_LETTER));
    }
}