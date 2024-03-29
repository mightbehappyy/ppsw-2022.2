package br.upe.ppsw.jabberpoint.service.accessors;


import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import br.upe.ppsw.jabberpoint.controller.PresentationController;
import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.model.items.SlideItem;
import br.upe.ppsw.jabberpoint.model.items.SlideItemStrategy;
import org.json.simple.*;
import org.json.simple.parser.*;


import br.upe.ppsw.jabberpoint.model.Presentation;
import br.upe.ppsw.jabberpoint.service.interfaces.ILoadable;
import br.upe.ppsw.jabberpoint.service.interfaces.ISavable;

public class JSONAccessor implements ILoadable, ISavable {


    @Override
    public void saveFile(Presentation presentation, String fileName) {
        throw new UnsupportedOperationException("Unimplemented method 'loadFile'");
    }

    @Override
    public void loadFile(PresentationController presentationController, String fileName) throws IOException {

        try {
            for (Object o : getPresentationItems(parseFile(fileName))) {
                JSONObject jsonSlide = (JSONObject) o;
                Slide slide = new Slide();
                setSlideTitle(jsonSlide, slide);
                for (Object itemObj : (JSONArray) jsonSlide.get("items")) {
                    slide.append(setSlideItem((JSONObject) itemObj));

                }

                presentationController.addSlide(slide);
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

    private SlideItem setSlideItem(JSONObject itemObj) {
        String content = itemObj.get("content").toString();
        int level = Integer.parseInt(itemObj.get("level").toString());
        String kind = itemObj.get("kind").toString();

        SlideItemStrategy slideItemStrategy = new SlideItemStrategy();
        return slideItemStrategy.getSlideItemKind(kind, content, level);
    }

    private void setSlideTitle(JSONObject jsonSlide, Slide slide) {
        String slideTitle = (String) jsonSlide.get("title");
        slide.setTitle(slideTitle);
    }
}
