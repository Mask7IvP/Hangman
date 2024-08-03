package view;

import model.Button;

import java.util.List;
import java.util.Set;

public class View {
    public void printTitle(StringBuilder imageWelcome) {
        System.out.println(imageWelcome);
        System.out.println("You are welcomed by the game \"Gallows!\"");
    }

    public void printMainMenu(Button START, Button END) {
        System.out.printf("For a new game press \"%s\", to exit the game press \"%s\":\n", START.getSymbol(), END.getSymbol());
    }

    public void printProgressInfo(StringBuilder imageGallows, List<Character> hiddenLetters, int counterAttempts, Set<Character> selectedLetters) {
        System.out.println(imageGallows);
        System.out.printf("Guess the word: %s\n", hiddenLetters);
        System.out.printf("Number of attempts: %d\n", counterAttempts);
        System.out.printf("Selected letters: %s\n", selectedLetters);
    }

    public void printEnterLetter() {
        System.out.println("Enter letter: ");
    }

    public void printFileNotFound() {
        System.out.println("File is not found. GAME OVER.");
    }

    public void printIncorrectInput() {
        System.out.println("Incorrect input! Try again:");
    }

    public void printWin(String hiddenWord) {
        System.out.println("YOU WIN!!!");
        System.out.printf("Загаданное слово: %s\n", hiddenWord);
    }
    public void printLose(StringBuilder imageGallows, String hiddenWord) {
        System.out.println(imageGallows);
        System.out.println("YOU LOSE");
        System.out.printf("Загаданное слово: %s\n", hiddenWord);
    }

    public void printEnd() {
        System.out.println("GAME OVER");
    }
}