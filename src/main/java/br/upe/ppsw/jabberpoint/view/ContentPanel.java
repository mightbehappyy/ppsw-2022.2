package br.upe.ppsw.jabberpoint.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.*;

import br.upe.ppsw.jabberpoint.model.Presentation;
import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.model.items.SlideCountItem;
import br.upe.ppsw.jabberpoint.model.SlideNullObject;
import br.upe.ppsw.jabberpoint.view.drawers.SlideDrawer;
import br.upe.ppsw.jabberpoint.view.drawers.SlideCountDrawer;

public class ContentPanel extends JPanel {
    private static final long serialVersionUID = 227L;
    private transient Slide slide;
    private final transient SlideDrawer slideDrawer;
    private final transient SlideCountDrawer slideCountDrawer;

    public ContentPanel() {
        this.slideDrawer = new SlideDrawer(this);
        this.slideCountDrawer = new SlideCountDrawer(new SlideCountItem(1100, 20));
        this.slide = new SlideNullObject();
        Presentation.getInstance().setContentPanel(this);
    }

    public void update(Slide slide) {
        this.slide = slide;
        repaint();
    }

    @Override
    public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);

        setBackground(Color.white);

        slideCountDrawer.draw(graphics);
        slideDrawer.draw(graphics, slide, getDrawableArea());

        graphics.dispose();

    }

    public float getScreenScale(Rectangle area) {
        return Math.min(((float) area.width) / (ApplicationFrame.WIDTH),
                ((float) area.height) / (ApplicationFrame.HEIGHT));
    }

    private Rectangle getDrawableArea() {
        return new Rectangle(0, 0, getWidth(), getHeight());
    }

}
