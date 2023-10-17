package br.upe.ppsw.jabberpoint.view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.upe.ppsw.jabberpoint.controller.KeyController;
import br.upe.ppsw.jabberpoint.controller.SlideController;

public class ApplicationFrame extends JFrame {

  private static final long serialVersionUID = 3227L;

  private static ApplicationFrame instance = null;

  private ContentPanel contentPanel;

  private static final int DEFAULT_FRAME_WIDTH = 1200;
  private static final int DEFAULT_FRAME_HEIGHT = 800;

  private ApplicationFrame(String title, SlideController slideController) {
    super(title);
    contentPanel = new ContentPanel(slideController, this);
    slideController.setShowView(contentPanel);
    setupApplicationFrame(contentPanel);
  }

  private void setupApplicationFrame(JPanel contentPanel) {

    setDefaultCloseOperation(EXIT_ON_CLOSE);

    add(contentPanel);
    addKeyListener(new KeyController());
    setMenuBar(new MenuViewer());
    setSize(new Dimension(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT));

    setLocationRelativeTo(null);
    setVisible(true);
  }

  public int getFrameWidth() {
    return DEFAULT_FRAME_WIDTH;
  }

  public int getFrameHeight() {
    return DEFAULT_FRAME_HEIGHT;
  }

  public static ApplicationFrame setInstance(String title, SlideController slideController) {
    if (instance == null) {
      instance = new ApplicationFrame(title, slideController);
    }
    return instance;

  }

  public static ApplicationFrame getInstance() {
    return instance;
  }

}
