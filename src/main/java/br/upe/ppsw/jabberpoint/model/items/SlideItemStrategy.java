package br.upe.ppsw.jabberpoint.model.items;

import java.util.Map;
// Apliquei padrão strategy aos SlideItems pois existia uma repetição de código que poderia ser substituída
// O padrão ajuda na legibilidade do código, se houver mais slide items não será necessário modificar todos
// os acessors.
public class SlideItemStrategy {

    private final Map<String, SlideItem> supportedItems = Map.of(
            "text", new TextItem(),
            "image", new ImageItem(),
            "default", new SlideItemNullObject()
    );

    public SlideItem getSlideItemKind(String kind, String content, int level) {
        SlideItem slideItem = supportedItems.getOrDefault(kind, supportedItems.get("default"));
        slideItem.setLevel(level);
        slideItem.setContent(content);

        return slideItem;
    }

}
