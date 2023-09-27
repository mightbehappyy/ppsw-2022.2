package br.upe.ppsw.jabberpoint.view;

import java.awt.Menu;
import java.awt.MenuBar;

import javax.swing.JOptionPane;

import br.upe.ppsw.jabberpoint.control.MenuAboutButton;
import br.upe.ppsw.jabberpoint.control.MenuExitButton;
import br.upe.ppsw.jabberpoint.control.MenuGoToButton;
import br.upe.ppsw.jabberpoint.control.MenuNewFileButton;
import br.upe.ppsw.jabberpoint.control.MenuNextButton;
import br.upe.ppsw.jabberpoint.control.MenuOpenFileButton;
import br.upe.ppsw.jabberpoint.control.MenuPreviousButton;
import br.upe.ppsw.jabberpoint.control.MenuSaveFileButton;

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

    private Menu fileMenu;
    private Menu viewMenu;
    private Menu helpMenu;

    public MenuViewer() {
        this.fileMenu = new Menu(FILE);
        this.viewMenu = new Menu(VIEW);
        this.helpMenu = new Menu(HELP);

        fileMenu.add(new MenuNewFileButton("Novo"));
        fileMenu.add(new MenuOpenFileButton("Abrir"));
        fileMenu.add(new MenuSaveFileButton("Salvar"));
        addButtonSeparator();
        fileMenu.add(new MenuExitButton("Sair"));

        viewMenu.add(new MenuNextButton("Próximo"));
        viewMenu.add(new MenuPreviousButton("Anterior"));
        viewMenu.add(new MenuGoToButton("Ir para"));

        helpMenu.add(new MenuAboutButton("Sobre"));

        add(fileMenu);
        add(viewMenu);
        setHelpMenu(helpMenu);
    }

    private void addButtonSeparator() {
        this.fileMenu.addSeparator();
    }

}
