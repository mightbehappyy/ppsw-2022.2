package br.upe.ppsw.jabberpoint.controller;

import br.upe.ppsw.jabberpoint.model.Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.MenuShortcut;

public class MenuNextButton extends BaseMenuController {

    public MenuNextButton(String buttonPlaceholder) {
        super(buttonPlaceholder, new MenuShortcut(KeyEvent.VK_RIGHT, false));
    }

    @Override
    protected void setMenuAction(ActionEvent event) {
        presentationController.nextSlide();
    }

}
