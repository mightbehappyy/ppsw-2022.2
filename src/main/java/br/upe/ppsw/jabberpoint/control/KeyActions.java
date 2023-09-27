package br.upe.ppsw.jabberpoint.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyActions extends KeyAdapter {

  private SlideController presentation;
  private Map<Integer, Runnable> keyMapping;

  public KeyActions(SlideController presentation) {
    this.presentation = presentation;
    initializekeyMapping();

  }

  private void initializekeyMapping() {
    keyMapping = new HashMap<>();

    keyMapping.put(KeyEvent.VK_PAGE_DOWN, () -> presentation.prevSlide());
    keyMapping.put(KeyEvent.VK_DOWN, () -> presentation.prevSlide());
    keyMapping.put(KeyEvent.VK_MINUS, () -> presentation.prevSlide());
    keyMapping.put(KeyEvent.VK_BACK_SPACE, () -> presentation.prevSlide());
    keyMapping.put(KeyEvent.VK_PAGE_UP, () -> presentation.nextSlide());
    keyMapping.put(KeyEvent.VK_UP, () -> presentation.nextSlide());
    keyMapping.put(KeyEvent.VK_ENTER, () -> presentation.nextSlide());
    keyMapping.put(KeyEvent.VK_PLUS, () -> presentation.nextSlide());
    keyMapping.put(KeyEvent.VK_Q, () -> System.exit(0));
  }

  public void excecuteAction(int keyCode) {
    if (keyMapping.containsKey(keyCode)) {
      keyMapping.get(keyCode).run();
    }
  }
}
