package notizverwaltung.view;

import notizverwaltung.MainApp;
import notizverwaltung.constants.FXKonstanten;
import notizverwaltung.i18n.I18nComponentsUtil;

/**
 * Diese Klasse erzeugt den Inhalt des Hauptanzeigefensters.
 * Die tabs des tab panes werden hier generiert. Sie stellen die
 * verschiedenen Notizbloecke dar.
 *
 * @author Johannes Gerwert
 * @version 08.09.2018
 */
public class GesamtOverviewController {

    private MainApp mainApp;

    private int anzahlNotizbloecke = FXKonstanten.STANDARD_NOTIZBLOCK_ANZAHL;
    private String standardNotizblockName = I18nComponentsUtil.getStandardNotepadName();

    private void initialize(){
        //todo
    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }
}
