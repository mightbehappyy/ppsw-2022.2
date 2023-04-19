package br.upe.ppsw.jabberpoint.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

import br.upe.ppsw.jabberpoint.view.Style;
import br.upe.ppsw.jabberpoint.view.createStyles;

public class Slide {

  public final static int WIDTH = 1200;
  public final static int HEIGHT = 800;

  protected TextItem title;
  protected Vector<SlideItem> items;

  public Slide() {
    items = new Vector<>();
  }

  public void append(SlideItem anItem) {
    items.addElement(anItem);
  }

  public String getTitle() {
    return title.getText();
  }

  public void setTitle(String newTitle) {
    title = new TextItem(0, newTitle);
  }

  public void append(int level, String message) {
    append(new TextItem(level, message));
  }

  public SlideItem getSlideItem(int number) {
    return items.elementAt(number);
  }

  public Vector<SlideItem> getSlideItems() {
    return items;
  }

  public int getSize() {
    return items.size();
  }
  private int organize(SlideItem slideItem, int y, Graphics g, Rectangle area, ImageObserver view)
  {
    Style style = createStyles.getStyle(slideItem.getLevel());
    slideItem.draw(area.x, y, getScale(area), g, style, view);
    //define o level de cada item.
    return slideItem.getBoundingBox(g, view, getScale(area), style).height;
  }

  //Desenha o conteudo dos slides nas telas.
  public void draw(Graphics g, Rectangle area, ImageObserver view) {
    int y = area.y;

    //Desenha o titulo
    y += organize(new TextItem(0, getTitle()), y, g, area, view);

    //Desenha o resto 
    for (int number = 0; number < this.getSize(); number++)
    {
      y += organize(getSlideItems().elementAt(number), y, g, area, view);
    }
    }


  private float getScale(Rectangle area) {
    return Math.min(((float) area.width) / ((float) WIDTH),
        ((float) area.height) / ((float) HEIGHT));
  }
}
