package br.upe.ppsw.jabberpoint.controller;

import java.io.IOException;
import java.util.ArrayList;

import br.upe.ppsw.jabberpoint.model.DemoPresentation;
import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.view.DialogBoxes;
import br.upe.ppsw.jabberpoint.view.ContentPanel;

public class PresentationController {

  private ArrayList<Slide> showList;
  private ContentPanel contentPanel;
  private int currentSlideNumber;

  private static PresentationController instance = null;

  private PresentationController() {
    clear();
    currentSlideNumber = 0;
  }

  public static PresentationController getInstance() {
    if (instance == null) {
      instance = new PresentationController();
    }
    return instance;
  }

  public void loadDemoPresentation(String... args) {
    DemoPresentation demo = new DemoPresentation();
    try {
      if (args.length <= 1) {
        demo.loadFile(this, null);
      } else {
        XMLAccessor.getInstance().loadFile(this, args[1]);
      }

      PresentationController.getInstance().setSlideNumber(0);

    } catch (IOException ex) {
      DialogBoxes.dialogErrorMessage(ex);
    }
  }

  public int getSize() {
    return showList.size();
  }

  public void setSlideNumber(int number) {
    if (number < getSize()) {
      currentSlideNumber = number;
      if (contentPanel != null) {
        contentPanel.update(getCurrentSlide());
      }
    } else {
      DialogBoxes.showOutOfBoundsError();
    }
  }

  public void prevSlide() {
    if (currentSlideNumber > 0) {
      setSlideNumber(currentSlideNumber - 1);
    }
  }

  public void nextSlide() {
    if (currentSlideNumber < (showList.size() - 1)) {
      setSlideNumber(currentSlideNumber + 1);
    }
  }

  public void setShowView(ContentPanel contentPanel) {
    this.contentPanel = contentPanel;
  }

  public Slide getSlide(int number) {
    if (number < 0 || number >= getSize()) {
      return null;
    }
    return showList.get(number);
  }

  public Slide getCurrentSlide() {
    return getSlide(currentSlideNumber);
  }

  public int getCurrentSlideNumber() {
    return currentSlideNumber;
  }

  public void clear() {
    showList = new ArrayList<>();
    setSlideNumber(-1);
  }

  public void append(Slide slide) {
    showList.add(slide);
  }

}
