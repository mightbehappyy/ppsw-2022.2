package br.upe.ppsw.jabberpoint.controller;

import java.io.IOException;

import br.upe.ppsw.jabberpoint.service.acessors.XMLAccessor;
import br.upe.ppsw.jabberpoint.model.DemoPresentation;
import br.upe.ppsw.jabberpoint.view.DialogBoxes;

public class DemoPresentationLoader {
    private final PresentationController presentationController = PresentationController.getInstance();

    public void loadDemoPresentation(String... args) {
        DemoPresentation demo = new DemoPresentation();
        try {
            if (args.length <= 1) {
                demo.loadFile(presentationController, null);
            } else {
                XMLAccessor.getInstance().loadFile(presentationController, args[1]);
            }

            PresentationController.getInstance().setSlideNumber(0);

        } catch (IOException ex) {
            DialogBoxes.dialogErrorMessage(ex);
        }
    }
}
