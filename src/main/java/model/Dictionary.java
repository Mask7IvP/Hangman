package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private final String fileNameDictionary;
    private final List<String> WORDS = new ArrayList<>();

    public Dictionary(String fileNameDictionary) {
        this.fileNameDictionary = fileNameDictionary;
    }

    public String getFileNameDictionary() {
        return fileNameDictionary;
    }

    List<String> getListWords(FileReader fileReader) throws FileNotFoundException {
        return fileReader.read(fileNameDictionary, WORDS);
    }
}