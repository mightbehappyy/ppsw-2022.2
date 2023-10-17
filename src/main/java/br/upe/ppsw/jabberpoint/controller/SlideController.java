package br.upe.ppsw.jabberpoint.controller;

import java.util.ArrayList;

import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.view.DialogBoxes;
import br.upe.ppsw.jabberpoint.view.ContentPanel;

public class SlideController {

  private String title;
  private ArrayList<Slide> showList = null;
  private ContentPanel contentPanel = null;
  private int currentSlideNumber = 0;

  private static SlideController instance = null;

  public SlideController(ContentPanel slideViewerComponent) {
    this.contentPanel = slideViewerComponent;
    clear();
  }

  private SlideController() {
    contentPanel = null;
    clear();
  }

  public static SlideController getInstance() {
    if (instance == null) {
      instance = new SlideController();
    }
    return instance;
  }

  public int getSize() {
    return showList.size();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String newTitle) {
    title = newTitle;
  }

  public void setShowView(ContentPanel contentPanel) {
    this.contentPanel = contentPanel;
  }

  public int getSlideNumber() {
    return currentSlideNumber;
  }

  public void setSlideNumber(int number) {
    if (number < getSize()) {
      currentSlideNumber = number;
      if (contentPanel != null) {
        contentPanel.update(this, getCurrentSlide());
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

  public void clear() {
    showList = new ArrayList<>();
    setSlideNumber(-1);
  }

  public void append(Slide slide) {
    showList.add(slide);
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

  public void exit() {
    System.exit(0);
  }
}
