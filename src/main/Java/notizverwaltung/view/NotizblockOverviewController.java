package notizverwaltung.view;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
public class NotizblockOverviewController{

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
    public NotizblockOverviewController(){

    }

    /**
     * Das Bedienelement wird initialisiert. Dieser Code wird direkt nach dem laden der
     * FXML Datei ausgefuehrt.
     * Der Standard Name fuer Notizbloecke wird in den Tab geladen.
     */
    @FXML
    private void initialize(){
        notizblockName.setText(name);
    }

    /**
     * Die Umgebung in der das Bedienelement agiert wird gesetzt.
     * Außerdem wird eine Liste aus der Main App geladen, die alle entsprechenden
     * Bearbeitungszustaende enthaelt.
     *
     * @param mainApp Ein Verweis auf die MainApp.
     */
    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;

        bearbeitungszustandListe = mainApp.getBearbeitungszustandListe();
        addBearbeitungszustandListener();
    }

    /**
     * Alle Bearbeitungszustaende des Notizblocks werden geladen.
     */
    public void ladeBearbeitungszustaende(){

        for(Bearbeitungszustand bazs : bearbeitungszustandListe) {
            addBearbeitungszustand(bazs);
        }
    }

    /**
     * Ein Bearbeitungszustand wird zum Notizblock hinzugefuegt.
     * Seine Notizen werden geladen.
     *
     * @param bazs Der entsprechende Bearbeitungszustand
     */
    public void addBearbeitungszustand(Bearbeitungszustand bazs){
        try {
            FXMLLoader loader = new FXMLLoader();
            ResourceBundle bundle = I18nUtil.getComponentsResourceBundle();
            loader.setLocation(MainApp.class
                    .getResource(FXKonstanten.PFAD_BEARBEITUNGSZUSTAND_OVERVIEW_LAYOUT));
            loader.setResources(bundle);
            TitledPane spalte = (TitledPane) loader.load();
            spalte.setId("" + bazs.getBearbeitungsZustandID());

            spalten.getChildren().add(spalte);

            BearbeitungszustandOverviewController controller = loader.getController();
            controller.setMainApp(mainApp);
            controller.setBearbeitungszustand(bazs);
            controller.ladeNotizen();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Ein Bearbeitungsstatus wird vom Notizblock entfernt.
     *
     * @param bazs der zu entfernende Bearbeitungsstatus
     */
    public void removeBearbeitungszustand(Bearbeitungszustand bazs){
        String bazsID = "" + bazs.getBearbeitungsZustandID();

        for(Node spalte: spalten.getChildren()){
            if(bazsID.equals(spalte.getId())){
                spalten.getChildren().remove(spalte);
            }
        }
    }

    /**
     * Ein Listener wird zur bearbeitungszustandListe hinzugefuegt.
     * Wenn ein Bearbeitungsstatus zur Liste hinzugefuegt oder daraus entfernt wird,
     * wird dies auch in der GUI dargestellt.
     */
    private void addBearbeitungszustandListener(){
        bearbeitungszustandListe.addListener(new ListChangeListener<Bearbeitungszustand>() {
            @Override
            public void onChanged(Change<? extends Bearbeitungszustand> c) {
                while (c.next()) {
                    if (c.wasAdded()) {
                        for (Bearbeitungszustand bazs : c.getAddedSubList()) {
                            addBearbeitungszustand(bazs);
                        }
                    }

                    if (c.wasRemoved()) {
                        for (Bearbeitungszustand bazs : c.getRemoved()) {
                            removeBearbeitungszustand(bazs);
                        }
                    }
                }
            }
        });
    }

}
