package br.upe.ppsw.jabberpoint.model.items;

import br.upe.ppsw.jabberpoint.model.interfaces.ILevelableItem;

public abstract class SlideItem implements ILevelableItem {

    private int level = 0;
    protected String content;

    protected SlideItem(int lev, String content) {
        this.content = content.isEmpty() ? " " : content;
        level = lev;
    }

    protected SlideItem() {

    }

    public String getContent() {
        return content == null ? " " : content;
    }

    protected abstract void setContent(String content);

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
