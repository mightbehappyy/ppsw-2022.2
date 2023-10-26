package br.upe.ppsw.jabberpoint.view.drawers;

import br.upe.ppsw.jabberpoint.model.ImageItem;
import br.upe.ppsw.jabberpoint.model.SlideItem;
import br.upe.ppsw.jabberpoint.model.TextItem;
import br.upe.ppsw.jabberpoint.view.drawers.interfaces.IDrawableItem;

public class ItemFactory {

        private ItemFactory() {

        }

        public static IDrawableItem createDrawer(SlideItem item) {
                if (item instanceof ImageItem) {
                        return new ImageItemDrawer((ImageItem) item);
                } else if (item instanceof TextItem) {
                        return new TextItemDrawer((TextItem) item);
                }
                throw new IllegalArgumentException("Unsupported item type");
        }
}
