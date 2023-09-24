package br.upe.ppsw.jabberpoint.control;

import br.upe.ppsw.jabberpoint.model.Presentation;
import br.upe.ppsw.jabberpoint.view.AboutBox;
import br.upe.ppsw.jabberpoint.view.MenuViewer;
import br.upe.ppsw.jabberpoint.model.Accessor;

import java.awt.Frame;
import java.awt.MenuBar;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.springframework.util.ResourceUtils;

public class MenuController extends MenuBar {

  private static final long serialVersionUID = 227L;

  private Frame frame;
  private Presentation presentation;

  private MenuViewer menuViewer;

  private Accessor xmlAccessor;

  protected static final String PAGENR = "Número do Slide?";

  protected static final String TESTFILE = "classpath:test.xml";
  protected static final String SAVEFILE = "classpath:dump.xml";

  protected static final String IOEX = "IO Exception: ";
  protected static final String LOADERR = "Erro ao carregar";
  protected static final String SAVEERR = "Erro ao salvar";

  public MenuController(Frame frame, Presentation pres, MenuViewer menuViewer) {
    this.frame = frame;
    this.presentation = pres;
    this.xmlAccessor = new XMLAccessor();

    this.menuViewer = menuViewer;

  }

  public void createEventListeners() {
    this.openMenuButtonListener();
    this.newMenuButtonListener();
    this.saveMenuButtonListener();
    this.exitMenuButtonListener();
    this.nextMenuButtonListener();
    this.prevMenuButtonListener();
    this.goToMenuButtonListener();
    this.aboutMenuButtonListener();
  }

  public void openMenuButtonListener() {
    menuViewer.getMenuItem().addActionListener(actionEvent -> {

      presentation.clear();

      try {
        xmlAccessor.loadFile(presentation, ResourceUtils.getFile(TESTFILE).getAbsolutePath());
        presentation.setSlideNumber(0);
      } catch (IOException exc) {
        JOptionPane.showMessageDialog(this.frame, IOEX + exc, LOADERR, JOptionPane.ERROR_MESSAGE);
      }

      this.frame.repaint();

    });
  }

  public void newMenuButtonListener() {
    menuViewer.getMenuItem().addActionListener(actionEvent -> {
      presentation.clear();
      this.frame.repaint();
    });
  }

  public void saveMenuButtonListener() {
    menuViewer.getMenuItem().addActionListener(actionEvent -> {
      try {
        xmlAccessor.saveFile(presentation, SAVEFILE);
      } catch (IOException exc) {
        JOptionPane.showMessageDialog(this.frame, IOEX + exc, SAVEERR, JOptionPane.ERROR_MESSAGE);
      }

    });
  }

  public void exitMenuButtonListener() {
    menuViewer.getMenuItem().addActionListener(actionEvent -> presentation.exit(0));
  }

  public void nextMenuButtonListener() {
    menuViewer.getMenuItem().addActionListener(actionEvent -> presentation.nextSlide());
  }

  public void prevMenuButtonListener() {
    menuViewer.getMenuItem().addActionListener(actionEvent -> presentation.prevSlide());

  }

  public void goToMenuButtonListener() {
    menuViewer.getMenuItem().addActionListener(actionEvent -> {
      String pageNumberStr = JOptionPane.showInputDialog(PAGENR);
      int pageNumber = Integer.parseInt(pageNumberStr);
      presentation.setSlideNumber(pageNumber - 1);

    });
  }

  public void aboutMenuButtonListener() {
    menuViewer.getMenuItem().addActionListener(actionEvent -> AboutBox.show(frame));
  }

}
