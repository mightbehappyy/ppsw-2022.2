package br.upe.ppsw.jabberpoint.view.drawers;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import br.upe.ppsw.jabberpoint.view.Style;

public interface IItemDrawer {

    public abstract Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle);

    public abstract void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver o);
}
