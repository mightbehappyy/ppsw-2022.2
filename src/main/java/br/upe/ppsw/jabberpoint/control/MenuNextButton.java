package br.upe.ppsw.jabberpoint.control;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.MenuShortcut;

public class MenuNextButton extends BaseMenuController {

    public MenuNextButton(String buttonPlaceholder) {
        super(buttonPlaceholder, new MenuShortcut(KeyEvent.VK_RIGHT, false));
    }

    @Override
    protected void menuAction(ActionEvent event) {
        this.addActionListener(actionEvent -> SlideController.getInstance().nextSlide());
    }

}
