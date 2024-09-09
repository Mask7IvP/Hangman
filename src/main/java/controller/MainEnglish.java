package controller;

import model.*;
import view.ConsoleViewEnglish;
import view.Renderer;
import view.View;

public class MainEnglish {
    public static void main(String[] args) {
        Renderer renderer = new Renderer();
        View view = new ConsoleViewEnglish(renderer);
        Validator validator = new Validator("[A-Z]+");
        Dictionary dictionary = new Dictionary("Dictionary_ENGLISH.txt");
        WordGenerator wordGenerator = new WordGenerator(dictionary);
        FileReader reader = new FileReader();
        Word word = new Word();
        Game game = new Game(view, validator, wordGenerator, reader, word, renderer);
        game.start();
    }
}