package br.upe.ppsw.jabberpoint.view;

import java.awt.Color;
import java.awt.Font;

public class Style {

  private static Style[] styles;

  private static final String FONTNAME = "Helvetica";
  private final int indent;
  private final Color color;
  private final Font font;
  private final int fontSize;
  private final int leading;

  public Style(int indent, Color color, int points, int leading) {
    this.indent = indent;
    this.color = color;
    this.fontSize = points;
    this.leading = leading;
    this.font = new Font(FONTNAME, Font.BOLD, this.fontSize);
  }

  public static void createStyles() {
    styles = new Style[5];
    styles[0] = new Style(10, Color.red, 48, 20); // nível 0
    styles[1] = new Style(20, Color.blue, 40, 10); // nível 1
    styles[2] = new Style(50, Color.black, 36, 10); // nível 2
    styles[3] = new Style(70, Color.black, 30, 10); // nivel 3
    styles[4] = new Style(90, Color.black, 24, 10); // nível 4
  }

  public static Style getStyle(int level) {
    if (level >= styles.length) {
      level = styles.length - 1;
    }

    return styles[level];
  }

  public Font getFont(float scale) {
    return font.deriveFont(fontSize * scale);
  }

  public int getIndent() {
    return this.indent;
  }

  public Color getColor() {
    return this.color;
  }

  public int getLeading() {
    return this.leading;
  }

}
