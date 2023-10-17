package br.upe.ppsw.jabberpoint.model;

import java.awt.Graphics;
import java.util.List;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import br.upe.ppsw.jabberpoint.view.Style;
import br.upe.ppsw.jabberpoint.view.drawers.SlideDrawer;

public class Slide {

  public static final int WIDTH = 1200;
  public static final int HEIGHT = 800;

  private TextItem title;
  private ArrayList<SlideItem> items;
  private SlideDrawer slideDrawer;

  public Slide() {
    items = new ArrayList<>();
    slideDrawer = new SlideDrawer(this);

  }

  public void append(SlideItem anItem) {
    items.add(anItem);
  }

  public String getTitle() {
    return title.getText();
  }

  public TextItem getTextItem() {
    return title;
  }

  public void setTitle(String newTitle) {
    title = new TextItem(0, newTitle);
  }

  public void append(int level, String message) {
    append(new TextItem(level, message));
  }

  public SlideItem getSlideItem(int number) {
    return items.get(number);
  }

  public List<SlideItem> getSlideItems() {
    return items;
  }

  public int getSize() {
    return items.size();
  }

}
