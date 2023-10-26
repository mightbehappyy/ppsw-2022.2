package br.upe.ppsw.jabberpoint.view;

import java.awt.Dimension;

import javax.swing.JFrame;

import br.upe.ppsw.jabberpoint.controller.KeyController;

public class ApplicationFrame extends JFrame {

  private static final long serialVersionUID = 3227L;

  private static ApplicationFrame instance = null;

  public static final int WIDTH = 1200;
  public static final int HEIGHT = 800;

  private ApplicationFrame(String title) {
    super(title);
    setupWindowFrame();
  }

  public static ApplicationFrame setInstance(String title) {
    if (instance == null) {
      instance = new ApplicationFrame(title);
    }
    return instance;

  }

  public static ApplicationFrame getInstance() {
    return instance;
  }

  private void setupWindowFrame() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    add(new ContentPanel());
    addKeyListener(new KeyController());
    setMenuBar(new MenuViewer());
    setSize(new Dimension(WIDTH, HEIGHT));

    setLocationRelativeTo(null);
    setVisible(true);

  }

}
