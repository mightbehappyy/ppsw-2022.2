package br.upe.ppsw.jabberpoint.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import br.upe.ppsw.jabberpoint.controller.PresentationController;
import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.view.drawers.SlideDrawer;
import br.upe.ppsw.jabberpoint.view.drawers.SlideCountDrawer;

public class ContentPanel extends JPanel {
  private static final long serialVersionUID = 227L;
  private static final int XPOS = 1100;
  private static final int YPOS = 10;

  private PresentationController presentationController;
  private transient Slide slide = Slide.NULL_SLIDE;
  private transient SlideCountDrawer slidePageCounter;
  private transient SlideDrawer slideDrawer;

  public ContentPanel() {
    this.slideDrawer = new SlideDrawer(this);
    this.slidePageCounter = new SlideCountDrawer(XPOS, YPOS);

    presentationController = PresentationController.getInstance();
    presentationController.setShowView(this);

  }

  public void update(Slide slide) {
    this.slide = slide;
    repaint();
  }

  @Override
  public void paintComponent(Graphics graphics) {
    if (slide == null) {
      return;
    }
    super.paintComponent(graphics);

    setBackground(Color.white);

    slidePageCounter.draw(graphics);
    slideDrawer.draw(graphics, slide, getDrawableArea());

    graphics.dispose();

  }

  public float getScreenScale(Rectangle area) {
    return Math.min(((float) area.width) / (ApplicationFrame.WIDTH),
        ((float) area.height) / (ApplicationFrame.HEIGHT));
  }

  private Rectangle getDrawableArea() {
    return new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
  }

}
