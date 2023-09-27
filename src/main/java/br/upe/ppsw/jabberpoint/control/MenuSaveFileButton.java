package br.upe.ppsw.jabberpoint.control;

import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import br.upe.ppsw.jabberpoint.view.SlideViewerFrame;

public class MenuSaveFileButton extends BaseMenuController {
    protected static final String TESTFILE = "classpath:test.xml";

    private static XMLAccessor xmlAccessorInstance = XMLAccessor.getInstance();
    private static SlideController slideControllerInstance = SlideController.getInstance();
    private static SlideViewerFrame slideViewerFrameInstance = SlideViewerFrame.getInstance();
    private static final String SAVEFILE = "classpath:dump.xml";

    public MenuSaveFileButton(String buttonPlaceholder) {
        super(buttonPlaceholder, new MenuShortcut(KeyEvent.VK_S, false));
    }

    @Override
    protected void menuAction(ActionEvent event) {
        try {
            xmlAccessorInstance.saveFile(slideControllerInstance, SAVEFILE);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(slideViewerFrameInstance, "IO Exception: " + exc, "Erro ao salvar",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}