package model;

public enum Button {
    START('1'),
    END('2');
    private final Character symbol;

    Button(Character symbol) {
        this.symbol = symbol;
    }

    public Character getSymbol() {
        return symbol;
    }
}