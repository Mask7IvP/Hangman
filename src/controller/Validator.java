package controller;

import view.View;

public class Validator {

    boolean isCheck(String enteredLetter, String regExSymbol, View view) {
        if (!isValidSymbol(enteredLetter, regExSymbol)) {
            view.printIncorrectInput();
            return false;
        }
        return true;
    }

    private boolean isValidSymbol(String enteredLetter, String regExSymbol) {
        int NUMBER_OF_LETTERS = 1;
        return (enteredLetter.length() == NUMBER_OF_LETTERS) && enteredLetter.matches(regExSymbol);
    }
}