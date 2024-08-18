package view;

import java.util.ArrayList;
import java.util.List;

public class Renderer {
    private final String PATH_TO_FILE_TITLE = "/Title.txt";
    private final String TEMPLATE_PATH_IMAGE_HANGMAN = "/Attempt_%d.txt";

    List<StringBuilder> imagesHangman = new ArrayList<>();
    StringBuilder imageTitle;

    public StringBuilder getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(StringBuilder imageTitle) {
        this.imageTitle = imageTitle;
    }

    public List<StringBuilder> getImagesHangman() {
        return imagesHangman;
    }

    public void setImagesHangman(List<StringBuilder> imagesHangman) {
        this.imagesHangman = imagesHangman;
    }

    public String getTEMPLATE_PATH_IMAGE_HANGMAN() {
        return TEMPLATE_PATH_IMAGE_HANGMAN;
    }

    public String getPATH_TO_FILE_TITLE() {
        return PATH_TO_FILE_TITLE;
    }
}