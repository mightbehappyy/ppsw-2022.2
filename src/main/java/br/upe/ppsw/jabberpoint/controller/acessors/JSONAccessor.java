package br.upe.ppsw.jabberpoint.controller.acessors;


import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import br.upe.ppsw.jabberpoint.model.ImageItem;
import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.model.TextItem;
import org.json.simple.*;
import org.json.simple.parser.*;


import br.upe.ppsw.jabberpoint.controller.PresentationController;
import br.upe.ppsw.jabberpoint.model.interfaces.ILoadable;
import br.upe.ppsw.jabberpoint.model.interfaces.ISavable;

public class JSONAccessor implements ILoadable, ISavable {

    private JSONArray getSlides(String fileName) throws IOException, ParseException {
        JSONObject jsonObject = getJsonObject(fileName);
        JSONObject presentation = (JSONObject) jsonObject.get("presentation");
        return (JSONArray) presentation.get("slides");
    }

    private void setSlides(PresentationController presentation, String fileName) throws IOException, ParseException {
        JSONArray jsonSlides = getSlides(fileName);

        for (Object o : jsonSlides) {

            JSONObject jsonSlide = (JSONObject) o;
            String slideTitle = (String) jsonSlide.get("title");

            Slide slide = new Slide();
            slide.setTitle(slideTitle);
            presentation.append(slide);

            JSONArray items = (JSONArray) jsonSlide.get("items");

            if (items != null) {
                for (Object itemObj : items) {
                    JSONObject item = (JSONObject) itemObj;
                    String content = (String) item.get("content");
                    Long level = (Long) item.get("level");
                    String kind = (String) item.get("kind");
                    if (kind.equals("text")) {
                        slide.append(new TextItem(level.intValue(), content));

                    } else if (kind.equals("image")) {

                        slide.append(new ImageItem(level.intValue(), content));
                    }
                }
            } else {
                slide.append(new TextItem());
            }
        }

    }

    private JSONObject getJsonObject(String fileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader fileReader = new FileReader(fileName);
        Object jsonFile = parser.parse(fileReader);
        return (JSONObject)jsonFile;
    }

    @Override
    public void saveFile(PresentationController presentation, String fileName) throws IOException {
        throw new UnsupportedOperationException("Unimplemented method 'loadFile'");
    }

    @Override
    public void loadFile(PresentationController presentation, String fileName) throws IOException {
        try{
            setSlides(presentation, fileName);
        } catch(IOException | ParseException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.info(e.toString());
        }

    }

}
