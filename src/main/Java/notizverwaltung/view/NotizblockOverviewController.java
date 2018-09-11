package notizverwaltung.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
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
 * @version 09.09.2018
 */
public class NotizblockOverviewController {

    @FXML
    private Tab notizblockName;
    @FXML
    private HBox spalten;

    private String name = I18nComponentsUtil.getStandardNotepadName();
    private ObservableList<Bearbeitungszustand> bearbeitungszustandListe;

    private MainApp mainApp;

    public NotizblockOverviewController(){

    }

    @FXML
    private void initialize(){
        notizblockName.setText(name);
    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;

        bearbeitungszustandListe = mainApp.getBearbeitungszustandListe();
    }

    public void ladeBearbeitungszustaende(){
        try {
            for(Bearbeitungszustand bazs : bearbeitungszustandListe) {
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
        } catch(IOException e){
            e.printStackTrace();
        }
    }

}
