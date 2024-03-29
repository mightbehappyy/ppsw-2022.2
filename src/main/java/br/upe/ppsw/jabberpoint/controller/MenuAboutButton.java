package br.upe.ppsw.jabberpoint.controller;

import java.awt.event.ActionEvent;

import br.upe.ppsw.jabberpoint.view.DialogBoxes;

public class MenuAboutButton extends BaseMenuController {

    public MenuAboutButton(String buttonPlaceholder) {
        super(buttonPlaceholder);
    }

    @Override
    protected void setMenuAction(ActionEvent event) {
        DialogBoxes.showAboutBox();
    }

}
