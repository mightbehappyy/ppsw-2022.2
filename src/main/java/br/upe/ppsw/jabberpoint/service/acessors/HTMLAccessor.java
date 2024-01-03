package br.upe.ppsw.jabberpoint.controller.acessors;

import br.upe.ppsw.jabberpoint.controller.PresentationController;
import br.upe.ppsw.jabberpoint.model.interfaces.ILoadable;
import br.upe.ppsw.jabberpoint.model.interfaces.ISavable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HTMLAccessor implements ILoadable, ISavable {



    private Document getHTMLObject(String fileName) throws IOException{

        File fileReader = new File("src/main/resources/test.html");
        return Jsoup.parse(fileReader,"utf-8");
    }

    @Override
    public void loadFile(PresentationController presentation, String fileName) throws IOException {
        Elements elements = getHTMLObject("none").body().select("*");

        for (Element element : elements) {

        }

    }

    @Override
    public void saveFile(PresentationController presentation, String fileName) throws IOException {

    }
}
