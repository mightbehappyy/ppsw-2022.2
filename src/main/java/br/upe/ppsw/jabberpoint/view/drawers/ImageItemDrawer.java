package br.upe.ppsw.jabberpoint.view.drawers;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import br.upe.ppsw.jabberpoint.model.ImageItem;
import br.upe.ppsw.jabberpoint.view.Style;
import br.upe.ppsw.jabberpoint.view.drawers.interfaces.IDrawableItem;

public class ImageItemDrawer implements IDrawableItem {

    private ImageItem imageItem;

    public ImageItemDrawer(ImageItem imageItem) {
        this.imageItem = imageItem;
    }

    @Override
    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale, Style myStyle) {
        return new Rectangle((int) (myStyle.getIndent() * scale), 0,
                (int) (imageItem.getBufferedImage().getWidth(observer) * scale),
                ((int) (myStyle.getLeading() * scale))
                        + (int) (imageItem.getBufferedImage().getHeight(observer) * scale));
    }

    @Override
    public void draw(int x, int y, float scale, Graphics graphics, Style myStyle, ImageObserver observer) {
        int width = x + (int) (myStyle.getIndent() * scale);
        int height = y + (int) (myStyle.getLeading() * scale);

        graphics.drawImage(imageItem.getBufferedImage(), width, height,
                (int) (imageItem.getBufferedImage().getWidth(observer) * scale),
                (int) (imageItem.getBufferedImage().getHeight(observer) * scale), observer);
    }

}
