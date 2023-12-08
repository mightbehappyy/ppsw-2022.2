package br.upe.ppsw.jabberpoint.controller.acessors;

import java.io.IOException;

import br.upe.ppsw.jabberpoint.controller.PresentationController;
import br.upe.ppsw.jabberpoint.model.interfaces.ILoadable;
import br.upe.ppsw.jabberpoint.model.interfaces.ISavable;

public class JSONAcessor implements ILoadable, ISavable {

    @Override
    public void saveFile(PresentationController presentation, String fileName) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveFile'");
    }

    @Override
    public void loadFile(PresentationController presentation, String fileName) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadFile'");
    }

}
