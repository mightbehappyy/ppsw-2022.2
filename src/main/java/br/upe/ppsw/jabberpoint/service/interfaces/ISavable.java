package br.upe.ppsw.jabberpoint.service.interfaces;

import java.io.IOException;

import br.upe.ppsw.jabberpoint.model.Presentation;

public interface ISavable {
    void saveFile(Presentation presentation, String fileName) throws IOException;
}
