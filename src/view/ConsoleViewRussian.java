package view;


import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ConsoleViewRussian implements View {
    Scanner scanner = new Scanner(System.in);
    Renderer renderer;

    public ConsoleViewRussian(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void printTitle() {
        System.out.println(renderer.imageTitle);
        System.out.println("Добро пожаловать в игру \"Виселица!\".");
    }

    public void printMainMenu() {
        System.out.printf("Для новой игры нажмите \"%s\", чтобы выйти из игры нажмите \"%s\":\n", UserInputTurnOnOff.START.getSymbol(), UserInputTurnOnOff.END.getSymbol());
    }

    @Override
    public String getUserInput() {
        return scanner.nextLine().toUpperCase();
    }

    @Override
    public void printHangman(int counterError) {
        System.out.println(renderer.imagesHangman.get(counterError));
    }

    @Override
    public void printProgressInfo(List<Character> maskWord, int counterAttempts, int counterError, Set<Character> selectedLetters) {
        printHangman(counterError);
        System.out.printf("Угадай слово: %s\n", maskWord);
        System.out.printf("Количество попыток: %d\n", counterAttempts);
        System.out.printf("Выбранные буквы: %s\n", selectedLetters);
    }

    @Override
    public void printEnterLetter() {
        System.out.println("Введите букву: ");
    }

    @Override
    public void printRepeatLetter() {
        System.out.println("Такая буква уже была!");
    }

    @Override
    public void printFileNotFound(String nameFile) {
        System.out.printf("Файл \"%s\" не найден. Игра окончена.\n", nameFile);
    }

    @Override
    public void printIncorrectInput() {
        System.out.println("Неверный ввод! Попробуйте снова:");
    }

    @Override
    public void printWin(String hiddenWord) {
        System.out.println("ВЫ ПОБЕДИЛИ!!!");
        System.out.printf("Загаданное слово: %s\n", hiddenWord);
    }

    @Override
    public void printLose(String hiddenWord) {
        System.out.println("ВЫ ПРОИГРАЛИ");
        System.out.printf("Загаданное слово: %s\n", hiddenWord);
    }

    @Override
    public void printEnd() {
        System.out.println("ИГРА ОКОНЧЕНА");
    }
}