package br.upe.ppsw.jabberpoint.controller;

import br.upe.ppsw.jabberpoint.model.Presentation;
import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.view.ContentPanel;
import br.upe.ppsw.jabberpoint.view.DialogBoxes;

import java.util.ArrayList;


public class PresentationController {


    Presentation presentation = Presentation.getInstance();

    public PresentationController() {
        // Nothing to add
    }

    public void addSlide(Slide slide) {
        presentation.getShowList().add(slide);
    }

    public void setSlideNumber(int number) {
        ContentPanel contentPanel = presentation.getContentPanel();
        if (number < getSize()) {
            presentation.setCurrentSlideNumber(number);
            if (contentPanel != null) {
                contentPanel.update(getCurrentSlide());
            }
        } else {
            DialogBoxes.showOutOfBoundsError();
        }
    }

    public void prevSlide() {
        int currentSlideNumber = presentation.getCurrentSlideNumber();
        if (currentSlideNumber > 0) {
            setSlideNumber(currentSlideNumber - 1);
        }
    }

    public void nextSlide() {
        int currentSlideNumber = presentation.getCurrentSlideNumber();
        if (currentSlideNumber < (getSize() - 1)) {
            setSlideNumber(currentSlideNumber + 1);
        }
    }

    public void clear() {
        presentation.setShowList(new ArrayList<>());
    }
    public int getSize() {
        return presentation.getShowList().size();
    }

    public Slide getSlide(int number) {
        if (number < 0 || number >= getSize()) {
            return null;
        }
        return presentation.getShowList().get(number);
    }

    public Slide getCurrentSlide() {
        return getSlide(presentation.getCurrentSlideNumber());
    }

}
