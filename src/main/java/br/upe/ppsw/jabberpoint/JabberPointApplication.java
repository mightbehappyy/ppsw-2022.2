package br.upe.ppsw.jabberpoint;

import br.upe.ppsw.jabberpoint.controller.DemoPresentationLoader;
import br.upe.ppsw.jabberpoint.view.ApplicationFrame;
import br.upe.ppsw.jabberpoint.view.Style;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;

@SpringBootApplication
public class JabberPointApplication implements CommandLineRunner {

  public static void main(String[] argv) {
    SpringApplicationBuilder builder = new SpringApplicationBuilder(JabberPointApplication.class);
    builder.headless(false);
    builder.web(WebApplicationType.NONE);
    builder.run(argv);
  }

  @Override
  public void run(String... args) throws Exception {
    Style.createStyles();

    ApplicationFrame.setInstance("Jabberpoint");

    DemoPresentationLoader presentationLoader = new DemoPresentationLoader();
    presentationLoader.loadDemoPresentation(args);

  }

}
