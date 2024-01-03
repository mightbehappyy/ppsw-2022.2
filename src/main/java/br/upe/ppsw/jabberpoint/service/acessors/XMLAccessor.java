package br.upe.ppsw.jabberpoint.controller.acessors;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.upe.ppsw.jabberpoint.controller.PresentationController;
import br.upe.ppsw.jabberpoint.model.ImageItem;
import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.model.SlideItem;
import br.upe.ppsw.jabberpoint.model.TextItem;
import br.upe.ppsw.jabberpoint.model.interfaces.ILoadable;
import br.upe.ppsw.jabberpoint.model.interfaces.ISavable;

public class XMLAccessor implements ILoadable, ISavable {

  protected static final String DEFAULT_API_TO_USE = "dom";

  protected static final String SHOWTITLE = "showtitle";
  protected static final String SLIDETITLE = "title";
  protected static final String SLIDE = "slide";
  protected static final String ITEM = "item";
  protected static final String LEVEL = "level";
  protected static final String KIND = "kind";
  protected static final String TEXT = "text";
  protected static final String IMAGE = "image";

  protected static final String PCE = "Parser Configuration Exception";
  protected static final String UNKNOWNTYPE = "Unknown Element type";
  protected static final String NFE = "Number Format Exception";

  private static XMLAccessor instance = null;

  private XMLAccessor() {
    super();
  }

  public static XMLAccessor getInstance() {
    if (instance == null) {
      instance = new XMLAccessor();
    }
    return instance;
  }

  private String getTitle(Element element) {
    NodeList titles = element.getElementsByTagName(XMLAccessor.SLIDETITLE);
    return titles.item(0).getTextContent();
  }

  public void loadFile(PresentationController presentation, String filename) throws IOException {
    int slideNumber;
    int itemNumber;
    int max = 0;
    int maxItems = 0;

    try {



      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

      Document document = builder.parse(new File(filename));

      Element doc = document.getDocumentElement();

      NodeList slides = doc.getElementsByTagName(SLIDE);
      max = slides.getLength();

      for (slideNumber = 0; slideNumber < max; slideNumber++) {
        Element xmlSlide = (Element) slides.item(slideNumber);

        Slide slide = new Slide();
        slide.setTitle(getTitle(xmlSlide));
        presentation.append(slide);

        NodeList slideItems = xmlSlide.getElementsByTagName(ITEM);
        maxItems = slideItems.getLength();

        for (itemNumber = 0; itemNumber < maxItems; itemNumber++) {

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

    String leveltext = attributes.getNamedItem(LEVEL).getTextContent();

    if (leveltext != null) {
      try {
        level = Integer.parseInt(leveltext);
      } catch (NumberFormatException x) {
        System.err.println(NFE);
      }
    }

    String type = attributes.getNamedItem(KIND).getTextContent();
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

  public void saveFile(PresentationController presentation, String filename) throws IOException {
    PrintWriter out = new PrintWriter(new FileWriter(filename));

    out.println("<?xml version=\"1.0\"?>");
    out.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
    out.println("<presentation>");

    out.print("<showtitle>");
    out.println("</showtitle>");

    for (int slideNumber = 0; slideNumber < presentation.getSize(); slideNumber++) {
      Slide slide = presentation.getSlide(slideNumber);

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
