package notizverwaltung.view;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import notizverwaltung.constants.FXKonstanten;
import notizverwaltung.MainApp;
import notizverwaltung.i18n.I18nUtil;
import notizverwaltung.model.classes.BearbeitungszustandImpl;
import notizverwaltung.model.classes.KategorieImpl;
import notizverwaltung.model.classes.NotizImpl;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Diese Klasse gibt die Funktionalität (DERZEIT NUR VON DER MENUBAR)für das Grundfenster "rootBorderPane" aus der Klasse "MainApp" an.
 * In der RootLayout.fxml wird auf die Methoden dieser Klasse verwiesen.
 *
 * Zur Darstellung der Dialoge wird die KategorieErstellungsdialog.fxml verwendet, die Funktionalität steht in der Klasse "DialogController"
 * 
 * @author Michelle Blau
 * @version 31.08.2018
 */


public class RootLayoutController {


	/**
	 * Eine Referenz auf das Hauptprogramm, wichtig zum verändern der Kategorien/Notizen/Bearbeitungszustände.
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

        //TODO: In Konstante oder Util-Klasse auslagern
        if(mainApp.getKategorieListe().size() == FXKonstanten.maxAnzahlKategorien){
            showZuVieleElementeDialog("Zu viele Kategorien","Bitte bestehende Kategorien entfernen");
        } else{
            try {
                FXMLLoader loader = new FXMLLoader();
                ResourceBundle bundle = I18nUtil.getDialogResourceBundle();
                loader.setLocation(MainApp.class
                    .getResource(FXKonstanten.PFAD_KATEGORIE_ERSTELLUNGSDIALOG_LAYOUT));
                loader.setResources(bundle);
                BorderPane borderPane = (BorderPane) loader.load();

                Scene scene = new Scene(borderPane);
                Stage dialogStage = new Stage();
                dialogStage.setScene(scene);
                DialogController controller = loader.getController();
                controller.setMainApp(this.mainApp);

                dialogStage.setTitle(FXKonstanten.DIALOG);
                dialogStage.setResizable(false);
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
        Bearbeitungszustand tmpZustand = new BearbeitungszustandImpl();

        //TODO: In Konstante oder Util-Klasse auslagern
        if(mainApp.getBearbeitungszustandListe().size() == FXKonstanten.maxAnzahlZustaende){
            showZuVieleElementeDialog("Zu viele Bearbeitungszustände","Bitte bestehende Zustände entfernen");
        } else{
            try {
                FXMLLoader loader = new FXMLLoader();
                ResourceBundle bundle = I18nUtil.getDialogResourceBundle();
                loader.setLocation(MainApp.class
                        .getResource(FXKonstanten.PFAD_BEABREITUNGSZUSTAND_ERSTELLUNGSDIALOG_LAYOUT));
                loader.setResources(bundle);
                BorderPane borderPane = (BorderPane) loader.load();

                Scene scene = new Scene(borderPane);
                Stage dialogStage = new Stage();
                dialogStage.setScene(scene);
                DialogController controller = loader.getController();
                controller.setMainApp(this.mainApp);

                dialogStage.setTitle(FXKonstanten.DIALOG);
                dialogStage.setResizable(false);
                dialogStage.initModality(Modality.APPLICATION_MODAL);
                dialogStage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * Zeigt einen Dialog zur Erstellung einer neuen Notiz
     */
    @FXML
    private void showNotizErstellungsMaske() {
        Notiz tmpNotiz = new NotizImpl();

        //TODO: In Konstante oder Util-Klasse auslagern
        if(mainApp.getNotizListe().size() == FXKonstanten.maxAnzahlNotizen){
            showZuVieleElementeDialog("Zu viele Notizen","Bitte bestehende Notizen entfernen");
        } else{
            try {
                FXMLLoader loader = new FXMLLoader();
                ResourceBundle bundle = I18nUtil.getDialogResourceBundle();
                loader.setLocation(MainApp.class
                        .getResource(FXKonstanten.PFAD_NOTIZ_ERSTELLUNGSDIALOG_LAYOUT));
                loader.setResources(bundle);
                BorderPane borderPane = (BorderPane) loader.load();

                Scene scene = new Scene(borderPane);
                Stage dialogStage = new Stage();
                dialogStage.setScene(scene);
                DialogController controller = loader.getController();
                controller.setMainApp(this.mainApp);

                dialogStage.setTitle(FXKonstanten.DIALOG);
                dialogStage.setResizable(false);
                dialogStage.initModality(Modality.APPLICATION_MODAL);
                dialogStage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Zeigt Warnung, falls die Anzahl an möglichen Kategorien erreicht ist
     */
    private void showZuVieleElementeDialog(String titel, String header){
        Alert dialog = new Alert(Alert.AlertType.WARNING);
        //TODO: i18n
        dialog.setTitle(titel);
        dialog.setHeaderText(header);
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