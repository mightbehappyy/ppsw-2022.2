package br.upe.ppsw.jabberpoint.controller;

import br.upe.ppsw.jabberpoint.model.Presentation;

import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MenuPreviousButton extends BaseMenuController {


    public MenuPreviousButton(String buttonPlaceholder) {
        super(buttonPlaceholder, new MenuShortcut(KeyEvent.VK_LEFT, false));

    }

    @Override
    protected void setMenuAction(ActionEvent event) {
        presentationController.prevSlide();
    }

}
