package br.upe.ppsw.jabberpoint.model;

import br.upe.ppsw.jabberpoint.controller.PresentationController;

public class SlideCountItem {

    private final int xPosition;
    private final int yPosition;
    private final PresentationController presentationController = PresentationController.getInstance();

    public SlideCountItem(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public String getSlideCounter() {
        return "Slide " + (1 + presentationController.getCurrentSlideNumber()) + " of "
                + presentationController.getSize();
    }

    public int getXPostion() {
        return this.xPosition;
    }

    public int getYPostion() {
        return this.yPosition;
    }
}
