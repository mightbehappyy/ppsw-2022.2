package br.upe.ppsw.jabberpoint.view.drawers;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.util.List;

import br.upe.ppsw.jabberpoint.model.TextItem;
import br.upe.ppsw.jabberpoint.view.Style;
import br.upe.ppsw.jabberpoint.view.drawers.interfaces.IDrawableItem;

public class TextItemDrawer implements IDrawableItem {

    private TextItem textItem;

    public TextItemDrawer(TextItem slideItem) {
        this.textItem = slideItem;
    }

    @Override
    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale, Style myStyle) {
        List<TextLayout> layouts = textItem.getLayouts(graphics, myStyle, scale);

        int xsize = 0;
        int ysize = (int) (myStyle.getLeading() * scale);

        for (TextLayout layout : layouts) {
            Rectangle2D bounds = layout.getBounds();

            if (bounds.getWidth() > xsize) {
                xsize = (int) bounds.getWidth();
            }

            if (bounds.getHeight() > 0) {
                ysize += bounds.getHeight();
            }
            ysize += layout.getLeading() + layout.getDescent();
        }

        return new Rectangle((int) (myStyle.getIndent() * scale), 0, xsize, ysize);
    }

    @Override
    public void draw(int x, int y, float scale, Graphics graphics, Style myStyle, ImageObserver o) {

        List<TextLayout> layouts = textItem.getLayouts(graphics, myStyle, scale);
        Point pen = new Point(x + (int) (myStyle.getIndent() * scale), y + (int) (myStyle.getLeading() * scale));

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setColor(myStyle.getColor());

        for (TextLayout layout : layouts) {
            pen.y += layout.getAscent();
            layout.draw(g2d, pen.x, pen.y);

            pen.y += layout.getDescent();
        }
    }

}
