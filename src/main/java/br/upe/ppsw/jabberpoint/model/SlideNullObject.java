package br.upe.ppsw.jabberpoint.model;

import br.upe.ppsw.jabberpoint.model.items.SlideItem;
import br.upe.ppsw.jabberpoint.model.items.TextItem;

import java.util.Collections;
import java.util.List;

public class SlideNullObject extends Slide {

    public SlideNullObject() {
        setTitle("");
        append(new TextItem());
    }

    @Override
    public void append(int level, String message) {
        // Null Object
    }

    @Override
    public void setTitle(String newTitle) {
        // Null Object
    }

    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public TextItem getTextItemTitle() {
        return new TextItem(0, "");
    }

    @Override
    public SlideItem getSlideItem(int number) {
        return new TextItem();
    }

    @Override
    public List<SlideItem> getSlideItems() {
        return Collections.emptyList();
    }

    @Override
    public int getSize() {
        return 0;
    }
}
