package br.upe.ppsw.jabberpoint.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import br.upe.ppsw.jabberpoint.view.SlideViewerFrame;

import java.awt.MenuShortcut;

public class MenuNewFileButton extends BaseMenuController {

    public MenuNewFileButton(String buttonPlaceholder) {
        super(buttonPlaceholder, new MenuShortcut(KeyEvent.VK_N, true));
    }

    @Override
    protected void menuAction(ActionEvent event) {
        clearPresentation();
        reloadFrame();
    }

    private void clearPresentation() {
        SlideController.getInstance().clear();
    }

    private void reloadFrame() {
        SlideViewerFrame.getInstance().repaint();
    }

}
