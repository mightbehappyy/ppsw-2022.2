package br.upe.ppsw.jabberpoint.view.drawers;

import java.awt.Graphics;
import java.awt.Rectangle;

import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.model.SlideItem;
import br.upe.ppsw.jabberpoint.view.ApplicationFrame;
import br.upe.ppsw.jabberpoint.view.ContentPanel;
import br.upe.ppsw.jabberpoint.view.Style;
import br.upe.ppsw.jabberpoint.view.drawers.interfaces.IDrawableItem;

public class SlideDrawer {

    private ContentPanel panel;

    public SlideDrawer(ContentPanel panel) {
        this.panel = panel;
    }

    public void draw(Graphics graphics, Slide slide) {
        Rectangle area = new Rectangle(0, panel.getYPOS(), panel.getWidth(), (panel.getHeight() - panel.getYPOS()));

        float scale = getScale(area);

        int y = area.y;

        SlideItem slideItem = slide.getTextItemTitle();

        IDrawableItem baseItemDrawer = ItemFactory.createDrawer(slideItem);

        Style style = Style.getStyle(slideItem.getLevel());
        baseItemDrawer.draw(y, y, scale, graphics, style, panel);

        y += baseItemDrawer.getBoundingBox(graphics, panel, scale, style).height;

        for (int number = 0; number < slide.getSize(); number++) {
            slideItem = slide.getSlideItems().get(number);
            baseItemDrawer = ItemFactory.createDrawer(slideItem);

            style = Style.getStyle(slideItem.getLevel());
            baseItemDrawer.draw(area.x, y, scale, graphics, style, panel);

            y += baseItemDrawer.getBoundingBox(graphics, panel, scale, style).height;
        }
    }

    private float getScale(Rectangle area) {
        return Math.min(((float) area.width) / (ApplicationFrame.WIDTH),
                ((float) area.height) / (ApplicationFrame.HEIGHT));
    }

}
