package br.upe.ppsw.jabberpoint.controller;

import java.util.ArrayList;

import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.view.DialogBoxes;
import br.upe.ppsw.jabberpoint.view.SlideViewerComponent;
import java.awt.Frame;

public class SlideController {

  private String title;
  private ArrayList<Slide> showList = null;
  private SlideViewerComponent slideViewComponent = null;
  private int currentSlideNumber = 0;
  private Frame frame;

  private static SlideController instance = null;

  private SlideController() {
    slideViewComponent = null;
    clear();
  }

  public static SlideController getInstance() {
    if (instance == null) {
      instance = new SlideController();
    }
    return instance;
  }

  public SlideController(SlideViewerComponent slideViewerComponent) {
    this.slideViewComponent = slideViewerComponent;
    clear();
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

  public void setShowView(SlideViewerComponent slideViewerComponent) {
    this.slideViewComponent = slideViewerComponent;
  }

  public int getSlideNumber() {
    return currentSlideNumber;
  }

  public void setSlideNumber(int number) {
    if (number < getSize()) {
      currentSlideNumber = number;
      if (slideViewComponent != null) {
        slideViewComponent.update(this, getCurrentSlide());
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
    showList = new ArrayList<Slide>();
    setSlideNumber(-1);
  }

  public void append(Slide slide) {
    showList.add(slide);
  }

  public Slide getSlide(int number) {
    if (number < 0 || number >= getSize()) {
      return null;
    }
    return (Slide) showList.get(number);
  }

  public Slide getCurrentSlide() {
    return getSlide(currentSlideNumber);
  }

  public void exit() {
    System.exit(0);
  }
}
