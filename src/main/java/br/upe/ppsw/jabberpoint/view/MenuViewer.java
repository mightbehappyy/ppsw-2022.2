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

    private MenuItem openFileButton;
    private MenuItem newFileButton;
    private MenuItem saveButton;
    private MenuItem exitProgramButton;
    private MenuItem nextSlideButton;
    private MenuItem previousSlideButton;
    private MenuItem goToSlideButton;
    private MenuItem aboutButton;

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

    public MenuItem getOpenFileButton() {
        return this.openFileButton;
    }

    public MenuItem getNewFileButton() {
        return this.newFileButton;
    }

    public MenuItem getSaveButton() {
        return this.saveButton;
    }

    public MenuItem getExitProgramButton() {
        return this.exitProgramButton;
    }

    public MenuItem getNextSlideButton() {
        return this.nextSlideButton;
    }

    public MenuItem getPreviousSlideButton() {
        return this.previousSlideButton;
    }

    public MenuItem getGoToSlideButton() {
        return this.goToSlideButton;
    }

    public MenuItem getAboutButton() {
        return aboutButton;
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
        this.openFileButton = createMenuItem(OPEN);
        this.fileMenu.add(this.openFileButton);
    }

    public void createNewMenuButton() {
        this.newFileButton = createMenuItem(NEW);
        this.fileMenu.add(this.newFileButton);
    }

    public void createSaveMenuButton() {
        this.saveButton = createMenuItem(SAVE);
        this.fileMenu.add(this.saveButton);
    }

    public void createExitMenuButton() {
        this.addButtonSeparator();
        this.exitProgramButton = createMenuItem(EXIT);
        this.fileMenu.add(this.exitProgramButton);
    }

    public void createNextMenuButton() {
        this.nextSlideButton = createMenuItem(NEXT);
        this.viewMenu.add(this.nextSlideButton);
    }

    public void createPrevMenuButton() {
        this.previousSlideButton = createMenuItem(PREV);
        this.viewMenu.add(this.previousSlideButton);
    }

    public void createGoToMenuButton() {
        this.goToSlideButton = createMenuItem(GOTO);
        this.viewMenu.add(this.goToSlideButton);
    }

    public void createAboutMenuButton() {
        this.aboutButton = createMenuItem(ABOUT);
        this.helpMenu.add(this.aboutButton);
    }

    public MenuItem getMenuItem() {
        return this.menuItem;
    }

    public void addButtonSeparator() {
        this.fileMenu.addSeparator();
    }

}
