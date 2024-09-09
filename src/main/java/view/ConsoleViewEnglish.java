package view;


import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ConsoleViewEnglish implements View {
    public static final String ANSI_RED = "\u001B[31m";
    Scanner scanner = new Scanner(System.in);
    Renderer renderer;

    public ConsoleViewEnglish(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void printTitle() {
        System.out.println(ANSI_RED + renderer.imageTitle);
        System.out.println("You are welcomed by the game \"Gallows!\".");
    }

    public void printMainMenu() {
        System.out.printf("For a new game press \"%s\", to exit the game press \"%s\":\n", UserInputTurnOnOff.START.getSymbol(), UserInputTurnOnOff.END.getSymbol());

    }

    @Override
    public String getUserInput() {
        return scanner.nextLine().toUpperCase();
    }

    @Override
    public void printHangman(int counterError) {
        System.out.println(renderer.imagesHangman.get(counterError));
    }

    @Override
    public void printProgressInfo(List<Character> maskWord, int counterAttempts, int counterError, Set<Character> selectedLetters) {
        printHangman(counterError);
        System.out.printf("Guess the word: %s\n", maskWord);
        System.out.printf("Number of attempts: %d\n", counterAttempts);
        System.out.printf("Selected letters: %s\n", selectedLetters);
    }

    @Override
    public void printEnterLetter() {
        System.out.println("Enter letter: ");
    }

    @Override
    public void printRepeatLetter() {
        System.out.println("There has already been such a letter!");
    }
    @Override
    public void printFileNotFound(String nameFile) {
        System.out.printf("File \"%s\" is not found. GAME OVER.\n", nameFile);
    }

    @Override
    public void printIncorrectInput() {
        System.out.println("Incorrect input! Try again:");
    }

    @Override
    public void printWin(String hiddenWord) {
        System.out.println("YOU WIN!!!");
        System.out.printf("Hidden word: %s\n", hiddenWord);
    }

    @Override
    public void printLose(String hiddenWord) {
        System.out.println("YOU LOSE");
        System.out.printf("Hidden word: %s\n", hiddenWord);
    }

    @Override
    public void printEnd() {
        System.out.println("GAME OVER");
    }
}