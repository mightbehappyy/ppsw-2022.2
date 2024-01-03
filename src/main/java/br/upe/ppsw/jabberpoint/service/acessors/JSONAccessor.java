package br.upe.ppsw.jabberpoint.service.acessors;


import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import br.upe.ppsw.jabberpoint.model.ImageItem;
import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.model.TextItem;
import org.json.simple.*;
import org.json.simple.parser.*;


import br.upe.ppsw.jabberpoint.controller.PresentationController;
import br.upe.ppsw.jabberpoint.service.interfaces.ILoadable;
import br.upe.ppsw.jabberpoint.service.interfaces.ISavable;

public class JSONAccessor implements ILoadable, ISavable {


    @Override
    public void saveFile(PresentationController presentation, String fileName) {
        throw new UnsupportedOperationException("Unimplemented method 'loadFile'");
    }

    @Override
    public void loadFile(PresentationController presentation, String fileName) throws IOException {
        try {
            for (Object o : getPresentationItems(parseFile(fileName))) {
                JSONObject jsonSlide = (JSONObject) o;
                Slide slide = new Slide();
                setSlideTitle(jsonSlide, slide);
                for (Object itemObj : (JSONArray) jsonSlide.get("items")) {
                    setSlideItem((JSONObject) itemObj, slide);
                }

                presentation.append(slide);
            }
        } catch (IOException | ParseException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.info(e.toString());
        }

    }

    private JSONObject parseFile(String fileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader fileReader = new FileReader(fileName);
        Object jsonFile = parser.parse(fileReader);
        return (JSONObject) jsonFile;
    }

    private JSONArray getPresentationItems(JSONObject jsonObject) {
        JSONObject presentation = (JSONObject) jsonObject.get("presentation");
        return (JSONArray) presentation.get("slides");
    }

    private void setSlideItem(JSONObject itemObj, Slide slide) {
        String content = itemObj.get("content").toString();
        int level = Integer.parseInt(itemObj.get("level").toString());
        String kind = itemObj.get("kind").toString();
        if (kind.equals("text")) {
            slide.append(new TextItem(level, content));
        } else if (kind.equals("image")) {
            slide.append(new ImageItem(level, content));
        }
    }

    private void setSlideTitle(JSONObject jsonSlide, Slide slide) {
        String slideTitle = (String) jsonSlide.get("title");
        slide.setTitle(slideTitle);
    }
}
