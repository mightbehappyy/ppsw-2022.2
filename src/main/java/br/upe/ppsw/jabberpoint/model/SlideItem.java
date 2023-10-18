package br.upe.ppsw.jabberpoint.model;

import br.upe.ppsw.jabberpoint.model.interfaces.ISlideItem;

public abstract class SlideItem implements ISlideItem {

  private int level = 0;

  protected SlideItem(int lev) {
    level = lev;
  }

  protected SlideItem() {
    this(0);
  }

  public int getLevel() {
    return level;
  }

}
