package model;

import view.Renderer;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public List<String> read(String pathToFile, List<String> words) throws FileNotFoundException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(pathToFile);
        if (inputStream == null) {
            throw new FileNotFoundException();
        }
        try (Scanner scanner = new Scanner(inputStream)) {
            while (scanner.hasNextLine()) {
                words.add(scanner.nextLine().toUpperCase());
            }
        }
        return words;
    }

    public StringBuilder read(String pathToFile) throws FileNotFoundException {
        StringBuilder imageGallows = new StringBuilder();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(pathToFile);
        if (inputStream == null) {
            throw new FileNotFoundException();
        }
        try (Scanner scanner = new Scanner(inputStream)) {
            while (scanner.hasNextLine()) {
                imageGallows.append(scanner.nextLine());
                imageGallows.append("\n");
            }
        }
        return imageGallows;
    }
}