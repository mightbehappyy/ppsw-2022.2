package br.upe.ppsw.jabberpoint.view.drawers;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.model.SlideItem;
import br.upe.ppsw.jabberpoint.view.ApplicationFrame;
import br.upe.ppsw.jabberpoint.view.Style;

public class SlideDrawer {
    private Slide slide;

    public SlideDrawer(Slide slide) {
        this.slide = slide;

    }

    public void draw(Graphics graphics, Rectangle area, ImageObserver view) {
        float scale = getScale(area);

        int y = area.y;

        SlideItem slideItem = slide.getTextItemTitle();

        IItemDrawer baseItemDrawer = ItemFactory.createDrawer(slideItem);

        Style style = Style.getStyle(slideItem.getLevel());
        baseItemDrawer.draw(y, y, scale, graphics, style, view);

        y += baseItemDrawer.getBoundingBox(graphics, view, scale, style).height;

        for (int number = 0; number < slide.getSize(); number++) {
            slideItem = slide.getSlideItems().get(number);
            baseItemDrawer = ItemFactory.createDrawer(slideItem);

            style = Style.getStyle(slideItem.getLevel());
            baseItemDrawer.draw(area.x, y, scale, graphics, style, view);

            y += baseItemDrawer.getBoundingBox(graphics, view, scale, style).height;
        }
    }

    private float getScale(Rectangle area) {
        return Math.min(((float) area.width) / (ApplicationFrame.WIDTH),
                ((float) area.height) / (ApplicationFrame.HEIGHT));
    }

}
