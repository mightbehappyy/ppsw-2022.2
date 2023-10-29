package br.upe.ppsw.jabberpoint.view.drawers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import br.upe.ppsw.jabberpoint.controller.PresentationController;

public class SlideCountDrawer {

    private int xPosition;
    private int yPosition;
    private final PresentationController presentationController = PresentationController.getInstance();

    public SlideCountDrawer(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;

    }

    public String getSlideCounter() {
        return "Slide " + (1 + presentationController.getCurrentSlideNumber()) + " of "
                + presentationController.getSize();
    }

    public void draw(Graphics graphics) {
        Font labelFont = new Font("Dialog", Font.BOLD, 10);
        graphics.setFont(labelFont);
        graphics.setColor(Color.BLACK);
        graphics.drawString(getSlideCounter(), xPosition, yPosition);
    }

}
