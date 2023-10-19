package br.upe.ppsw.jabberpoint.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;

import br.upe.ppsw.jabberpoint.controller.SlideController;
import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.view.drawers.SlideDrawer;

public class ContentPanel extends JPanel {
  private static final long serialVersionUID = 227L;
  private static final Color BGCOLOR = Color.white;
  private static final Color COLOR = Color.black;
  private static final String FONTNAME = "Dialog";
  private static final int FONTSTYLE = Font.BOLD;
  private static final int FONTHEIGHT = 10;
  private static final int XPOS = 1100;
  private static final int YPOS = 20;

  private Slide slide;
  private SlideDrawer slideDrawer;
  private Font labelFont;
  private SlideController slideController;

  public ContentPanel() {
    setBackground(BGCOLOR);
    this.slideController = SlideController.getInstance();
    slideController.setShowView(this);
    labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);

  }

  public void update(Slide slide) {
    this.slide = slide;
    if (slide == null) {
      repaint();
    }
    repaint();
  }

  public void updateSlide() {
    repaint();
  }

  @Override
  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    graphics.setColor(BGCOLOR);
    graphics.fillRect(0, 0, getSize().width, getSize().height);

    if (slideController.getCurrentSlideNumber() < 0 || slide == null) {
      return;
    }

    graphics.setFont(labelFont);
    graphics.setColor(COLOR);
    graphics.drawString("Slide " + (1 + slideController.getCurrentSlideNumber()) + " of " + slideController.getSize(),
        XPOS, YPOS);

    Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));

    slideDrawer = new SlideDrawer(slide);
    slideDrawer.draw(graphics, area, this);
  }

}
