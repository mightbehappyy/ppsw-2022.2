package br.upe.ppsw.jabberpoint.model;

import java.util.List;
import java.util.ArrayList;

public class Slide {

  private TextItem title;
  private ArrayList<SlideItem> items;

  public Slide() {
    items = new ArrayList<>();
  }

  public void append(SlideItem anItem) {
    items.add(anItem);
  }

  public void append(int level, String message) {
    append(new TextItem(level, message));
  }

  public void setTitle(String newTitle) {
    title = new TextItem(0, newTitle);
    append(title);
  }

  public String getTitle() {
    return title.getText();
  }

  public TextItem getTextItemTitle() {
    return title;
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
