package br.upe.ppsw.jabberpoint.control;

import java.awt.event.KeyEvent;

import br.upe.ppsw.jabberpoint.model.Presentation;

import java.awt.event.KeyAdapter;

public class KeyController extends KeyAdapter {
    private Presentation presentation;

    public KeyController(Presentation presentation) {
        super();
        this.presentation = presentation;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        KeyRouterStrategies router = new KeyRouterStrategies(presentation);
        router.forward(keyEvent.getKeyCode());
    }

}