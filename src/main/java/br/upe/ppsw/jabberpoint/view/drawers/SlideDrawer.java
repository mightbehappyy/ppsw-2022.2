package br.upe.ppsw.jabberpoint.view.drawers;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;

import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.model.SlideItem;
import br.upe.ppsw.jabberpoint.view.ApplicationFrame;
import br.upe.ppsw.jabberpoint.view.Style;
import br.upe.ppsw.jabberpoint.view.drawers.interfaces.IDrawableItem;

public class SlideDrawer {

    public SlideDrawer() {

    }

    public void draw(Graphics graphics, Rectangle area, Slide slide, JPanel contentPanel) {
        float scale = getScale(area);

        int y = area.y;

        SlideItem slideItem = slide.getTextItemTitle();

        IDrawableItem baseItemDrawer = ItemFactory.createDrawer(slideItem);

        Style style = Style.getStyle(slideItem.getLevel());
        baseItemDrawer.draw(y, y, scale, graphics, style, contentPanel);

        y += baseItemDrawer.getBoundingBox(graphics, contentPanel, scale, style).height;

        for (int number = 0; number < slide.getSize(); number++) {
            slideItem = slide.getSlideItems().get(number);
            baseItemDrawer = ItemFactory.createDrawer(slideItem);

            style = Style.getStyle(slideItem.getLevel());
            baseItemDrawer.draw(area.x, y, scale, graphics, style, contentPanel);

            y += baseItemDrawer.getBoundingBox(graphics, contentPanel, scale, style).height;
        }
    }

    private float getScale(Rectangle area) {
        return Math.min(((float) area.width) / (ApplicationFrame.WIDTH),
                ((float) area.height) / (ApplicationFrame.HEIGHT));
    }

}
