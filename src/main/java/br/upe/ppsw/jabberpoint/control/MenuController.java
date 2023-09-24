package br.upe.ppsw.jabberpoint.control;

import br.upe.ppsw.jabberpoint.model.Presentation;
import br.upe.ppsw.jabberpoint.view.AboutBox;
import br.upe.ppsw.jabberpoint.model.Accessor;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.springframework.util.ResourceUtils;

public class MenuController extends MenuBar {

  private static final long serialVersionUID = 227L;

  private Frame parent;
  private Presentation presentation;

  private MenuItem menuItem;
  private Menu fileMenu;
  private Menu viewMenu;
  private Menu helpMenu;

  private Accessor xmlAccessor;

  protected static final String ABOUT = "Sobre";
  protected static final String FILE = "Arquivo";
  protected static final String EXIT = "Sair";
  protected static final String GOTO = "Pular para";
  protected static final String HELP = "Ajuda";
  protected static final String NEW = "Novo";
  protected static final String NEXT = "Próximo";
  protected static final String OPEN = "Abrir";
  protected static final String PAGENR = "Número do Slide?";
  protected static final String PREV = "Anterior";
  protected static final String SAVE = "Salvar";
  protected static final String VIEW = "Visualizar";

  protected static final String TESTFILE = "classpath:test.xml";
  protected static final String SAVEFILE = "classpath:dump.xml";

  protected static final String IOEX = "IO Exception: ";
  protected static final String LOADERR = "Erro ao carregar";
  protected static final String SAVEERR = "Erro ao salvar";

  public MenuController(Frame frame, Presentation pres) {
    this.parent = frame;
    this.presentation = pres;
    this.xmlAccessor = new XMLAccessor();

    this.fileMenu = new Menu(FILE);
    this.viewMenu = new Menu(VIEW);
    this.helpMenu = new Menu(HELP);

    this.createMenus();
    this.createButtons();
    this.createEventListeners();

  }

  public MenuItem mkMenuItem(String name) {
    return new MenuItem(name, new MenuShortcut(name.charAt(0)));
  }

  public void createMenus() {
    add(this.fileMenu);
    add(this.viewMenu);
    setHelpMenu(this.helpMenu);
  }

  public void createButtons() {
    this.createOpenMenuButton();
    this.createNewMenuButton();
    this.createSaveMenuButton();
    this.createExitMenuButton();
    this.createNextMenuButton();
    this.createPrevMenuButton();
    this.createGoToMenuButton();
    this.createAboutMenuButton();
  }

  public void createEventListeners() {
    this.openMenuButtonListener();
    this.newMenuButtonListener();
    this.saveMenuButtonListener();
    this.exitMenuButtonListener();
    this.nextMenuButtonListener();
    this.prevMenuButtonListener();
    this.goToMenuButton();
    this.aboutMenuButton();
  }

  public void createOpenMenuButton() {
    this.menuItem = mkMenuItem(OPEN);
    this.fileMenu.add(this.menuItem);
  }

  public void openMenuButtonListener() {
    this.menuItem.addActionListener(actionEvent -> {

      presentation.clear();

      try {
        xmlAccessor.loadFile(presentation, ResourceUtils.getFile(TESTFILE).getAbsolutePath());
        presentation.setSlideNumber(0);
      } catch (IOException exc) {
        JOptionPane.showMessageDialog(parent, IOEX + exc, LOADERR, JOptionPane.ERROR_MESSAGE);
      }

      parent.repaint();

    });
  }

  public void createNewMenuButton() {
    this.menuItem = mkMenuItem(NEW);
    this.fileMenu.add(this.menuItem);
  }

  public void newMenuButtonListener() {
    this.menuItem.addActionListener(actionEvent -> {
      presentation.clear();
      parent.repaint();
    });
  }

  public void createSaveMenuButton() {
    this.menuItem = mkMenuItem(SAVE);
    this.fileMenu.add(this.menuItem);
  }

  public void saveMenuButtonListener() {
    this.menuItem.addActionListener(actionEvent -> {
      try {
        xmlAccessor.saveFile(presentation, SAVEFILE);
      } catch (IOException exc) {
        JOptionPane.showMessageDialog(parent, IOEX + exc, SAVEERR, JOptionPane.ERROR_MESSAGE);
      }

    });
  }

  public void createExitMenuButton() {
    this.addButtonSeparator();
    this.menuItem = mkMenuItem(EXIT);
    this.fileMenu.add(this.menuItem);
  }

  public void exitMenuButtonListener() {
    this.menuItem.addActionListener(actionEvent -> presentation.exit(0));
  }

  public void createNextMenuButton() {
    this.menuItem = mkMenuItem(NEXT);
    this.viewMenu.add(this.menuItem);
  }

  public void nextMenuButtonListener() {
    this.menuItem.addActionListener(actionEvent -> presentation.nextSlide());
  }

  public void createPrevMenuButton() {
    this.menuItem = mkMenuItem(PREV);
    this.viewMenu.add(this.menuItem);
  }

  public void prevMenuButtonListener() {
    this.menuItem.addActionListener(actionEvent -> presentation.prevSlide());

  }

  public void createGoToMenuButton() {
    this.menuItem = mkMenuItem(GOTO);
    this.viewMenu.add(this.menuItem);
  }

  public void goToMenuButton() {
    this.menuItem.addActionListener(actionEvent -> {

      String pageNumberStr = JOptionPane.showInputDialog(PAGENR);
      int pageNumber = Integer.parseInt(pageNumberStr);
      presentation.setSlideNumber(pageNumber - 1);

    });
  }

  public void createAboutMenuButton() {
    this.menuItem = mkMenuItem(ABOUT);
    this.helpMenu.add(this.menuItem);
  }

  public void aboutMenuButton() {
    this.menuItem.addActionListener(actionEvent -> AboutBox.show(parent));
  }

  public void addButtonSeparator() {
    this.fileMenu.addSeparator();
  }
}
