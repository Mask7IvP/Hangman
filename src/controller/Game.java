package controller;

import model.ReaderFile;
import model.Validator;
import model.Word;
import model.WordGenerator;
import view.Renderer;
import view.UserInputTurnOnOff;
import view.View;

import java.io.FileNotFoundException;
import java.util.*;

public class Game {
    View view;
    Validator validator;
    WordGenerator wordGenerator;
    ReaderFile reader;
    Word word;
    Renderer renderer;
    private final String REG_EX_NUMBER = "[1-2]";
    private final int ATTEMPTS = 6;
    private int counterError = 0;
    private int counterAttempts = 0;
    private boolean launch = true;
    private String input;
    private Set<Character> selectedLetters = new HashSet<>();

    public Game(View view, Validator validator, WordGenerator wordGenerator, ReaderFile reader, Word word, Renderer renderer) {
        this.view = view;
        this.validator = validator;
        this.wordGenerator = wordGenerator;
        this.reader = reader;
        this.word = word;
        this.renderer = renderer;
    }

    public void start() {
        readImageTitle();
        view.printTitle();
        readImagesHangmanToList();
        while (launch) {
            view.printMainMenu();
            if (isPressNewGame()) {
                createWord();
                word.setMaskWord();
                counterAttempts = ATTEMPTS - counterError;
                while (word.isNotGuessed(counterAttempts)) {
                    makeMove();
                }
                gameIsOver();
            } else {
                launch = false;
            }
        }
        view.printEnd();
        System.exit(0);
    }

    private void gameIsOver() {
        if (counterAttempts > 0) {
            view.printWin(word.getHiddenWord());
        } else {
            view.printHangman(counterError);
            view.printLose(word.getHiddenWord());
        }
        counterAttempts = 0;
        counterError = 0;
        selectedLetters.clear();
    }

    private boolean isPressNewGame() {
        return check(REG_EX_NUMBER) == UserInputTurnOnOff.START.getSymbol();
    }

    private void readImageTitle() {
        StringBuilder imageTitle = renderer.getImageTitle();
        try {
            imageTitle = reader.readFile(renderer.getPATH_TO_FILE_TITLE());
        } catch (FileNotFoundException e) {
            view.printFileNotFound(renderer.getPATH_TO_FILE_TITLE());
            System.exit(0);
        }
        renderer.setImageTitle(imageTitle);
    }

    private void readImagesHangmanToList() {
        List<StringBuilder> imagesHangmans = renderer.getImagesHangman();
        for (int i = 0; i <= ATTEMPTS; i++) {
            StringBuilder imageHangman;
            try {
                imageHangman = reader.readFile(renderer.getTEMPLATE_PATH_IMAGE_HANGMAN().formatted(i));
                imagesHangmans.add(imageHangman);
            } catch (FileNotFoundException e) {
                view.printFileNotFound(renderer.getTEMPLATE_PATH_IMAGE_HANGMAN().formatted(i));
                System.exit(0);
            }
        }
        renderer.setImagesHangman(imagesHangmans);
    }

    private void makeMove() {
        List<Character> maskWord = word.getMaskWord();
        view.printProgressInfo(maskWord, counterAttempts, counterError, selectedLetters);
        view.printEnterLetter();
        char enteredLetter = check();
        if (!selectedLetters.contains(enteredLetter)) {
            selectedLetters.add(enteredLetter);
            checkLetterInWord(enteredLetter);
        } else {
            view.printRepeatLetter();
        }
        counterAttempts = ATTEMPTS - counterError;
    }

    private void checkLetterInWord(char selectedLetter) {
        if (word.isCheckLetterInWord(selectedLetter)) {
            word.openLetter(selectedLetter);
        } else {
            counterError++;
        }
    }

    public char check(String REG_EX_NUMBER) {
        boolean validation = false;
        while (!validation) {
            input = view.getUserInput();
            validation = input.matches(REG_EX_NUMBER);
            if (!validation) {
                view.printIncorrectInput();
            }
        }
        return input.charAt(0);
    }

    public char check() {
        boolean validation = false;
        while (!validation) {
            input = view.getUserInput();
            validation = validator.isCheckSymbol(input);
            if (!validation) {
                view.printIncorrectInput();
            }
        }
        return input.charAt(0);
    }

    public void createWord() {
        try {
            word.setHiddenWord(wordGenerator.chooseWord(reader));
        } catch (FileNotFoundException e) {
            view.printFileNotFound(wordGenerator.getDictionary().getFILE_NAME_DICTIONARY());
            System.exit(0);
        }
    }
}