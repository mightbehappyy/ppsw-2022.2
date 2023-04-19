package br.upe.ppsw.jabberpoint.control;
import br.upe.ppsw.jabberpoint.model.Presentation;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter {

  private Presentation presentation;

  public KeyController(Presentation p) {
    presentation = p;
  }

  public void keyPressed(KeyEvent keyEvent) {
    switch (keyEvent.getKeyCode()) {
      case KeyEvent.VK_PAGE_DOWN:
      case KeyEvent.VK_DOWN:
      case KeyEvent.VK_ENTER:
      case KeyEvent.VK_PLUS:
        presentation.nextSlide();
        break;
      case KeyEvent.VK_PAGE_UP:
      case KeyEvent.VK_UP:
      case KeyEvent.VK_MINUS:
        presentation.prevSlide();
        break;
      case 'q':
      case 'Q':
        System.exit(0);
        break; // fix?
      default:
        break;
    }
  }

}
