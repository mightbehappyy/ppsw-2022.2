package br.upe.ppsw.jabberpoint.service.accessors;

import br.upe.ppsw.jabberpoint.controller.PresentationController;
import br.upe.ppsw.jabberpoint.model.Presentation;
import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.model.items.SlideItem;
import br.upe.ppsw.jabberpoint.model.items.SlideItemStrategy;
import br.upe.ppsw.jabberpoint.service.interfaces.ILoadable;
import br.upe.ppsw.jabberpoint.service.interfaces.ISavable;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class YAMLAccessor implements ILoadable, ISavable {

    @Override
    public void saveFile(Presentation presentation, String fileName) throws IOException {

    }

    @Override
    public void loadFile(PresentationController presentationController, String fileName) throws IOException {

        for (Object page : getPresentationItems(parseFile(fileName))) {
            Slide slide = new Slide();
            Map<String, Object> slideMap = (Map<String, Object>) page;
            setSlideTitle(slideMap, slide);

            for (Object slideItem : (List<Object>) slideMap.get("items")) {
                slide.append(setSlideItem((LinkedHashMap<String, Object>) slideItem));
            }
            presentationController.addSlide(slide);
        }
    }

    private Map<String, Object> parseFile(String fileName) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        FileInputStream in = new FileInputStream(fileName);

        return yaml.load(in);
    }

    private List<Object> getPresentationItems(Map<String, Object> parseFile) {
        Map<String, Object> presentationMap = (Map<String, Object>) parseFile.get("presentation");
        return (List<Object>) presentationMap.get("slides");
    }

    private SlideItem setSlideItem(LinkedHashMap<String, Object> slideItem) {
        String content = slideItem.get("content").toString();
        int level = Integer.parseInt(slideItem.get("level").toString());
        String kind = slideItem.get("kind").toString();

        SlideItemStrategy slideItemStrategy = new SlideItemStrategy();
        return slideItemStrategy.getSlideItemKind(kind, content, level);
    }


    private void setSlideTitle(Map<String, Object> slideMap, Slide slide) {
        String title = slideMap.get("title").toString();
        slide.setTitle(title);
    }

}