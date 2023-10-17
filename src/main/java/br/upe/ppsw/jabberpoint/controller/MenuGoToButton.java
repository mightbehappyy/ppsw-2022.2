package br.upe.ppsw.jabberpoint.controller;

import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import br.upe.ppsw.jabberpoint.view.DialogBoxes;

public class MenuGoToButton extends BaseMenuController {

    public MenuGoToButton(String buttonPlaceholder) {
        super(buttonPlaceholder, new MenuShortcut(KeyEvent.VK_F, false));
    }

    @Override
    protected void menuAction(ActionEvent event) {
        String pageNumberString = DialogBoxes.showGoToPageDialogBox();
        int pageNumber = Integer.parseInt(pageNumberString);
        SlideController.getInstance().setSlideNumber(pageNumber - 1);
    }

}
