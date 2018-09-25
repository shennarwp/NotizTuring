package notizverwaltung.view;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import notizverwaltung.builders.ServiceObjectBuilder;
import notizverwaltung.constants.DAOKonstanten;
import notizverwaltung.constants.FXKonstanten;
import notizverwaltung.MainApp;
import notizverwaltung.i18n.I18nMessagesUtil;
import notizverwaltung.i18n.I18nUtil;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.model.interfaces.NotizFX;
import notizverwaltung.service.interfaces.KategorieService;
import notizverwaltung.service.interfaces.NotizFXService;
import notizverwaltung.service.interfaces.NotizService;
import notizverwaltung.util.FXUtil;
import notizverwaltung.validators.DaoContentValidator;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Diese Klasse ermöglicht das Öffnen von Dialogfenstern via Menüleiste mit vorheriger Überprüfung von DB-Inhalten
 *
 * Die Dialogfenster werden lediglich geöffnet.
 *
 * Die Klassen "ÄnderungsDialogController", "ErstellungsDialogController", "LöschungsDialogController" beinhalten
 * entsprechende Funktionalität.
 * 
 * @author Michelle Blau
 * @version 24.09.2018
 */


public class RootLayoutController {


    private KategorieService kategorieService = ServiceObjectBuilder.getKategorieService();

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

        if(DaoContentValidator.isMaximumKategorienErreicht()){
            FXUtil.showZuVieleElementeWarning(I18nMessagesUtil.getWarningZuVieleKategorien());
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

        if(DaoContentValidator.isMaximumZustaendeErreicht()){
            FXUtil.showZuVieleElementeWarning(I18nMessagesUtil.getWarningZuVieleZustaende());
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

        if(DaoContentValidator.isMaximumNotizenErreicht()){
            FXUtil.showZuVieleElementeWarning(I18nMessagesUtil.getWarningZuVieleNotizen());
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


    @FXML
    private void handleSortiereNotizenAufsteigend(){
        ObservableList<NotizFX> notizListe = mainApp.getNotizFXListe();
        System.out.println(notizListe);

        Comparator<NotizFX> comparator = new Comparator<NotizFX>() {
            @Override
            public int compare(NotizFX o1, NotizFX o2) {
                return o1.compareTo(o2);
            }
        };

        notizListe.sort(comparator);
        System.out.println(notizListe);

    }

    /**
     * Schliesst das Programm.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleSortierenDeaktivieren(){


        ObservableList<NotizFX> notizFXListe = mainApp.getNotizFXListe();

        Comparator<NotizFX> comparator = new Comparator<NotizFX>() {
            @Override
            public int compare(NotizFX o1, NotizFX o2) {
                return o1.getNotizID().get() - o2.getNotizID().get();
            }
        };

        notizFXListe.sort(comparator);

    }
}