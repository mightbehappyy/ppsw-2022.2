package br.upe.ppsw.jabberpoint.model.items;

public class SlideItemNullObject extends TextItem {

    @Override
    public void setContent(String content) {
        this.content = "Erro: Não foi possível reconhecer esse item";
    }

    public String toString() {
        return "Couldn't recognize this item's format";
    }
}
