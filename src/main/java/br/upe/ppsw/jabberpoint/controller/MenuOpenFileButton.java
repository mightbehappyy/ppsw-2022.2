package br.upe.ppsw.jabberpoint.controller;

import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.springframework.util.ResourceUtils;

import br.upe.ppsw.jabberpoint.view.ApplicationFrame;

public class MenuOpenFileButton extends BaseMenuController {
    protected static final String TESTFILE = "classpath:test.xml";

    private static XMLAccessor xmlAccessorInstance = XMLAccessor.getInstance();
    private static PresentationController presentationControllerInstance = PresentationController.getInstance();
    private static ApplicationFrame slideViewerFrameInstance = ApplicationFrame.getInstance();

    public MenuOpenFileButton(String buttonPlaceholder) {
        super(buttonPlaceholder, new MenuShortcut(KeyEvent.VK_O, true));
    }

    @Override
    protected void setMenuAction(ActionEvent event) {

        PresentationController.getInstance().clear();
        try {

            xmlAccessorInstance.loadFile(PresentationController.getInstance(),
                    ResourceUtils.getFile(TESTFILE).getAbsolutePath());
            presentationControllerInstance.setSlideNumber(0);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(slideViewerFrameInstance, "IO Exception: " + exc, "Erro ao carregar",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
