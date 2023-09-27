package br.upe.ppsw.jabberpoint.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class KeyController extends KeyAdapter {

    public KeyController() {
        super();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        KeyActions keyMap = new KeyActions(SlideController.getInstance());
        keyMap.excecuteAction(keyEvent.getKeyCode());
    }

}