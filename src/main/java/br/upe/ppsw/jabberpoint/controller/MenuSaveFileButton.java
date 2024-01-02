package br.upe.ppsw.jabberpoint.controller;

import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import br.upe.ppsw.jabberpoint.controller.acessors.XMLAccessor;
import br.upe.ppsw.jabberpoint.view.ApplicationFrame;

public class MenuSaveFileButton extends BaseMenuController {
    protected static final String TESTFILE = "classpath:test.xml";

    private static final XMLAccessor xmlAccessorInstance = XMLAccessor.getInstance();
    private static final PresentationController presentationControllerInstance = PresentationController.getInstance();
    private static final ApplicationFrame slideViewerFrameInstance = ApplicationFrame.getInstance();
    private static final String SAVEFILE = "classpath:dump.xml";

    public MenuSaveFileButton(String buttonPlaceholder) {
        super(buttonPlaceholder, new MenuShortcut(KeyEvent.VK_S, false));
    }

    @Override
    protected void setMenuAction(ActionEvent event) {
        try {
            xmlAccessorInstance.saveFile(presentationControllerInstance, SAVEFILE);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(slideViewerFrameInstance, "IO Exception: " + exc, "Erro ao salvar",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}