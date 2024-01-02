package br.upe.ppsw.jabberpoint.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyActions extends KeyAdapter {

  private final PresentationController presentationController;
  private Map<Integer, Runnable> keyMapping;

  public KeyActions(PresentationController presentationController) {
    this.presentationController = presentationController;
    initializekeyMapping();

  }

  private void initializekeyMapping() {
    keyMapping = new HashMap<>();

    keyMapping.put(KeyEvent.VK_PAGE_DOWN, presentationController::prevSlide);
    keyMapping.put(KeyEvent.VK_DOWN, presentationController::prevSlide);
    keyMapping.put(KeyEvent.VK_MINUS, presentationController::prevSlide);
    keyMapping.put(KeyEvent.VK_BACK_SPACE, presentationController::prevSlide);
    keyMapping.put(KeyEvent.VK_PAGE_UP, presentationController::nextSlide);
    keyMapping.put(KeyEvent.VK_UP, presentationController::nextSlide);
    keyMapping.put(KeyEvent.VK_ENTER, presentationController::nextSlide);
    keyMapping.put(KeyEvent.VK_PLUS, presentationController::nextSlide);
    keyMapping.put(KeyEvent.VK_Q, () -> System.exit(0));
  }

  public void excecuteAction(int keyCode) {
    if (keyMapping.containsKey(keyCode)) {
      keyMapping.get(keyCode).run();
    }
  }
}
