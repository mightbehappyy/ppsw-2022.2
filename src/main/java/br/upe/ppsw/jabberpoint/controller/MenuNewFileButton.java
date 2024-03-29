package br.upe.ppsw.jabberpoint.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import br.upe.ppsw.jabberpoint.model.Presentation;
import br.upe.ppsw.jabberpoint.view.ApplicationFrame;

import java.awt.MenuShortcut;

public class MenuNewFileButton extends BaseMenuController {

    public MenuNewFileButton(String buttonPlaceholder) {
        super(buttonPlaceholder, new MenuShortcut(KeyEvent.VK_N, true));
    }

    @Override
    protected void setMenuAction(ActionEvent event) {
        clearPresentation();
        reloadFrame();
    }

    private void clearPresentation() {
        presentationController.clear();
    }

    private void reloadFrame() {
        ApplicationFrame.getInstance().repaint();
    }

}
