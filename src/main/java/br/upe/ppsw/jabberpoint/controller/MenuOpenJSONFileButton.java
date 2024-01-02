package br.upe.ppsw.jabberpoint.controller;

import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import br.upe.ppsw.jabberpoint.controller.acessors.JSONAccessor;
import org.springframework.util.ResourceUtils;

import br.upe.ppsw.jabberpoint.view.ApplicationFrame;

public class MenuOpenJSONFileButton extends BaseMenuController {
    protected static final String TESTFILE = "classpath:test.json";
    private static final PresentationController presentationControllerInstance = PresentationController.getInstance();
    private static final ApplicationFrame slideViewerFrameInstance = ApplicationFrame.getInstance();

    public MenuOpenJSONFileButton(String buttonPlaceholder) {
        super(buttonPlaceholder, new MenuShortcut(KeyEvent.VK_J, true));
    }

    @Override
    protected void setMenuAction(ActionEvent event) {

        PresentationController.getInstance().clear();
        try {
            JSONAccessor jsonAccessor = new JSONAccessor();
            jsonAccessor.loadFile(PresentationController.getInstance(),
                    ResourceUtils.getFile(TESTFILE).getAbsolutePath());
            presentationControllerInstance.setSlideNumber(0);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(slideViewerFrameInstance, "IO Exception: " + exc, "Erro ao carregar",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
