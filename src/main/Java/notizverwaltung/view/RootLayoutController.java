package notizverwaltung.view;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
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
import notizverwaltung.util.FXUtil;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Diese Klasse gibt die Funktionalität für das Grundfenster aus der Klasse "MainApp" an.
 * In der RootLayout.fxml wird auf diese Klasse verwiesen.
 *
 * Die Funktionalität der Dialog-Fenster wird in einer anderen Klasse, "DialogController" zur Verfügung gestellt, hier
 * werden die Dialog-Fenster lediglich geöffnet
 * 
 * @author Michelle Blau
 * @version 08.09.2018
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
     */
    @FXML
    private void handleshowKategorieErstellungsMaske() {
        Kategorie tmpKategorie = new KategorieImpl();

        //TODO: i18n
        if(mainApp.getKategorieListe().size() == FXKonstanten.maxAnzahlKategorien){
            FXUtil.showZuVieleElementeWarningDialog("Zu viele Kategorien","Bitte bestehende Kategorien entfernen");
        } else{
            try {
                FXMLLoader loader = new FXMLLoader();
                ResourceBundle bundle = I18nUtil.getDialogResourceBundle();
                loader.setLocation(MainApp.class
                    .getResource(FXKonstanten.PFAD_KATEGORIE_ERSTELLUNGSDIALOG_LAYOUT));
                loader.setResources(bundle);
                BorderPane borderPane = (BorderPane) loader.load();

                Scene scene = new Scene(borderPane);
                this.dialogStage = new Stage();
                this.dialogStage.setScene(scene);
                DialogController controller = loader.getController();
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
    }



    /**
     * Zeigt einen Dialog zur Erstellung eines neuen Bearbeitungszustands
     */
    @FXML
    private void handleshowBearbeitungszustandErstellungsMaske() {
        Bearbeitungszustand tmpZustand = new BearbeitungszustandImpl();

        //TODO: i18n
        if(mainApp.getBearbeitungszustandListe().size() == FXKonstanten.maxAnzahlZustaende){
            FXUtil.showZuVieleElementeWarningDialog("Zu viele Bearbeitungszustände","Bitte bestehende Zustände entfernen");
        } else{
            try {
                FXMLLoader loader = new FXMLLoader();
                ResourceBundle bundle = I18nUtil.getDialogResourceBundle();
                loader.setLocation(MainApp.class
                        .getResource(FXKonstanten.PFAD_BEABREITUNGSZUSTAND_ERSTELLUNGSDIALOG_LAYOUT));
                loader.setResources(bundle);
                BorderPane borderPane = (BorderPane) loader.load();

                Scene scene = new Scene(borderPane);
                this.dialogStage = new Stage();
                this.dialogStage.setScene(scene);
                DialogController controller = loader.getController();
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
    }



    /**
     * Zeigt einen Dialog zur Erstellung einer neuen Notiz
     */
    @FXML
    private void handleshowNotizErstellungsMaske() {
        Notiz tmpNotiz = new NotizImpl();

        //TODO: i18n
        if(mainApp.getNotizListe().size() == FXKonstanten.maxAnzahlNotizen){
            FXUtil.showZuVieleElementeWarningDialog("Zu viele Notizen","Bitte bestehende Notizen entfernen");
        } else{
            try {
                FXMLLoader loader = new FXMLLoader();
                ResourceBundle bundle = I18nUtil.getDialogResourceBundle();
                loader.setLocation(MainApp.class
                        .getResource(FXKonstanten.PFAD_NOTIZ_ERSTELLUNGSDIALOG_LAYOUT));
                loader.setResources(bundle);
                BorderPane borderPane = (BorderPane) loader.load();

                Scene scene = new Scene(borderPane);
                this.dialogStage = new Stage();
                this.dialogStage.setScene(scene);
                DialogController controller = loader.getController();
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
    }

    /**
     * Zeigt einen Dialog zum Verändern einer bestehenden Kategorie
     */
    @FXML
    private void handleshowKategorieAenderungsMaske() {
        showDialogFensterMitAnchorPane(FXKonstanten.PFAD_KATEGORIE_AENDERUNGSDIALOG_LAYOUT);
    }


    /**
     * Zeigt einen Dialog zum Verändern eines bestehenden Bearbeitungszustands
     */
    @FXML
    private void handleshowZustandAenderungsMaske() {
        showDialogFensterMitAnchorPane(FXKonstanten.PFAD_ZUSTAND_AENDERUNGSDIALOG_LAYOUT);
    }


    /**
     * Zeigt einen Dialog zum Verändern einer bestehenden Notiz
     */
    @FXML
    private void handleshowNotizAenderungsMaske() {
        showDialogFensterMitAnchorPane(FXKonstanten.PFAD_NOTIZ_AENDERUNGSDIALOG_LAYOUT);
    }


    /**
     * Hilft dabei, neue Dialogfenster unter Angabe einer fxml-Datei zu erstellen und anzuzeigen
     *
     * @param fxmlPfad Pfad zur fxml-Datei
     */
    private void showDialogFensterMitAnchorPane(String fxmlPfad){
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
            DialogController controller = loader.getController();
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
//    @FXML
//    private void handleExit() {
//        System.exit(0);
//    }

}