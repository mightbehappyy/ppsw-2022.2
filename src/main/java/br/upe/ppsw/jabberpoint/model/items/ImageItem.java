package br.upe.ppsw.jabberpoint.model.items;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.springframework.util.ResourceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageItem extends SlideItem {

    private BufferedImage bufferedImage;
    private static final Logger logger = LoggerFactory.getLogger(ImageItem.class);

    public ImageItem(int level, String filePath) {
        super(level, filePath);
        readImage();
    }

    public ImageItem() {
        super(0, " ");
    }

    @Override
    public void setContent(String content) {
        this.content = content;
        readImage();
    }

    public void readImage() {
        try {
            bufferedImage = ImageIO.read(ResourceUtils.getFile(content).getAbsoluteFile());
        } catch (IOException e) {
            logger.error("{} {} {}", "Arquivo ", content, " não encontrado");
        }
    }

    public String getImagePath() {
        return content;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public String toString() {
        return "ImageItem[" + getLevel() + "," + content + "]";
    }

}