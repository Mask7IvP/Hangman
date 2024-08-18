package view;

public enum UserInputTurnOnOff {
    START('1'),
    END('2');
    private final Character symbol;

    UserInputTurnOnOff(Character symbol) {
        this.symbol = symbol;
    }

    public Character getSymbol() {
        return symbol;
    }
}