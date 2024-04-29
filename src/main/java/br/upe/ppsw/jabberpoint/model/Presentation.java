package br.upe.ppsw.jabberpoint.model;

import java.util.ArrayList;
import java.util.List;

import br.upe.ppsw.jabberpoint.view.ContentPanel;

public class Presentation {

    private List<Slide> showList;

    private ContentPanel contentPanel;

    private int currentSlideNumber;

    private static Presentation instance = null;

    private Presentation() {
        showList = new ArrayList<>();
        currentSlideNumber = 0;
    }

    public static Presentation getInstance() {
        if (instance == null) {
            instance = new Presentation();
        }
        return instance;
    }

    public ContentPanel getContentPanel() {
        return contentPanel;
    }

    public void setContentPanel(ContentPanel contentPanel) {
        this.contentPanel = contentPanel;
    }

    public int getCurrentSlideNumber() {
        return currentSlideNumber;
    }

    public void setCurrentSlideNumber(int currentSlideNumber) {
        this.currentSlideNumber = currentSlideNumber;
    }

    public List<Slide> getShowList() {
        return showList;
    }

    public void setShowList(List<Slide> showList) {
        this.showList = showList;
    }

}
