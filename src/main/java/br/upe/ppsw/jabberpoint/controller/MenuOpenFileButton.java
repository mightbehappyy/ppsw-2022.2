package br.upe.ppsw.jabberpoint.controller;

import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import br.upe.ppsw.jabberpoint.service.AccessorStrategy;

import br.upe.ppsw.jabberpoint.view.ApplicationFrame;

public class MenuOpenFileButton extends BaseMenuController {
    private static final ApplicationFrame slideViewerFrameInstance = ApplicationFrame.getInstance();


    public MenuOpenFileButton(String buttonPlaceholder) {
        super(buttonPlaceholder, new MenuShortcut(KeyEvent.VK_O, true));
    }

    @Override
    protected void setMenuAction(ActionEvent event) {
        AccessorStrategy accessorStrategy = new AccessorStrategy();
        accessorStrategy.loadFile(slideViewerFrameInstance, presentationController);
    }
}