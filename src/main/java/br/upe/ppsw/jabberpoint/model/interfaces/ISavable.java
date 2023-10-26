package br.upe.ppsw.jabberpoint.model.interfaces;

import java.io.IOException;

import br.upe.ppsw.jabberpoint.controller.PresentationController;

public interface ISavable {
    void saveFile(PresentationController presentation, String fileName) throws IOException;
}
