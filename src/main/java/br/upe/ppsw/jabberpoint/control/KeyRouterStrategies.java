package br.upe.ppsw.jabberpoint.control;

import br.upe.ppsw.jabberpoint.model.Presentation;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyRouterStrategies extends KeyAdapter {

  private Presentation presentation;
  private Map<Integer, Runnable> keyActions;

  public KeyRouterStrategies(Presentation presentation) {
    this.presentation = presentation;
    initializeKeyActions();

  }

  private void initializeKeyActions() {
    keyActions = new HashMap<>();

    keyActions.put(KeyEvent.VK_PAGE_DOWN, () -> presentation.prevSlide());
    keyActions.put(KeyEvent.VK_DOWN, () -> presentation.prevSlide());
    keyActions.put(KeyEvent.VK_MINUS, () -> presentation.prevSlide());
    keyActions.put(KeyEvent.VK_BACK_SPACE, () -> presentation.prevSlide());
    keyActions.put(KeyEvent.VK_PAGE_UP, () -> presentation.nextSlide());
    keyActions.put(KeyEvent.VK_UP, () -> presentation.nextSlide());
    keyActions.put(KeyEvent.VK_ENTER, () -> presentation.nextSlide());
    keyActions.put(KeyEvent.VK_PLUS, () -> presentation.nextSlide());
    keyActions.put(KeyEvent.VK_Q, () -> System.exit(0));
  }

  public void forward(int keyCode) {
    if (keyActions.containsKey(keyCode)) {
      keyActions.get(keyCode).run();
    }
  }
}
