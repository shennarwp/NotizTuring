package notizverwaltung.view;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import notizverwaltung.constants.FXKonstanten;
import notizverwaltung.MainApp;
import notizverwaltung.i18n.I18nUtil;
import notizverwaltung.util.FXUtil;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Diese Klasse gibt die Funktionalität für das Grundfenster aus der Klasse "MainApp" an.
 * In der RootLayout.fxml wird auf diese Klasse verwiesen.
 *
 * Die Funktionalität der Dialog-Fenster wird in einer anderen Klasse, "AenderungsDialogController" zur Verfügung gestellt, hier
 * werden die Dialog-Fenster lediglich geöffnet
 * 
 * @author Michelle Blau
 * @version 12.09.2018
 */


public class RootLayoutController {


	/**
	 * Eine Referenz auf das Hauptprogramm, wichtig zum Verändern der Kategorien/Notizen/Bearbeitungszustände.
	 */
    private MainApp mainApp;
    private Stage dialogStage;


    public Stage getDialogStage(){
        return this.dialogStage;
    }


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }



    /**
     * Zeigt einen Dialog zur Erstellung einer neuen Kategorie
     * beim Klicken auf "Neu -> Kategorie"
     */
    @FXML
    private void handleshowKategorieErstellungsMaske() {

        //TODO: i18n, Anzahlen anders überprüfen
        if(mainApp.getKategorieListe().size() == FXKonstanten.maxAnzahlKategorien){
            FXUtil.showZuVieleElementeWarningDialog("Zu viele Kategorien","Bitte bestehende Kategorien entfernen");
        } else{
            showErstellungsDialogFenster(FXKonstanten.PFAD_KATEGORIE_ERSTELLUNGSDIALOG_LAYOUT);
        }
    }



    /**
     * Zeigt einen Dialog zur Erstellung eines neuen Bearbeitungszustands beim Klicken auf
     * "Neu -> Bearbeitungszustand"
     */
    @FXML
    private void handleshowBearbeitungszustandErstellungsMaske() {

        //TODO: i18n, Anzahlen anders überprüfen
        if(mainApp.getBearbeitungszustandListe().size() == FXKonstanten.maxAnzahlZustaende){
            FXUtil.showZuVieleElementeWarningDialog("Zu viele Bearbeitungszustände","Bitte bestehende Zustände entfernen");
        } else{
            showErstellungsDialogFenster(FXKonstanten.PFAD_BEABREITUNGSZUSTAND_ERSTELLUNGSDIALOG_LAYOUT);
        }
    }



    /**
     * Zeigt einen Dialog zur Erstellung einer neuen Notiz
     * beim Klicken auf "Neu -> Notiz"
     */
    @FXML
    private void handleshowNotizErstellungsMaske() {

        //TODO: i18n, Anzahlen anders überprüfen
        if(mainApp.getNotizListe().size() == FXKonstanten.maxAnzahlNotizen){
            FXUtil.showZuVieleElementeWarningDialog("Zu viele Notizen","Bitte bestehende Notizen entfernen");
        } else{
            showErstellungsDialogFenster(FXKonstanten.PFAD_NOTIZ_ERSTELLUNGSDIALOG_LAYOUT);
        }
    }

    /**
     * Zeigt einen Dialog zum Verändern einer bestehenden Kategorie
     */
    @FXML
    private void handleshowKategorieAenderungsMaske() {
        showAenderungsDialogFenster(FXKonstanten.PFAD_KATEGORIE_AENDERUNGSDIALOG_LAYOUT);
    }


    /**
     * Zeigt einen Dialog zum Verändern eines bestehenden Bearbeitungszustands
     */
    @FXML
    private void handleshowZustandAenderungsMaske() {
        showAenderungsDialogFenster(FXKonstanten.PFAD_ZUSTAND_AENDERUNGSDIALOG_LAYOUT);
    }


    /**
     * Zeigt einen Dialog zum Verändern einer bestehenden Notiz
     */
    @FXML
    private void handleshowNotizAenderungsMaske() {
        showAenderungsDialogFenster(FXKonstanten.PFAD_NOTIZ_AENDERUNGSDIALOG_LAYOUT);
    }


    /**
     * Zeigt einen Dialog zum Löschen einer bestehenden Notiz
     */
    @FXML
    private void handleshowNotizLoeschungsMaske() {
        showLoeschungsDialogFenster(FXKonstanten.PFAD_NOTIZ_LOESCHUNGSDIALOG_LAYOUT);
    }


    /**
     * Zeigt einen Dialog zum Löschen einer bestehenden Kategorie
     */
    @FXML
    private void handleshowKategorieLoeschungsMaske() {
        showLoeschungsDialogFenster(FXKonstanten.PFAD_KATEGORIE_LOESCHUNGSDIALOG_LAYOUT);
    }

    /**
     * Zeigt einen Dialog zum Löschen eines bestehenden Bearbeitungszustands
     */
    @FXML
    private void handleshowBearbeitungszustandLoeschungsMaske() {
        showLoeschungsDialogFenster(FXKonstanten.PFAD_ZUSTAND_LOESCHUNGSDIALOG_LAYOUT);
    }


    /**
     * Hilfsmethode, erzeugt Dialogfenster zum Erstellen von Objekten und zeigt dieses an.
     *
     * @param fxmlPfad Pfad zur fxml-Datei
     */
    private void showErstellungsDialogFenster(String fxmlPfad){
        try {
            FXMLLoader loader = new FXMLLoader();
            ResourceBundle bundle = I18nUtil.getDialogResourceBundle();
            loader.setLocation(MainApp.class
                    .getResource(fxmlPfad));
            loader.setResources(bundle);
            AnchorPane anchorPane = (AnchorPane) loader.load();

            Scene scene = new Scene(anchorPane);
            this.dialogStage = new Stage();
            this.dialogStage.setScene(scene);
            ErstellungsDialogController controller = loader.getController();
            controller.setMainApp(this.mainApp);
            controller.setDialogStage(this.dialogStage);

            this.dialogStage.setTitle(FXKonstanten.DIALOG);
            this.dialogStage.setResizable(false);
            this.dialogStage.initModality(Modality.APPLICATION_MODAL);
            this.dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Hilfsmethode, erzeugt Dialogfenster zum Ändern von Objekten und zeigt dieses an.
     *
     * @param fxmlPfad Pfad zur fxml-Datei
     */
    private void showAenderungsDialogFenster(String fxmlPfad){
        try {
            FXMLLoader loader = new FXMLLoader();
            ResourceBundle bundle = I18nUtil.getDialogResourceBundle();
            loader.setLocation(MainApp.class
                    .getResource(fxmlPfad));
            loader.setResources(bundle);
            AnchorPane anchorPane = (AnchorPane) loader.load();

            Scene scene = new Scene(anchorPane);
            this.dialogStage = new Stage();
            this.dialogStage.setScene(scene);
            AenderungsDialogController controller = loader.getController();
            controller.setMainApp(this.mainApp);
            controller.setDialogStage(this.dialogStage);

            this.dialogStage.setTitle(FXKonstanten.DIALOG);
            this.dialogStage.setResizable(false);
            this.dialogStage.initModality(Modality.APPLICATION_MODAL);
            this.dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * Hilfsmethode, erzeugt Dialogfenster zum Löschen von Objekten und zeigt dieses an.
     *
     * @param fxmlPfad Pfad zur fxml-Datei
     */
    private void showLoeschungsDialogFenster(String fxmlPfad){
        try {
            FXMLLoader loader = new FXMLLoader();
            ResourceBundle bundle = I18nUtil.getDialogResourceBundle();
            loader.setLocation(MainApp.class
                    .getResource(fxmlPfad));
            loader.setResources(bundle);
            AnchorPane anchorPane = (AnchorPane) loader.load();

            Scene scene = new Scene(anchorPane);
            this.dialogStage = new Stage();
            this.dialogStage.setScene(scene);
            LoeschungsDialogController controller = loader.getController();
            controller.setMainApp(this.mainApp);
            controller.setDialogStage(this.dialogStage);

            this.dialogStage.setTitle(FXKonstanten.DIALOG);
            this.dialogStage.setResizable(false);
            this.dialogStage.initModality(Modality.APPLICATION_MODAL);
            this.dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Schliesst das Programm.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }

}