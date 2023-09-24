package br.upe.ppsw.jabberpoint.view;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import br.upe.ppsw.jabberpoint.control.MenuController;
import br.upe.ppsw.jabberpoint.model.Presentation;

public class MenuViewer extends MenuBar {

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

    private MenuController menuController;
    private MenuItem menuItem;
    private Menu fileMenu;
    private Menu viewMenu;
    private Menu helpMenu;

    public MenuViewer(Frame frame, Presentation pres) {
        this.fileMenu = new Menu(FILE);
        this.viewMenu = new Menu(VIEW);
        this.helpMenu = new Menu(HELP);
        this.menuController = new MenuController(frame, pres, this);

        this.drawMenus();
        this.drawButtons();
        this.menuController.createEventListeners();
    }

    public MenuItem createMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }

    public void drawMenus() {
        this.add(this.fileMenu);
        this.add(this.viewMenu);
        this.setHelpMenu(this.helpMenu);
    }

    public void drawButtons() {
        this.createOpenMenuButton();
        this.createNewMenuButton();
        this.createSaveMenuButton();
        this.createExitMenuButton();
        this.createNextMenuButton();
        this.createPrevMenuButton();
        this.createGoToMenuButton();
        this.createAboutMenuButton();
    }

    public void createOpenMenuButton() {
        this.menuItem = createMenuItem(OPEN);
        this.fileMenu.add(this.menuItem);
    }

    public void createNewMenuButton() {
        this.menuItem = createMenuItem(NEW);
        this.fileMenu.add(this.menuItem);
    }

    public void createSaveMenuButton() {
        this.menuItem = createMenuItem(SAVE);
        this.fileMenu.add(this.menuItem);
    }

    public void createExitMenuButton() {
        this.addButtonSeparator();
        this.menuItem = createMenuItem(EXIT);
        this.fileMenu.add(this.menuItem);
    }

    public void addButtonSeparator() {
        this.fileMenu.addSeparator();
    }

    public void createNextMenuButton() {
        this.menuItem = createMenuItem(NEXT);
        this.viewMenu.add(this.menuItem);
    }

    public void createPrevMenuButton() {
        this.menuItem = createMenuItem(PREV);
        this.viewMenu.add(this.menuItem);
    }

    public void createGoToMenuButton() {
        this.menuItem = createMenuItem(GOTO);
        this.viewMenu.add(this.menuItem);
    }

    public void createAboutMenuButton() {
        this.menuItem = createMenuItem(ABOUT);
        this.helpMenu.add(this.menuItem);
    }

    public MenuItem getMenuItem() {
        return this.menuItem;
    }

}
