package br.upe.ppsw.jabberpoint.view.drawers;

import java.awt.Graphics;

import br.upe.ppsw.jabberpoint.controller.PresentationController;

public class SlideCountDrawer {

    private int xPosition;
    private int yPosition;
    private PresentationController presentationController = PresentationController.getInstance();

    public SlideCountDrawer(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    public String getSlideCounter() {
        return "Slide " + (1 + presentationController.getCurrentSlideNumber()) + " of "
                + presentationController.getSize();
    }

    public void draw(Graphics graphics) {
        graphics.drawString(getSlideCounter(), xPosition, yPosition);
    }

}
