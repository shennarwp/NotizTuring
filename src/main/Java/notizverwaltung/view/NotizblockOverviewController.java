package notizverwaltung.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import notizverwaltung.MainApp;
import notizverwaltung.constants.FXKonstanten;
import notizverwaltung.i18n.I18nComponentsUtil;
import notizverwaltung.i18n.I18nUtil;
import notizverwaltung.model.interfaces.Bearbeitungszustand;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Diese Klasse erzeugt einen teil des Inhalts des Hauptanzeigefensters.
 * Die tabs werden hier generiert. Sie stellen die Notizbloecke dar.
 *
 * @author Johannes Gerwert
 * @version 12.09.2018
 */
public class NotizblockOverviewController {

    @FXML
    private Tab notizblockName;
    @FXML
    private HBox spalten;

    private String name = I18nComponentsUtil.getStandardNotepadName();
    private ObservableList<Bearbeitungszustand> bearbeitungszustandListe;

    private MainApp mainApp;

    /**
     * Konstruktor
     * Tut momentan nichts.
     */
    public NotizblockOverviewController() {

    }

    /**
     * Das Bedienelement wird initialisiert. Dieser Code wird direkt nach dem laden der
     * FXML Datei ausgefuehrt.
     * Der Standard Name fuer Notizbloecke wird in den Tab geladen.
     */
    @FXML
    private void initialize() {
        notizblockName.setText(name);
    }

    /**
     * Die Umgebung in der das Bedienelement agiert wird gesetzt.
     * Außerdem wird eine Liste aus der Main App geladen, die alle entsprechenden
     * Bearbeitungszustaende enthaelt.
     *
     * @param mainApp Ein Verweis auf die MainApp.
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        bearbeitungszustandListe = mainApp.getBearbeitungszustandListe();
    }

    /**
     * Die Bearbeitungszustaende des Notizblocks werden geladen.
     * Fuer jedes Objekt in der Liste wird ein TitledPane angelegt. Dieser enthaelt
     * einen ScrollPane und eine VBox um die Notizen darzustellen.
     * Der Bearbeitungszustand wird dann in die HBox geladen.
     * Schlussendlich werden die Notizen des Bearbeitungszustands geladen.
     */
    public void ladeBearbeitungszustaende() {
        try {
            for (Bearbeitungszustand bazs : bearbeitungszustandListe) {
                FXMLLoader loader = new FXMLLoader();
                ResourceBundle bundle = I18nUtil.getComponentsResourceBundle();
                loader.setLocation(MainApp.class
                        .getResource(FXKonstanten.PFAD_BEARBEITUNGSZUSTAND_OVERVIEW_LAYOUT));
                loader.setResources(bundle);
                TitledPane spalte = (TitledPane) loader.load();

                spalten.getChildren().add(spalte);

                BearbeitungszustandOverviewController controller = loader.getController();
                controller.setMainApp(mainApp);
                controller.setBearbeitungszustand(bazs);
                controller.ladeNotizen();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
