package br.upe.ppsw.jabberpoint.view.drawers;

import br.upe.ppsw.jabberpoint.model.items.ImageItem;
import br.upe.ppsw.jabberpoint.model.items.SlideItem;
import br.upe.ppsw.jabberpoint.model.items.TextItem;
import br.upe.ppsw.jabberpoint.view.drawers.interfaces.IDrawableItem;

public class DrawerCreator {

        private DrawerCreator() {

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
