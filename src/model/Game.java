package model;

import controller.ReaderText;
import view.View;

import java.util.*;

public class Game {
    private final String[] HANGMAN_WELCOME = {"src/image/Welcome.txt"};
    private final String[] IMAGE_ATTEMPTS = {"src/image/Attempt_0.txt", "src/image/Attempt_1.txt", "src/image/Attempt_2.txt", "src/image/Attempt_3.txt",
            "src/image/Attempt_4.txt", "src/image/Attempt_5.txt", "src/image/Attempt_6.txt"};
    private final String REG_EX_NUMBER = "[1-2]";
    private final String REG_EX_LETTER = "[А-ЯЁ]+";
    private boolean launch = true;
    private final int ATTEMPTS = 6;
    private int counterAttempts = 0;

    public static void main(String[] args) {
        Game game = new Game();
        View view = new View();
        ReaderText readerText = new ReaderText();
        Player player = new Player();
        game.startRound(readerText, player, view);
        game.end(readerText, view);
    }


    private void startRound(ReaderText readerText, Player player, View view) {
        StringBuilder imageWelcome = readerText.readFile(HANGMAN_WELCOME, player.counterError, view);
        view.printTitle(imageWelcome);

        while (launch) {
            StringBuilder imageGallows;
            WordGenerator wordGenerator = new WordGenerator();
            Board board = new Board();

            view.printMainMenu(Button.START, Button.END);
            char symbol = readerText.readSymbol(REG_EX_NUMBER, view);

            if (symbol == Button.START.getSymbol()) {
                String hiddenWord = wordGenerator.chooseWord(readerText, view);
                List<Character> hiddenLetters = board.fill(hiddenWord);
                counterAttempts = ATTEMPTS - player.counterError;

                while (isNotGuessedWord(hiddenLetters, board)) {
                    imageGallows = readerText.readFile(IMAGE_ATTEMPTS, player.counterError, view);
                    view.printProgressInfo(imageGallows, hiddenLetters, counterAttempts, player.selectedLetters);
                    int counterError = player.makeMove(readerText, REG_EX_LETTER, hiddenWord, hiddenLetters, view, board);
                    counterAttempts = ATTEMPTS - counterError;
                }

                if (counterAttempts != 0) {
                    view.printWin(hiddenWord);
                } else {
                    imageGallows = readerText.readFile(IMAGE_ATTEMPTS, player.counterError, view);
                    view.printLose(imageGallows, hiddenWord);
                }
            } else {
                launch = false;
            }
            counterAttempts = 0;
            player.counterError = 0;
            player.selectedLetters.clear();
        }
    }

    private boolean isNotGuessedWord(List<Character> hiddenLetters, Board board) {
        return (counterAttempts != 0) && (hiddenLetters.contains(board.HIDDEN_LETTER));
    }

    private void end(ReaderText readerText, View view) {
        readerText.console.close();
        view.printEnd();
        System.exit(0);
    }
}