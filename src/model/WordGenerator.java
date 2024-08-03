package model;

import controller.ReaderText;
import view.View;

import java.util.List;
import java.util.Random;

public class WordGenerator {
    Dictionary dictionary = new Dictionary();

    String chooseWord(ReaderText readerText, View view) {
        List<String> words = dictionary.getListWords(readerText, view);
        Random random = new Random();
        int randomLineNumber = random.nextInt(words.size());
        return words.get(randomLineNumber).toUpperCase();
    }
}