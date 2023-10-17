package br.upe.ppsw.jabberpoint.controller;

import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MenuPreviousButton extends BaseMenuController {

    public MenuPreviousButton(String buttonPlaceholder) {
        super(buttonPlaceholder, new MenuShortcut(KeyEvent.VK_LEFT, false));

    }

    @Override
    protected void menuAction(ActionEvent event) {
        SlideController.getInstance().prevSlide();
    }

}
