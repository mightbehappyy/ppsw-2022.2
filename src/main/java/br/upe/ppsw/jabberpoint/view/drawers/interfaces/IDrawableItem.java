package br.upe.ppsw.jabberpoint.view.drawers.interfaces;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import br.upe.ppsw.jabberpoint.model.items.SlideItem;
import br.upe.ppsw.jabberpoint.view.Style;

public interface IDrawableItem {

    public abstract Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale, Style myStyle);

    public abstract void draw(int x, int y, float scale, Graphics graphics, Style myStyle, ImageObserver o);

    public abstract void setSlideItem(SlideItem slideItem);
}
