package br.upe.ppsw.jabberpoint.controller;

import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import br.upe.ppsw.jabberpoint.model.Presentation;
import br.upe.ppsw.jabberpoint.service.accessors.XMLAccessor;
import br.upe.ppsw.jabberpoint.view.ApplicationFrame;

public class MenuSaveFileButton extends BaseMenuController {

    private static final Presentation presentation = Presentation.getInstance();
    private static final ApplicationFrame slideViewerFrameInstance = ApplicationFrame.getInstance();
    private static final String SAVEFILE = "classpath:dump.xml";

    public MenuSaveFileButton(String buttonPlaceholder) {
        super(buttonPlaceholder, new MenuShortcut(KeyEvent.VK_S, false));
    }

    @Override
    protected void setMenuAction(ActionEvent event) {
        try {
            XMLAccessor xmlAccessor = new XMLAccessor();
            xmlAccessor.saveFile(presentation, SAVEFILE);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(slideViewerFrameInstance, "IO Exception: " + exc, "Erro ao salvar",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}