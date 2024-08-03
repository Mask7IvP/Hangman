package model;

import controller.ReaderText;
import view.View;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private final String FILE_NAME_DICTIONARY = "Dictionary.txt";
    private final List<String> WORDS = new ArrayList<>();

    List<String> getListWords(ReaderText readerText, View view) {
        return readerText.readFile(FILE_NAME_DICTIONARY, WORDS, view);
    }
}