package br.upe.ppsw.jabberpoint.controller;

import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import br.upe.ppsw.jabberpoint.model.Presentation;
import br.upe.ppsw.jabberpoint.view.DialogBoxes;

public class MenuGoToButton extends BaseMenuController {

    public MenuGoToButton(String buttonPlaceholder) {
        super(buttonPlaceholder, new MenuShortcut(KeyEvent.VK_F, false));
    }

    @Override
    protected void setMenuAction(ActionEvent event) {
        String pageNumberString = DialogBoxes.showGoToPageDialogBox();
        int pageNumber = Integer.parseInt(pageNumberString);
        presentationController.setSlideNumber(pageNumber - 1);
    }
}
