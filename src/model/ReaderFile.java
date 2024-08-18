package model;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class ReaderFile {

    public List<String> readFile(String pathToFile, List<String> words) throws FileNotFoundException {
        InputStream inputStream = getClass().getResourceAsStream(pathToFile);
        if (inputStream == null) {
            throw new FileNotFoundException();
        }
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            words.add(scanner.nextLine().toUpperCase());
        }
        scanner.close();
        return words;
    }

    public StringBuilder readFile(String pathToFile) throws FileNotFoundException {
        StringBuilder imageGallows = new StringBuilder();
        InputStream inputStream = getClass().getResourceAsStream(pathToFile);
        if (inputStream == null) {
            throw new FileNotFoundException();
        }
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            imageGallows.append(scanner.nextLine());
            imageGallows.append("\n");
        }
        scanner.close();
        return imageGallows;
    }
}