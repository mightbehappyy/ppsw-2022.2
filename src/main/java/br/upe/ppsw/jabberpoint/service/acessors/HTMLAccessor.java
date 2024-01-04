package br.upe.ppsw.jabberpoint.service.acessors;

import br.upe.ppsw.jabberpoint.controller.PresentationController;
import br.upe.ppsw.jabberpoint.model.Presentation;
import br.upe.ppsw.jabberpoint.model.items.ImageItem;
import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.model.items.SlideItem;
import br.upe.ppsw.jabberpoint.model.items.TextItem;
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
    public void saveFile(Presentation presentation, String fileName) throws IOException {

    }

    @Override
    public void loadFile(PresentationController presentationController, String fileName){
        try {
            for (Element items : getPresentationItems(fileName)) {
                Slide slide = new Slide();
                setSlideTitle(items, slide);
                for (Element elements : items.children()) {
                    slide.append(setSlideItem(elements));
                }
                presentationController.addSlide(slide);

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

    private SlideItem setSlideItem(Element elements) {
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
