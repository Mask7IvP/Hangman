package model;


public class Validator {

    private final String regExSymbol;

    public Validator(String regExSymbol) {
        this.regExSymbol = regExSymbol;
    }

    public boolean isCheckSymbol(String enteredLetter) {
        return (enteredLetter.length() == 1) && enteredLetter.matches(regExSymbol);
    }
}