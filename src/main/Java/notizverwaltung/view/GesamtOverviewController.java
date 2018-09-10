package notizverwaltung.view;

import notizverwaltung.MainApp;

/**
 * Diese Klasse erzeugt einen teil des Inhalts des Hauptanzeigefensters.
 * Der tabPane wird hier generiert. Er beheimatet die verschiedenen
 * Notizbloecke.
 *
 * @author Johannes Gerwert
 * @version 09.09.2018
 */
public class GesamtOverviewController {

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }
}
