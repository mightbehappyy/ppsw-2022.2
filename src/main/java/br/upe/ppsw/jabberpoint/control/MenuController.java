package br.upe.ppsw.jabberpoint.control;

import br.upe.ppsw.jabberpoint.model.Presentation;
import br.upe.ppsw.jabberpoint.view.DialogBoxes;
import br.upe.ppsw.jabberpoint.view.MenuViewer;
import br.upe.ppsw.jabberpoint.model.Accessor;
import br.upe.ppsw.jabberpoint.model.MenuModel;

import java.awt.Frame;
import java.awt.MenuBar;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.springframework.util.ResourceUtils;

public class MenuController extends MenuBar {

  private static final long serialVersionUID = 227L;

  private Frame frame;
  private transient Presentation presentation;
  private transient Accessor xmlAccessor;

  private MenuViewer menuViewer;
  private MenuModel menuModel;
  protected static final String TESTFILE = "classpath:test.xml";
  protected static final String SAVEFILE = "classpath:dump.xml";

  protected static final String IOEX = "IO Exception: ";
  protected static final String LOADERR = "Erro ao carregar";
  protected static final String SAVEERR = "Erro ao salvar";

  public MenuController(Frame frame, Presentation pres, MenuViewer menuViewer) {
    this.frame = frame;
    this.presentation = pres;
    this.menuViewer = menuViewer;

    this.xmlAccessor = new XMLAccessor();
    this.menuModel = new MenuModel();

  }

  public void createEventListeners() {
    this.aboutMenuButtonListener();
    this.openMenuButtonListener();
    this.newMenuButtonListener();
    this.saveMenuButtonListener();
    this.exitMenuButtonListener();
    this.nextMenuButtonListener();
    this.prevMenuButtonListener();
    this.goToMenuButtonListener();
  }

  private void openMenuButtonListener() {
    menuViewer.getOpenFileButton().addActionListener(actionEvent -> {

      clearPresentation();
      try {
        xmlAccessor.loadFile(presentation, ResourceUtils.getFile(TESTFILE).getAbsolutePath());
        presentation.setSlideNumber(0);
      } catch (IOException exc) {
        JOptionPane.showMessageDialog(this.frame, IOEX + exc, LOADERR, JOptionPane.ERROR_MESSAGE);
      }
      reloadFrame();

    });
  }

  private void newMenuButtonListener() {
    menuViewer.getNewFileButton().addActionListener(actionEvent -> {
      clearPresentation();
      reloadFrame();
    });
  }

  private void saveMenuButtonListener() {
    menuViewer.getSaveButton().addActionListener(actionEvent -> {
      try {
        xmlAccessor.saveFile(presentation, SAVEFILE);
      } catch (IOException exc) {
        JOptionPane.showMessageDialog(this.frame, IOEX + exc, SAVEERR, JOptionPane.ERROR_MESSAGE);
      }

    });
  }

  private void exitMenuButtonListener() {
    menuViewer.getExitProgramButton().addActionListener(actionEvent -> presentation.exit());
  }

  private void nextMenuButtonListener() {
    menuViewer.getNextSlideButton().addActionListener(actionEvent -> presentation.nextSlide());
  }

  private void prevMenuButtonListener() {
    menuViewer.getPreviousSlideButton().addActionListener(actionEvent -> presentation.prevSlide());

  }

  private void goToMenuButtonListener() {
    menuViewer.getGoToSlideButton()
        .addActionListener(actionEvent -> presentation.setSlideNumber(getUserPageNumberInput() - 1));
  }

  private int getUserPageNumberInput() {
    return menuModel.getUserSelectedSlideNumber();
  }

  private void aboutMenuButtonListener() {
    menuViewer.getAboutButton().addActionListener(actionEvent -> DialogBoxes.showAboutBox(frame));
  }

  private void clearPresentation() {
    presentation.clear();
  }

  private void reloadFrame() {
    this.frame.repaint();
  }

}
