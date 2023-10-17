package br.upe.ppsw.jabberpoint;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import br.upe.ppsw.jabberpoint.controller.SlideController;
import br.upe.ppsw.jabberpoint.controller.XMLAccessor;
import br.upe.ppsw.jabberpoint.model.DemoPresentation;
import br.upe.ppsw.jabberpoint.view.ApplicationFrame;
import br.upe.ppsw.jabberpoint.view.Style;

@SpringBootApplication
public class JabberPointApplication implements CommandLineRunner {

  protected static final String IOERR = "IO Error: ";
  protected static final String JABERR = "Jabberpoint Error ";

  public static void main(String[] argv) {
    SpringApplicationBuilder builder = new SpringApplicationBuilder(JabberPointApplication.class);
    builder.headless(false);
    builder.web(WebApplicationType.NONE);
    builder.run(argv);
  }

  @Override
  public void run(String... args) throws Exception {
    Style.createStyles();

    SlideController presentation = SlideController.getInstance();

    ApplicationFrame.setInstance("Jabberpoint", presentation);

    DemoPresentation demo = new DemoPresentation();
    try {
      if (args.length <= 1) {
        demo.loadFile(presentation, null);
      } else {
        XMLAccessor.getInstance().loadFile(presentation, args[1]);
      }

      SlideController.getInstance().setSlideNumber(0);

    } catch (IOException ex) {
      JOptionPane.showMessageDialog(null, IOERR + ex, JABERR, JOptionPane.ERROR_MESSAGE);
    }
  }

}
