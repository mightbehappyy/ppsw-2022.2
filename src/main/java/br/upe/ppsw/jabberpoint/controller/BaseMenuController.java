package br.upe.ppsw.jabberpoint.controller;

import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;

abstract class BaseMenuController extends MenuItem {

    protected abstract void menuAction(ActionEvent event);

    protected BaseMenuController(String buttonPlaceholder, MenuShortcut shortcut) {
        super(buttonPlaceholder, shortcut);
        this.addActionListener(this::menuAction);
    }

    protected BaseMenuController(String buttonPlaceholder) {
        super(buttonPlaceholder);
        this.addActionListener(this::menuAction);
    }
}