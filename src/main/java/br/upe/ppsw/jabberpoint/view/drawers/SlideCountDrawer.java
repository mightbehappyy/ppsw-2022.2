package br.upe.ppsw.jabberpoint.view.drawers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import br.upe.ppsw.jabberpoint.model.items.SlideCountItem;

public class SlideCountDrawer {

    private final SlideCountItem slideCountItem;

    public SlideCountDrawer(SlideCountItem slideCountItem) {
        this.slideCountItem = slideCountItem;

    }

    public void draw(Graphics graphics) {
        Font labelFont = new Font("Dialog", Font.BOLD, 10);
        graphics.setFont(labelFont);
        graphics.setColor(Color.BLACK);
        graphics.drawString(slideCountItem.getSlideCounter(), slideCountItem.getXPostion(),
                slideCountItem.getYPostion());
    }

}
