package br.upe.ppsw.jabberpoint.view.drawers;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.model.SlideItem;
import br.upe.ppsw.jabberpoint.view.Style;

public class SlideDrawer {
    private Slide slide;

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 800;

    public SlideDrawer(Slide slide) {
        this.slide = slide;

    }

    public void draw(Graphics g, Rectangle area, ImageObserver view) {
        float scale = getScale(area);

        int y = area.y;

        SlideItem slideItem = slide.getTextItemTitle();

        IItemDrawer baseItemDrawer = ItemFactory.createDrawer(slideItem);

        Style style = Style.getStyle(slideItem.getLevel());
        baseItemDrawer.draw(y, y, scale, g, style, view);

        y += baseItemDrawer.getBoundingBox(g, view, scale, style).height;

        for (int number = 0; number < slide.getSize(); number++) {
            slideItem = slide.getSlideItems().get(number);
            baseItemDrawer = ItemFactory.createDrawer(slideItem);

            style = Style.getStyle(slideItem.getLevel());
            baseItemDrawer.draw(area.x, y, scale, g, style, view);

            y += baseItemDrawer.getBoundingBox(g, view, scale, style).height;
        }
    }

    private float getScale(Rectangle area) {
        return Math.min(((float) area.width) / (WIDTH),
                ((float) area.height) / (HEIGHT));
    }

}
