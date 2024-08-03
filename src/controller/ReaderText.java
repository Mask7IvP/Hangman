package controller;

import view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ReaderText {
    public Scanner console = new Scanner(System.in);

    public List<String> readFile(String nameFile, List<String> WORDS, View view) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(nameFile));
            while (scanner.hasNextLine()) {
                WORDS.add(scanner.nextLine().toUpperCase());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            view.printFileNotFound();
            System.exit(0);
        }
        return WORDS;
    }

    public StringBuilder readFile(String[] IMAGE_ATTEMPTS, int counterError, View view) {
        Scanner scanner;
        StringBuilder imageGallows = new StringBuilder();
        try {
            scanner = new Scanner(new File(IMAGE_ATTEMPTS[counterError]));
            while (scanner.hasNextLine()) {
                imageGallows.append(scanner.nextLine());
                imageGallows.append("\n");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            view.printFileNotFound();
            System.exit(0);
        }
        return imageGallows;
    }

    public char readSymbol(String regExSymbol, View view) {
        String enteredLetter;
        Validator validator = new Validator();
        do {
            enteredLetter = console.nextLine().toUpperCase();
        }
        while (!validator.isCheck(enteredLetter, regExSymbol, view));
        return enteredLetter.charAt(0);
    }
}