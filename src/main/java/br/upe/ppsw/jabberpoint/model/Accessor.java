package br.upe.ppsw.jabberpoint.model;

import java.io.IOException;

public abstract class Accessor {

  public static final String DEMO_NAME = "Apresentação de Demonstração";
  public static final String DEFAULT_EXTENSION = ".xml";

  public static Accessor getDemoAccessor() {
    return new DemoPresentation();
  }

  protected Accessor() {
  }

  public abstract void loadFile(Presentation presentation, String fileName) throws IOException;

  public abstract void saveFile(Presentation presentation, String fileName) throws IOException;

}
