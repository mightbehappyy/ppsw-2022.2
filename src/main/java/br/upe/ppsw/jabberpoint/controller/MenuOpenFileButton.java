package br.upe.ppsw.jabberpoint.controller;

import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.springframework.util.ResourceUtils;

import br.upe.ppsw.jabberpoint.view.SlideViewerFrame;

public class MenuOpenFileButton extends BaseMenuController {
    protected static final String TESTFILE = "classpath:test.xml";

    private static XMLAccessor xmlAccessorInstance = XMLAccessor.getInstance();
    private static SlideController slideControllerInstance = SlideController.getInstance();
    private static SlideViewerFrame slideViewerFrameInstance = SlideViewerFrame.getInstance();

    public MenuOpenFileButton(String buttonPlaceholder) {
        super(buttonPlaceholder, new MenuShortcut(KeyEvent.VK_O, true));
    }

    @Override
    protected void menuAction(ActionEvent event) {
        SlideController.getInstance().clear();
        try {
            xmlAccessorInstance.loadFile(SlideController.getInstance(),
                    ResourceUtils.getFile(TESTFILE).getAbsolutePath());
            slideControllerInstance.setSlideNumber(0);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(slideViewerFrameInstance, "IO Exception: " + exc, "Erro ao carregar",
                    JOptionPane.ERROR_MESSAGE);
        }
        slideViewerFrameInstance.repaint();
    }

}
