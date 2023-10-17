package br.upe.ppsw.jabberpoint.model.interfaces;

import java.io.IOException;

import br.upe.ppsw.jabberpoint.controller.SlideController;

public interface ISaveFile {
    void saveFile(SlideController presentation, String fileName) throws IOException;
}
