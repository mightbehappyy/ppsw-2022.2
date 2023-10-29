package br.upe.ppsw.jabberpoint.model;

import java.util.List;

public interface BaseSlide {

    public abstract void append(SlideItem anItem);

    public abstract void append(int level, String message);

    public abstract void setTitle(String newTitle);

    public abstract String getTitle();

    public abstract TextItem getTextItemTitle();

    public abstract SlideItem getSlideItem(int number);

    public abstract List<SlideItem> getSlideItems();

    public abstract int getSize();
}
