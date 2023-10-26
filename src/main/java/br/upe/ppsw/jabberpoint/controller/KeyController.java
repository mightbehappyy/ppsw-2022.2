package br.upe.ppsw.jabberpoint.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class KeyController extends KeyAdapter {

    public KeyController() {
        super();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        KeyActions keyMap = new KeyActions(PresentationController.getInstance());
        keyMap.excecuteAction(keyEvent.getKeyCode());
    }

}