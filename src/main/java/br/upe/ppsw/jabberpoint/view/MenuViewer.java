package br.upe.ppsw.jabberpoint.view;

import java.awt.Menu;
import java.awt.MenuBar;

import br.upe.ppsw.jabberpoint.controller.MenuAboutButton;
import br.upe.ppsw.jabberpoint.controller.MenuExitButton;
import br.upe.ppsw.jabberpoint.controller.MenuGoToButton;
import br.upe.ppsw.jabberpoint.controller.MenuNewFileButton;
import br.upe.ppsw.jabberpoint.controller.MenuNextButton;
import br.upe.ppsw.jabberpoint.controller.MenuOpenFileButton;
import br.upe.ppsw.jabberpoint.controller.MenuPreviousButton;
import br.upe.ppsw.jabberpoint.controller.MenuSaveFileButton;

public class MenuViewer extends MenuBar {

    private Menu fileMenu;
    private Menu viewMenu;
    private Menu helpMenu;

    public MenuViewer() {
        fileMenu = new Menu("Arquivo");
        viewMenu = new Menu("Visualizar");
        helpMenu = new Menu("Ajuda");

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
