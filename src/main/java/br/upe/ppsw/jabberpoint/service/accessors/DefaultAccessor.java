package br.upe.ppsw.jabberpoint.service.accessors;

import br.upe.ppsw.jabberpoint.controller.PresentationController;
import br.upe.ppsw.jabberpoint.model.Presentation;
import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.model.SlideNullObject;
import br.upe.ppsw.jabberpoint.service.interfaces.ILoadable;
import br.upe.ppsw.jabberpoint.service.interfaces.ISavable;
import br.upe.ppsw.jabberpoint.view.DialogBoxes;

import java.io.File;
import java.io.IOException;

public class DefaultAccessor implements ILoadable, ISavable {
    @Override
    public void loadFile(PresentationController presentation, String fileName) throws IOException {
        Slide slide = new SlideNullObject();
        presentation.addSlide(slide);
        defaultCase(fileName);
    }

    @Override
    public void saveFile(Presentation presentation, String fileName) throws IOException {
        defaultCase(fileName);
    }

    public void defaultCase(String fileName) {
        File file = new File(fileName);
        String name = file.getName();
        String extension = name.substring(name.lastIndexOf("."));
        DialogBoxes.unsupportedExtensionError(extension);
    }
}
