package br.upe.ppsw.jabberpoint.model;

import br.upe.ppsw.jabberpoint.model.interfaces.ILevelableItem;

public abstract class SlideItem implements ILevelableItem {

  private int level = 0;

  protected SlideItem(int lev) {
    level = lev;
  }

  protected SlideItem() {

  }

  public int getLevel() {
    return level;
  }

}
