package br.upe.ppsw.jabberpoint.view.drawers;

import java.awt.Graphics;

import br.upe.ppsw.jabberpoint.controller.PresentationController;
import br.upe.ppsw.jabberpoint.view.ApplicationFrame;

public class SlideCountDrawer {

    private int xPosition;
    private int yPosition;
    private PresentationController presentationController = PresentationController.getInstance();

    public SlideCountDrawer() {
        this.xPosition = ApplicationFrame.WIDTH - 100;
        this.yPosition = 20;
    }

    public String getSlideCounter() {
        return "Slide " + (1 + presentationController.getCurrentSlideNumber()) + " of "
                + presentationController.getSize();
    }

    public void draw(Graphics graphics) {
        graphics.drawString(getSlideCounter(), xPosition, yPosition);
    }

}
