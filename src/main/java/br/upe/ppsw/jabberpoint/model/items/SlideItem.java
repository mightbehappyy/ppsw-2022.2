package br.upe.ppsw.jabberpoint.model.items;

import br.upe.ppsw.jabberpoint.model.interfaces.IContentableItem;
import br.upe.ppsw.jabberpoint.model.interfaces.ILevelableItem;

public abstract class SlideItem implements ILevelableItem, IContentableItem {

    protected String content;
    private int level = 0;
    private String kind;

    protected SlideItem(int level, String content, String kind) {
        this.content = content.isEmpty() ? " " : content;
        this.level = level;
        this.kind = kind;
    }

    public String getKind() {
        return this.kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String getContent() {
        return this.content == null ? " " : this.content;
    }

    protected abstract void setContent(String content);

    @Override
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
