package br.upe.ppsw.jabberpoint.model.interfaces;

import java.io.IOException;

import br.upe.ppsw.jabberpoint.controller.SlideController;

public interface ILoadFile {
    void loadFile(SlideController presentation, String fileName) throws IOException;
}
