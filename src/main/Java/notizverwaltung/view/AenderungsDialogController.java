package notizverwaltung.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import notizverwaltung.MainApp;
import notizverwaltung.builders.ServiceObjectBuilder;
import notizverwaltung.i18n.I18nMessagesUtil;
import notizverwaltung.model.interfaces.*;
import notizverwaltung.service.interfaces.*;
import notizverwaltung.util.DateUtil;
import notizverwaltung.util.FXUtil;
import notizverwaltung.validators.ObjectValidator;
import notizverwaltung.validators.StringValidator;

import java.time.LocalDate;
import java.util.Date;

/**
 * Stellt Funktionalität für die Dialog-Fenster zur Verfügung, welche
 * bestehende Kategorien/Notizen/Bearbeitungszustände verändern.
 *
 * Dabei werden Nutzereingaben überprüft.
 *
 *
 *
 * @author Michelle Blau
 * @version 29.09.2018
 */

public class AenderungsDialogController {

    private MainApp mainApp;
    private Stage dialogStage;

    private NotizService notizService = ServiceObjectBuilder.getNotizService();
    private KategorieService kategorieService = ServiceObjectBuilder.getKategorieService();
    private BearbeitungszustandService bearbeitungszustandService = ServiceObjectBuilder.getBearbeitungszustandService();
    private NotizFXService notizFXService = ServiceObjectBuilder.getNotizFXService();
    private KategorieFXService kategorieFXService = ServiceObjectBuilder.getKategorieFXService();
    private BearbeitungszustandFXService bearbeitungszustandFXService = ServiceObjectBuilder.getBearbeitungszustandFXService();


    //_______________Notiz_____________//
    @FXML
    TextField notizNameField;

    @FXML
    TextArea notizBeschreibungTextArea;

    @FXML
    DatePicker notizFaelligkeitDatePicker;

    @FXML
    CheckBox notizPrioritaetCheckBox;

    //_______________Choice-Boxen__________________//
    @FXML
    ChoiceBox<KategorieFX> kategorieFXChoiceBox;

    @FXML
    ChoiceBox<BearbeitungszustandFX> bearbeitungszustandFXChoiceBox;

    @FXML
    ChoiceBox<NotizFX> notizFXChoiceBox;

    //_______________Kategorie______________//
    @FXML
    TextField kategorieNameField;

    //_______________Bearbeitungszustand______________//
    @FXML
    TextField bearbeitungszustandNameField;


    /**
     * Setzt Referenz auf das Hauptprogramm, initialisiert anschließend ChoiceBoxen, falls diese vorhanden sind
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        if(!ObjectValidator.isObjectNull(bearbeitungszustandFXChoiceBox)){
            bearbeitungszustandFXChoiceBox.setItems(mainApp.getBearbeitungszustandFXListe());
        }
        if(!ObjectValidator.isObjectNull(kategorieFXChoiceBox)){
            kategorieFXChoiceBox.setItems(mainApp.getKategorieFXListe());
        }
        if(!ObjectValidator.isObjectNull(notizFXChoiceBox)){
            notizFXChoiceBox.setItems(mainApp.getNotizFXListe());

            notizFXChoiceBox.getSelectionModel()
                    .selectedIndexProperty()
                    .addListener(getNotizChoiceBoxListener());
        }
    }


    /**
     * Setzt Referenz auf die aufgerufene dialogStage, also das geöffnete Dialogfenster
     *
     * @param dialogStage
     */
    public void setDialogStage (Stage dialogStage){
        this.dialogStage = dialogStage;

    }


    /**
     * Schließt Stage/Dialogfenster beim Klicken auf den "Abbrechen" Button
     */
    @FXML
    private void handleBtnCancel(){
        this.dialogStage.close();
    }


