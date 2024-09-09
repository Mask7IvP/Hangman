package view;


import java.util.List;
import java.util.Set;

public interface View {
    void printTitle();

    void printMainMenu();

    String getUserInput();

    void printHangman(int counterError);

    void printProgressInfo(List<Character> maskWord, int counterAttempts, int counterError, Set<Character> selectedLetters);

    void printEnterLetter();

    void printRepeatLetter();

    void printFileNotFound(String nameFile);

    void printIncorrectInput();

    void printWin(String hiddenWord);

    void printLose(String hiddenWord);

    void printEnd();
}
