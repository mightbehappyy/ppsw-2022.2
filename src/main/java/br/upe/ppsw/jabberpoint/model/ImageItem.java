package br.upe.ppsw.jabberpoint.model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.springframework.util.ResourceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageItem extends SlideItem {

  private BufferedImage bufferedImage;
  private final String imageFilePath;
  private static final Logger logger = LoggerFactory.getLogger(ImageItem.class);

  protected static final String FILE = "Arquivo ";
  protected static final String NOTFOUND = " não encontrado";

  public ImageItem(int level, String filePath) {
    super(level);
    imageFilePath = filePath;
    readImage();
  }

  public void readImage() {
    try {
      bufferedImage = ImageIO.read(ResourceUtils.getFile(imageFilePath).getAbsoluteFile());
    } catch (IOException e) {
      logger.error("{} {} {}", FILE, imageFilePath, NOTFOUND);
    }
  }

  public String getImagePath() {
    return imageFilePath;
  }

  public BufferedImage getBufferedImage() {
    return bufferedImage;
  }

  public String toString() {
    return "ImageItem[" + getLevel() + "," + imageFilePath + "]";
  }

}