    /**
     * Ändert bestehende Notiz, wenn auf "Anwenden" Button geklickt wird, oder ruft Error-Dialog auf, wenn
     * Nutzereingaben falsch. Die Änderung wird direkt in die Datenbank übernommen
     *
     */
    @FXML
    private void handleBtnAendereNotiz(){

        if (FXUtil.isInputValid(validateNotizAendern())) {

            NotizFX zuAenderndeNotizFX = notizFXChoiceBox.getValue();
            String neuerName = notizNameField.getText();

            KategorieFX kategorieFX = kategorieFXChoiceBox.getValue();
            Kategorie neueKategorie = kategorieFXService.unwrapKategorieFX(kategorieFX);

            String neueBeschreibung = notizBeschreibungTextArea.getText();
            LocalDate neueFaelligkeit = notizFaelligkeitDatePicker.getValue();
            boolean neuePrioritaet = notizPrioritaetCheckBox.isSelected();

            zuAenderndeNotizFX.setTitle(neuerName);
            zuAenderndeNotizFX.setKategorieID(neueKategorie.getKategorieID());
            zuAenderndeNotizFX.setBeschreibung(neueBeschreibung);
            zuAenderndeNotizFX.setFaelligkeit(DateUtil.convertLocalDateInDate(neueFaelligkeit));
            zuAenderndeNotizFX.setPrioritaet(neuePrioritaet);

            notizService.updateNotiz(notizFXService.unwrapNotizFX(zuAenderndeNotizFX));

            dialogStage.close();
        }
    }



    /**
     * Ändert bestehende Kategorie, wenn auf "Anwenden" Button geklickt wird, oder ruft Error-Dialog auf, wenn
     * Nutzereingaben falsch. Die Änderung wird direkt in die Datenbank übernommen
     */
    @FXML
    private void handleBtnAendereKategorie(){
        if (FXUtil.isInputValid(validateKategorieAendern())) {

            KategorieFX zuAenderndeKategorieFX = kategorieFXChoiceBox.getValue();

            String neuerName = kategorieNameField.getText();

            zuAenderndeKategorieFX.setKategorieName(neuerName);

            Kategorie zuAenderndeKategorie = kategorieFXService.unwrapKategorieFX(zuAenderndeKategorieFX);
            kategorieService.updateKategorie(zuAenderndeKategorie);

            dialogStage.close();
        }
    }



    /**
     * Ändert bestehenden Bearbeitungszustand, wenn auf "Anwenden" Button geklickt wird, oder ruft Error-Dialog auf, wenn
     * Nutzereingaben falsch
     */
    @FXML
    private void handleBtnAendereBearbeitungszustand(){

        if (FXUtil.isInputValid(validateBearbeitungszustandAendern())) {

            BearbeitungszustandFX zuAendernderZustandFX = bearbeitungszustandFXChoiceBox.getValue();

            String neuerName = bearbeitungszustandNameField.getText();
            zuAendernderZustandFX.setName(neuerName);

            Bearbeitungszustand zuAendernderZustand = bearbeitungszustandFXService.unwrapBearbeitungszustandFX(zuAendernderZustandFX);

            bearbeitungszustandService.updateBearbeitungszustand(zuAendernderZustand);

            dialogStage.close();
        }
    }



    /**
     * Validiert die Eingabefelder fuer die Änderung einer Notiz.
     *
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     */
    private String validateNotizAendern(){
        NotizFX bestehendeNotizFX = notizFXChoiceBox.getValue();
        String notizName = notizNameField.getText();

        KategorieFX kategorieFX = kategorieFXChoiceBox.getValue();

        String beschreibung = notizBeschreibungTextArea.getText();

        LocalDate localDateFaelligkeit = notizFaelligkeitDatePicker.getValue();

        String errorMessage = "";

        if (ObjectValidator.isObjectNull(bestehendeNotizFX)) {
            errorMessage += I18nMessagesUtil.getErrorBestehendeNotizUngueltig() + "\n";
        }
        if (StringValidator.isStringLeerOderNull(notizName)) {
            errorMessage += I18nMessagesUtil.getErrorNotiznameUngueltig() + "\n";
        }
        if (ObjectValidator.isObjectNull(kategorieFX)) {
            errorMessage += I18nMessagesUtil.getErrorBestehendeKategorieUngueltig() + "\n";
        }
        if (StringValidator.isStringLeerOderNull(beschreibung)) {
            errorMessage += I18nMessagesUtil.getErrorNotizbeschreibungUngueltig() + "\n";
        }
        if (ObjectValidator.isObjectNull(localDateFaelligkeit)) {
            errorMessage += I18nMessagesUtil.getErrorNotizFaelligkeitUngueltig() + "\n";
        }

        return errorMessage;
    }



