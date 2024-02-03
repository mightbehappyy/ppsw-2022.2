package br.upe.ppsw.jabberpoint.model.items;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;

import br.upe.ppsw.jabberpoint.model.items.SlideItem;
import br.upe.ppsw.jabberpoint.view.ApplicationFrame;
import br.upe.ppsw.jabberpoint.view.Style;

public class TextItem extends SlideItem {

    public TextItem(int level, String text) {
        super(level, text);
    }

    public TextItem() {
        super(0, " ");
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    public String getText() {
        return content == null ? " " : content;
    }

    private AttributedString getAttributedString(Style style, float scale) {
        AttributedString attributedString = new AttributedString(getText());

        attributedString.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, content.length());

        return attributedString;
    }

    public List<TextLayout> getLayouts(Graphics g, Style s, float scale) {
        List<TextLayout> layouts = new ArrayList<>();

        AttributedString attrStr = getAttributedString(s, scale);
        Graphics2D g2d = (Graphics2D) g;

        FontRenderContext frc = g2d.getFontRenderContext();
        LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);

        float wrappingWidth = (ApplicationFrame.WIDTH - s.getIndent()) * scale;

        while (measurer.getPosition() < getText().length()) {
            TextLayout layout = measurer.nextLayout(wrappingWidth);
            layouts.add(layout);
        }

        return layouts;
    }

    public String toString() {
        return "TextItem[" + getLevel() + "," + getText() + "]";
    }

}
