package br.upe.ppsw.jabberpoint.service.accessors;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import br.upe.ppsw.jabberpoint.controller.PresentationController;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import br.upe.ppsw.jabberpoint.model.Presentation;
import br.upe.ppsw.jabberpoint.model.items.ImageItem;
import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.model.items.SlideItem;
import br.upe.ppsw.jabberpoint.model.items.TextItem;
import br.upe.ppsw.jabberpoint.service.interfaces.ILoadable;
import br.upe.ppsw.jabberpoint.service.interfaces.ISavable;

public class XMLAccessor implements ILoadable, ISavable {

    protected static final String TEXT = "text";
    protected static final String IMAGE = "image";

    protected static final String PCE = "Parser Configuration Exception";
    protected static final String UNKNOWNTYPE = "Unknown Element type";
    protected static final String NFE = "Number Format Exception";
    private final PresentationController presentationController;

    public XMLAccessor() {
        super();
        this.presentationController = new PresentationController();
    }

    private String getTitle(Element element) {
        NodeList titles = element.getElementsByTagName("title");
        return titles.item(0).getTextContent();
    }

    public void loadFile(PresentationController presentationController, String filename) throws IOException {

        try {

            Element document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new File(filename))
                    .getDocumentElement();

            NodeList slides = document.getElementsByTagName("slide");
            int max = slides.getLength();

            for (int slideNumber = 0; slideNumber < max; slideNumber++) {
                Element xmlSlide = (Element) slides.item(slideNumber);

                Slide slide = new Slide();
                slide.setTitle(getTitle(xmlSlide));
                presentationController.addSlide(slide);

                NodeList slideItems = xmlSlide.getElementsByTagName("item");
                int maxItems = slideItems.getLength();

                for (int itemNumber = 0; itemNumber < maxItems; itemNumber++) {

                    Element item = (Element) slideItems.item(itemNumber);
                    loadSlideItem(slide, item);
                }
            }

        } catch (IOException iox) {
            System.err.println(iox.toString());
        } catch (SAXException sax) {
            System.err.println(sax.getMessage());
        } catch (ParserConfigurationException pcx) {
            System.err.println(PCE);
        }

    }

    protected void loadSlideItem(Slide slide, Element item) {
        int level = 1;

        NamedNodeMap attributes = item.getAttributes();

        String leveltext = attributes.getNamedItem("level").getTextContent();

        if (leveltext != null) {
            try {
                level = Integer.parseInt(leveltext);
            } catch (NumberFormatException x) {
                System.err.println(NFE);
            }
        }

        String type = attributes.getNamedItem("kind").getTextContent();
        if (TEXT.equals(type)) {
            slide.append(new TextItem(level, item.getTextContent()));
        } else {
            if (IMAGE.equals(type)) {
                slide.append(new ImageItem(level, item.getTextContent()));
            } else {
                System.err.println(UNKNOWNTYPE);
            }
        }
    }

    public void saveFile(Presentation presentation, String filename) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(filename));

        out.println("<?xml version=\"1.0\"?>");
        out.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
        out.println("<presentation>");

        out.print("<showtitle>");
        out.println("</showtitle>");

        for (int slideNumber = 0; slideNumber < presentationController.getSize(); slideNumber++) {
            Slide slide = presentationController.getSlide(slideNumber);

            out.println("<slide>");
            out.println("<title>" + slide.getTitle() + "</title>");

            List<SlideItem> slideItems = slide.getSlideItems();
            for (int itemNumber = 0; itemNumber < slideItems.size(); itemNumber++) {
                SlideItem slideItem = slideItems.get(itemNumber);
                out.print("<item kind=");

                if (slideItem instanceof TextItem) {
                    out.print("\"text\" level=\"" + slideItem.getLevel() + "\">");
                    out.print(((TextItem) slideItem).getText());
                } else {
                    if (slideItem instanceof ImageItem) {
                        out.print("\"image\" level=\"" + slideItem.getLevel() + "\">");
                        out.print(((ImageItem) slideItem).getImagePath());
                    } else {
                        System.out.println("Ignoring " + slideItem);
                    }
                }

                out.println("</item>");
            }

            out.println("</slide>");
        }

        out.println("</presentation>");

        out.close();
    }

}
