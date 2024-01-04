package br.upe.ppsw.jabberpoint.controller;

import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.swing.*;

import br.upe.ppsw.jabberpoint.service.acessors.HTMLAccessor;
import br.upe.ppsw.jabberpoint.service.acessors.JSONAccessor;
import br.upe.ppsw.jabberpoint.service.acessors.YAMLAccessor;
import br.upe.ppsw.jabberpoint.service.interfaces.ILoadable;
import br.upe.ppsw.jabberpoint.view.ContentPanel;
import org.springframework.util.ResourceUtils;

import br.upe.ppsw.jabberpoint.service.acessors.XMLAccessor;
import br.upe.ppsw.jabberpoint.view.ApplicationFrame;

public class MenuOpenFileButton extends BaseMenuController {
    private static final PresentationController presentationControllerInstance = PresentationController.getInstance();
    private static final ApplicationFrame slideViewerFrameInstance = ApplicationFrame.getInstance();

    private final transient Map<String, ILoadable> supportedExtensions = Map.of(
            ".yaml", new YAMLAccessor(),
            ".html", new HTMLAccessor(),
            ".xml", new XMLAccessor(),
            ".json", new JSONAccessor()
    );

    private final JFileChooser fileChooser = new JFileChooser();

    public MenuOpenFileButton(String buttonPlaceholder) {
        super(buttonPlaceholder, new MenuShortcut(KeyEvent.VK_O, true));
    }

    @Override
    protected void setMenuAction(ActionEvent event) {
        try {
            int response = fileChooser.showOpenDialog(slideViewerFrameInstance);
            if (response == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getPath();
                String fileName = fileChooser.getSelectedFile().getAbsoluteFile().getName();
                String fileExtension = fileName.substring(fileName.lastIndexOf("."));

                PresentationController.getInstance().clear();
                supportedExtensions.get(fileExtension).loadFile(PresentationController.getInstance(), filePath);
                presentationControllerInstance.setSlideNumber(0);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

