package br.upe.ppsw.jabberpoint.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

import br.upe.ppsw.jabberpoint.controller.PresentationController;
import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.view.drawers.SlideDrawer;
import br.upe.ppsw.jabberpoint.view.drawers.SlideCountDrawer;

public class ContentPanel extends JPanel {
  private static final long serialVersionUID = 227L;
  private static final Color BACKGROUND_COLOR = Color.white;
  private static final Color COLOR = Color.black;
  private static final String FONTNAME = "Dialog";
  private static final int FONTSTYLE = Font.BOLD;
  private static final int FONTHEIGHT = 10;
  private static final int XPOS = 1100;
  private static final int YPOS = 10;

  private Font labelFont;
  private PresentationController presentationController;
  private Slide slide = Slide.NULL_SLIDE;
  private SlideCountDrawer slidePageCounter;
  private SlideDrawer slideDrawer;

  public ContentPanel() {
    this.slidePageCounter = new SlideCountDrawer();
    this.labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
    this.slideDrawer = new SlideDrawer(this);
    presentationController = PresentationController.getInstance();
    presentationController.setShowView(this);

  }

  public void update(Slide slide) {
    this.slide = slide;
    repaint();
  }

  @Override
  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);

    setBackground(BACKGROUND_COLOR);

    graphics.setFont(labelFont);
    graphics.setColor(COLOR);

    slidePageCounter.draw(graphics);
    slideDrawer.draw(graphics, slide);

  }

  public int getYPOS() {
    return YPOS;
  }

  public int getXPOS() {
    return XPOS;
  }

}
