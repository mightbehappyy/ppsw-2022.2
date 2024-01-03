package br.upe.ppsw.jabberpoint.view.drawers;

import java.awt.Graphics;
import java.awt.Rectangle;

import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.model.SlideItem;
import br.upe.ppsw.jabberpoint.view.ContentPanel;
import br.upe.ppsw.jabberpoint.view.Style;
import br.upe.ppsw.jabberpoint.view.drawers.interfaces.IDrawableItem;

public class SlideDrawer {

    private final ContentPanel panel;

    public SlideDrawer(ContentPanel panel) {
        this.panel = panel;
    }

    public void draw(Graphics graphics, Slide slide, Rectangle area) {
        SlideItem slideItem;
        IDrawableItem baseItemDrawer;
        Style style;
        int itemHeight = area.y;
        float scale = panel.getScreenScale(area);

        for (int number = 0; number < slide.getSize(); number++) {
            slideItem = slide.getSlideItems().get(number);

            baseItemDrawer = DrawerCreator.createDrawer(slideItem);

            style = Style.getStyle(slideItem.getLevel());

            baseItemDrawer.draw(area.x, itemHeight, scale, graphics, style, panel);

            itemHeight += baseItemDrawer.getBoundingBox(graphics, panel, scale, style).height;
        }
    }

}
