package br.upe.ppsw.jabberpoint.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.MenuShortcut;

public class MenuExitButton extends BaseMenuController {

    public MenuExitButton(String buttonPlaceholder) {
        super(buttonPlaceholder, new MenuShortcut(KeyEvent.VK_Q, true));
    }

    @Override
    protected void setMenuAction(ActionEvent event) {
        System.exit(0);
    }

}
