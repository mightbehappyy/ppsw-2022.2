package br.upe.ppsw.jabberpoint.view;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

import br.upe.ppsw.jabberpoint.control.KeyController;
import br.upe.ppsw.jabberpoint.control.SlideController;
import br.upe.ppsw.jabberpoint.model.Slide;

public class SlideViewerFrame extends JFrame {

  private static final long serialVersionUID = 3227L;

  public static final int WIDTH = 1200;
  public static final int HEIGHT = 800;

  private static SlideViewerFrame instance = null;

  private SlideViewerFrame(String title, SlideController presentation) {
    super(title);

    SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, this);
    presentation.setShowView(slideViewerComponent);

    setupWindow(slideViewerComponent, presentation);
  }

  public static void setInstance(String title, SlideController presentation) {
    if (instance == null) {
      instance = new SlideViewerFrame(title, presentation);
    }
  }

  public static SlideViewerFrame getInstance() {
    return instance;
  }

  public void setupWindow(SlideViewerComponent slideViewerComponent, SlideController presentation) {
    setTitle(this.getTitle());

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    getContentPane().add(slideViewerComponent);
    addKeyListener(new KeyController());
    setMenuBar(new MenuViewer());
    setSize(new Dimension(WIDTH, HEIGHT));

    setVisible(true);
  }

}
