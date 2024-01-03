package br.upe.ppsw.jabberpoint.service.acessors;

import br.upe.ppsw.jabberpoint.controller.PresentationController;
import br.upe.ppsw.jabberpoint.model.ImageItem;
import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.model.SlideItem;
import br.upe.ppsw.jabberpoint.model.TextItem;
import br.upe.ppsw.jabberpoint.service.interfaces.ILoadable;
import br.upe.ppsw.jabberpoint.service.interfaces.ISavable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class HTMLAccessor implements ILoadable, ISavable {


    @Override
    public void saveFile(PresentationController presentation, String fileName) throws IOException {

    }

    @Override
    public void loadFile(PresentationController presentation, String fileName){
        try {
            for (Element items : getPresentationItems(fileName)) {
                Slide slide = new Slide();
                setSlideTitle(items, slide);
                for (Element elements : items.children()) {
                    slide.append(setSlideItem(elements, slide));
                }

                presentation.append(slide);
            }
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.info(e.toString());
        }
    }

    private Document parseFile(String fileName) throws IOException{
        File fileReader = new File(fileName);
        return Jsoup.parse(fileReader,"utf-8");
    }

    private Elements getPresentationItems(String fileName) throws IOException {
       return parseFile(fileName).select(".slide");
    }

    private SlideItem setSlideItem(Element elements, Slide slide) {
        String kind = elements.attr("kind");
        String level = elements.attr("level");
        String content = elements.text();
        String imgString = elements.attr("src");
        if ("text".equals(kind)) {
            return new TextItem(Integer.parseInt(level), content);
        } else if ("image".equals(kind)) {
            return new ImageItem(Integer.parseInt(level), imgString);
        }
        return new TextItem();
    }

    private void setSlideTitle(Element items, Slide slide) {
        Element titleElement = items.selectFirst("[kind=title]");
        assert titleElement != null;
        String slideTitle = titleElement.text();
        slide.setTitle(slideTitle);
    }
}
