package notizverwaltung.view;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import notizverwaltung.MainApp;
import notizverwaltung.i18n.I18nComponentsUtil;

/**
 * Diese Klasse erzeugt einen teil des Inhalts des Hauptanzeigefensters.
 * Die tabs werden hier generiert. Sie stellen die Notizbloecke dar.
 *
 * @author Johannes Gerwert
 * @version 09.09.2018
 */
public class NotizblockOverviewController {

    @FXML
    private Tab notizblockName;

    private String name = I18nComponentsUtil.getStandardNotepadName();

    private MainApp mainApp;

    @FXML
    private void initialize(){
        notizblockName.setText(name);
    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }

}
