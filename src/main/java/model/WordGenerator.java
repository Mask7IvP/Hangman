package model;


import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

public class WordGenerator {
    Dictionary dictionary;

    public Dictionary getDictionary() {
        return dictionary;
    }

    public WordGenerator(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String chooseWord(FileReader fileReader) throws FileNotFoundException {
        List<String> words = dictionary.getListWords(fileReader);
        Random random = new Random();
        int randomLineNumber = random.nextInt(words.size());
        return words.get(randomLineNumber).toUpperCase();
    }
}