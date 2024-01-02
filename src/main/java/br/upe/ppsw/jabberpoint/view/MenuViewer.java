package br.upe.ppsw.jabberpoint.view;

import java.awt.Menu;
import java.awt.MenuBar;

import br.upe.ppsw.jabberpoint.controller.*;

public class MenuViewer extends MenuBar {

    public MenuViewer() {
        Menu fileMenu = new Menu("Arquivo");
        Menu viewMenu = new Menu("Visualizar");
        Menu helpMenu = new Menu("Ajuda");


        fileMenu.add(new MenuNewFileButton("Novo"));
        fileMenu.add(new MenuOpenFileButton("Abrir"));
        fileMenu.add(new MenuSaveFileButton("Salvar"));
        fileMenu.add((new MenuOpenJSONFileButton("Abrir JSON")));
        fileMenu.addSeparator();

        fileMenu.add(new MenuExitButton("Sair"));

        viewMenu.add(new MenuNextButton("Próximo"));
        viewMenu.add(new MenuPreviousButton("Anterior"));
        viewMenu.add(new MenuGoToButton("Ir para"));

        helpMenu.add(new MenuAboutButton("Sobre"));

        add(fileMenu);
        add(viewMenu);
        setHelpMenu(helpMenu);
    }
}
