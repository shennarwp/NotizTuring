package notizverwaltung.view;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import notizverwaltung.constants.FXKonstanten;
import notizverwaltung.i18n.I18nMessagesUtil;
import notizverwaltung.MainApp;
import notizverwaltung.i18n.I18nUtil;
import notizverwaltung.model.classes.KategorieImpl;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 *
 * Diese Klasse gibt die Funktionalität (DERZEIT NUR VON DER MENUBAR)für das Grundfenster "rootBorderPane" aus der Klasse "MainApp" an.
 * In der view_fxml/RootLayout.fxml wird auf die Methoden dieser Klasse verwiesen.
 * 
 * @author Michelle Blau
 * @version 29.08.2018
 */


public class RootLayoutController {

	/**
	 * Eine Referenz auf das Hauptprogramm.
	 */
    private MainApp mainApp;



    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }



    /**
     * Zeigt einen Dialog zur Erstellung einer neuen Kategorie
     */
    @FXML
    private void showKategorieErstellungsMaske() {
        Kategorie tmpKategorie = new KategorieImpl();

        if(mainApp.getKategorieListe().size() == 20){ //TODO: In Konstante oder Util-Klasse auslagern
            showZuVieleKategorienDialog();
        } else{
            try {
                FXMLLoader loader = new FXMLLoader();
                ResourceBundle bundle = I18nUtil.getDialogResourceBundle();
                loader.setLocation(MainApp.class
                    .getResource(FXKonstanten.PFAD_DIALOG_LAYOUT));
                loader.setResources(bundle);
                BorderPane borderPane = (BorderPane) loader.load();

                Scene scene = new Scene(borderPane);
                Stage dialogStage = new Stage();
                dialogStage.setScene(scene);
                DialogController controller = loader.getController();
                controller.setMainApp(this.mainApp);

                dialogStage.initModality(Modality.APPLICATION_MODAL);
                dialogStage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * Zeigt einen Dialog zur Erstellung eines neuen Bearbeitungszustands
     */
    @FXML
    private void showBearbeitungszustandErstellungsMaske() {
        System.out.println("Bzustand");
    }



    /**
     * Zeigt einen Dialog zur Erstellung einer neuen Notiz
     */
    @FXML
    private void showNotizErstellungsMaske() {
        System.out.println("Notiz");
    }


    /**
     * Zeigt Warnung, falls die Anzahl an möglichen Kategorien erreicht ist
     */
    private void showZuVieleKategorienDialog(){
        Alert dialog = new Alert(Alert.AlertType.WARNING);
        //TODO: i18n
        dialog.setTitle("Es gibt bereits zu viele Kategorien");
        dialog.setHeaderText("Bitte bestehende Kategorien entfernen, um neue hinzufügen zu können");
        dialog.showAndWait();
    }

    /**
     * Schliesst das Programm.
     */
//    @FXML
//    private void handleExit() {
//        System.exit(0);
//    }

}