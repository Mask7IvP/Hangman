package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private final String FILE_NAME_DICTIONARY;
    private final List<String> WORDS = new ArrayList<>();

    public Dictionary(String fileNameDictionary) {
        this.FILE_NAME_DICTIONARY = fileNameDictionary;
    }

    public String getFILE_NAME_DICTIONARY() {
        return FILE_NAME_DICTIONARY;
    }

    List<String> getListWords(ReaderFile readerFile) throws FileNotFoundException {
        return readerFile.readFile(FILE_NAME_DICTIONARY, WORDS);
    }
}