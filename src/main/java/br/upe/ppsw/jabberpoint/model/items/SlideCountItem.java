package br.upe.ppsw.jabberpoint.model.items;

import br.upe.ppsw.jabberpoint.controller.PresentationController;
import br.upe.ppsw.jabberpoint.model.Presentation;

public class SlideCountItem {

    private final int xPosition;
    private final int yPosition;
    private final Presentation presentation = Presentation.getInstance();
    private final PresentationController presentationController = new PresentationController();

    public SlideCountItem(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public String getSlideCounter() {
        return "Slide " + (1 + presentation.getCurrentSlideNumber()) + " of "
                + presentationController.getSize();
    }

    public int getXPosition() {
        return this.xPosition;
    }

    public int getYPosition() {
        return this.yPosition;
    }
}
