package br.upe.ppsw.jabberpoint.view.drawers;

import br.upe.ppsw.jabberpoint.model.Slide;
import br.upe.ppsw.jabberpoint.model.items.ImageItem;
import br.upe.ppsw.jabberpoint.model.items.SlideItem;
import br.upe.ppsw.jabberpoint.model.items.TextItem;
import br.upe.ppsw.jabberpoint.service.accessors.*;
import br.upe.ppsw.jabberpoint.service.interfaces.ILoadable;
import br.upe.ppsw.jabberpoint.view.drawers.interfaces.IDrawableItem;

import java.util.HashMap;
import java.util.Map;

public class DrawerCreator {

        private final Map<String, IDrawableItem> supportedExtensions = Map.of(
                "image", new ImageItemDrawer(),
                "text", new TextItemDrawer(),
                "default", new TextItemDrawer()
        );

        public IDrawableItem createDrawer(SlideItem item) {

                IDrawableItem drawableItem = supportedExtensions
                        .getOrDefault(item.getKind(), supportedExtensions.get("default"));

                drawableItem.setSlideItem(item);

                return drawableItem;

        }
}
