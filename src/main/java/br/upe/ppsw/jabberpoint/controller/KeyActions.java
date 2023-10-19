package br.upe.ppsw.jabberpoint.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyActions extends KeyAdapter {

  private SlideController slideController;
  private Map<Integer, Runnable> keyMapping;

  public KeyActions(SlideController slideController) {
    this.slideController = slideController;
    initializekeyMapping();

  }

  private void initializekeyMapping() {
    keyMapping = new HashMap<>();

    keyMapping.put(KeyEvent.VK_PAGE_DOWN, () -> slideController.prevSlide());
    keyMapping.put(KeyEvent.VK_DOWN, () -> slideController.prevSlide());
    keyMapping.put(KeyEvent.VK_MINUS, () -> slideController.prevSlide());
    keyMapping.put(KeyEvent.VK_BACK_SPACE, () -> slideController.prevSlide());
    keyMapping.put(KeyEvent.VK_PAGE_UP, () -> slideController.nextSlide());
    keyMapping.put(KeyEvent.VK_UP, () -> slideController.nextSlide());
    keyMapping.put(KeyEvent.VK_ENTER, () -> slideController.nextSlide());
    keyMapping.put(KeyEvent.VK_PLUS, () -> slideController.nextSlide());
    keyMapping.put(KeyEvent.VK_Q, () -> System.exit(0));
  }

  public void excecuteAction(int keyCode) {
    if (keyMapping.containsKey(keyCode)) {
      keyMapping.get(keyCode).run();
    }
  }
}
