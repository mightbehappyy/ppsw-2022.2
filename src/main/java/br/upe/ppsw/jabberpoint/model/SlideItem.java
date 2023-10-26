package br.upe.ppsw.jabberpoint.model;

import br.upe.ppsw.jabberpoint.model.interfaces.ILevelableItem;

public abstract class SlideItem implements ILevelableItem {

  private int level = 0;

  protected SlideItem(int lev) {
    level = lev;
  }

  public int getLevel() {
    return level;
  }

}
