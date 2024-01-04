package br.upe.ppsw.jabberpoint.service.interfaces;

import java.io.IOException;

import br.upe.ppsw.jabberpoint.controller.PresentationController;


public interface ILoadable {
    void loadFile(PresentationController presentation, String fileName) throws IOException;
}
