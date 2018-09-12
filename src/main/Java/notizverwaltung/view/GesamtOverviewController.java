package notizverwaltung.view;

import notizverwaltung.MainApp;

/**
 * Diese Klasse erzeugt einen teil des Inhalts des Hauptanzeigefensters.
 * Der tabPane wird hier generiert. Er beheimatet die verschiedenen
 * Notizbloecke.
 *
 * @author Johannes Gerwert
 * @version 12.09.2018
 */
public class GesamtOverviewController {

    private MainApp mainApp;

    /**
     * Konstruktor
     * Tut momentan nichts.
     */
    public GesamtOverviewController(){

    }

    /**
     * Die Umgebung in der das Bedienelement agiert wird gesetzt.
     * @param mainApp Ein Verweis auf die MainApp.
     */
    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }
}
