package br.upe.ppsw.jabberpoint.service.acessors;

import br.upe.ppsw.jabberpoint.controller.PresentationController;
import br.upe.ppsw.jabberpoint.model.ImageItem;
import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.model.SlideItem;
import br.upe.ppsw.jabberpoint.model.TextItem;
import br.upe.ppsw.jabberpoint.service.interfaces.ILoadable;
import br.upe.ppsw.jabberpoint.service.interfaces.ISavable;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class YAMLAccessor implements ILoadable, ISavable {

    @Override
    public void saveFile(PresentationController presentation, String fileName) throws IOException {

    }
    @Override
    public void loadFile(PresentationController presentation, String fileName) throws IOException {

        for (Object page : getPresentationItems(parseFile(fileName))) {
            Slide slide = new Slide();
            Map<String, Object> slideMap = (Map<String, Object>) page;
            setSlideTitle(slideMap, slide);

            for (Object slideItem : (List<Object>) slideMap.get("items")) {
                slide.append(setSlideItem((LinkedHashMap<String, Object>) slideItem));
            }
            presentation.append(slide);
        }
    }

    private Map<String, Object> parseFile(String fileName) {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);

        return yaml.load(inputStream);
    }

    private List<Object> getPresentationItems(Map<String, Object> parseFile) {
        Map<String, Object> presentationMap = (Map<String, Object>) parseFile.get("presentation");
        return (List<Object>) presentationMap.get("slides");
    }

    private SlideItem setSlideItem(LinkedHashMap<String, Object> slideItem) {
        String content = slideItem.get("content").toString();
        int level = Integer.parseInt(slideItem.get("level").toString());
        String kind =  slideItem.get("kind").toString();

       if ("text".equals(kind)) {
           return new TextItem(level, content);
        } else if ("image".equals(kind)) {
           return new ImageItem(level, content);
        }
       return new TextItem();
    }

    private void setSlideTitle(Map<String, Object> slideMap, Slide slide) {
        String title = slideMap.get("title").toString();
        slide.setTitle(title);
    }

}
