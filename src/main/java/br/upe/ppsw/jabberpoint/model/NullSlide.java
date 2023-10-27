package br.upe.ppsw.jabberpoint.model;

public class NullSlide extends Slide {
    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public SlideItem getSlideItem(int number) {
        return null;
    }

    @Override
    public TextItem getTextItemTitle() {
        return new TextItem(0, " ");
    }
}
