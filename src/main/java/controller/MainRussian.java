package controller;

import model.*;
import view.ConsoleViewRussian;
import view.Renderer;
import view.View;

public class MainRussian {
    public static void main(String[] args) {
        Renderer renderer = new Renderer();
        View view = new ConsoleViewRussian(renderer);
        Validator validator = new Validator("[А-ЯЁ]+");
        Dictionary dictionary = new Dictionary("Dictionary_RUSSIAN.txt");
        WordGenerator wordGenerator = new WordGenerator(dictionary);
        FileReader reader = new FileReader();
        Word word = new Word();
        Game game = new Game(view, validator, wordGenerator, reader, word, renderer);
        game.start();
    }
}