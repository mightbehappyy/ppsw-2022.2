package br.upe.ppsw.jabberpoint.service;

import br.upe.ppsw.jabberpoint.controller.PresentationController;
import br.upe.ppsw.jabberpoint.service.accessors.*;
import br.upe.ppsw.jabberpoint.service.interfaces.ILoadable;
import br.upe.ppsw.jabberpoint.view.ApplicationFrame;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class AccessorStrategy {

    private final JFileChooser fileChooser = new JFileChooser();
    private final Map<String, ILoadable> supportedExtensions = Map.of(
            ".yaml", new YAMLAccessor(),
            ".html", new HTMLAccessor(),
            ".xml", new XMLAccessor(),
            ".json", new JSONAccessor(),
            "default", new DefaultAccessor()
    );

    public void loadFile(ApplicationFrame applicationFrame, PresentationController presentationController) {
        try {
            int response = fileChooser.showOpenDialog(applicationFrame);
            if (response == JFileChooser.APPROVE_OPTION) {
                Map<String, String> fileInfo = getFileInfo(fileChooser);

                ILoadable accessor = supportedExtensions.getOrDefault(
                        fileInfo.get("extension"),
                        supportedExtensions.get("default")
                );
                presentationController.clear();
                accessor.loadFile(presentationController, fileInfo.get("path"));
                presentationController.setSlideNumber(0);
            }
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.info(e.getMessage());
        }
    }

    private Map<String, String> getFileInfo(JFileChooser fileChooser) {
        Map<String, String> fileInfo = new HashMap<>();
        File file = fileChooser.getSelectedFile();
        String fileName = file.getName();

        fileInfo.put("path", file.getPath());
        fileInfo.put("extension", fileName.substring(fileName.lastIndexOf(".")));

        return fileInfo;
    }
}