    /**
     * Validiert die Eingabefelder zur Änderung einer bestehenden Kategorie.
     *
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     */
    private String validateKategorieAendern() {
        ObservableList<KategorieFX> guiKategorieListe = mainApp.getKategorieFXListe();
        String kategorieName = kategorieNameField.getText();
        KategorieFX bestehendeKategorieFX = kategorieFXChoiceBox.getValue();

        String errorMessage = "";

        if(ObjectValidator.isObjectNull(bestehendeKategorieFX)){
            errorMessage += I18nMessagesUtil.getErrorBestehendeKategorieUngueltig() + "\n";
        }
        if (StringValidator.isStringLeerOderNull(kategorieName)) {
            errorMessage += I18nMessagesUtil.getErrorKategorienameUngueltig() + "\n";
        }else{
            if(FXUtil.isKategorieNameInListe(kategorieName, guiKategorieListe)){
                errorMessage += I18nMessagesUtil.getErrorKategorienameVorhanden() + "\n";
            }
            if(StringValidator.isSonderzeichenVorhanden(kategorieName)){
                errorMessage += I18nMessagesUtil.getErrorSonderzeichenVorhanden() + "\n";
            }
        }

        return errorMessage;
    }



    /**
     * Validiert die Eingabefelder zur Änderung eines Bearbeitungszustands.
     *
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     */
    private String validateBearbeitungszustandAendern() {

        ObservableList<BearbeitungszustandFX> guiZustandListe = mainApp.getBearbeitungszustandFXListe();
        String bearbeitungszustandName = bearbeitungszustandNameField.getText();
        BearbeitungszustandFX bestehenderZustandFX = bearbeitungszustandFXChoiceBox.getValue();
        String errorMessage = "";

        if(ObjectValidator.isObjectNull(bestehenderZustandFX)){
            errorMessage += I18nMessagesUtil.getErrorBestehenderBearbeitungszustandUngueltig() + "\n";
        }
        if (StringValidator.isStringLeerOderNull(bearbeitungszustandName)) {
            errorMessage += I18nMessagesUtil.getErrorBearbeitungszustandnameUngueltig() + "\n";
        }else{
            if(FXUtil.isZustandNameInListe(bearbeitungszustandName, guiZustandListe)){
                errorMessage += I18nMessagesUtil.getErrorBearbeitungszustandnameVorhanden() + "\n";
            }
            if(StringValidator.isSonderzeichenVorhanden(bearbeitungszustandName)){
                errorMessage += I18nMessagesUtil.getErrorSonderzeichenVorhanden() + "\n";
            }
        }

        return errorMessage;
    }


    /**
     * Erstellt einen ChangeListener:
     * Bei Wahl einer Notiz in der Choice-Box werden die Attribute der Notiz
     * in der GUI sichtbar gemacht.
     *
     * @return lambda - Schreibt die Attribute der gewählten Notiz in die GUI
     */
    private ChangeListener<Number> getNotizChoiceBoxListener(){

        ChangeListener<Number> lambda = new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                int aktuelleAuswahl = (Integer) newValue;

                NotizFX gewaehlteNotizFX = notizFXChoiceBox.getItems().get(aktuelleAuswahl);
                Date notizFaelligkeit = gewaehlteNotizFX.getFaelligkeit().getValue();

                int tmpKategorieID = gewaehlteNotizFX.getKategorieID().getValue();
                Kategorie tmpKategorie = kategorieService.getKategorie(tmpKategorieID);


                notizNameField.setText(gewaehlteNotizFX.getTitle().getValue());
                notizBeschreibungTextArea.setText(gewaehlteNotizFX.getBeschreibung().getValue());
                KategorieFX kategorieFX = kategorieFXService.wrapKategorie(tmpKategorie);
                kategorieFXChoiceBox.setValue(kategorieFX);
                notizFaelligkeitDatePicker.setValue(DateUtil.convertDateInLocalDate(notizFaelligkeit));
                notizPrioritaetCheckBox.setSelected(gewaehlteNotizFX.getPrioritaet().getValue());

            }
        };

        return lambda;
    }

}
