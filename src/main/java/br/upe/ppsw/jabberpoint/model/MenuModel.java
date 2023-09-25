package br.upe.ppsw.jabberpoint.model;

import br.upe.ppsw.jabberpoint.view.MenuViewer;

public class MenuModel {

    public int getUserSelectedSlideNumber() {
        String pageNumberStr = MenuViewer.showGoToPageDialogBox();
        return Integer.parseInt(pageNumberStr);
    }
}
