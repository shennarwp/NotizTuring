package notizverwaltung.view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import notizverwaltung.MainApp;
import notizverwaltung.i18n.I18nMessagesUtil;
import notizverwaltung.model.classes.NotizImpl;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.util.FXUtil;
import notizverwaltung.validators.ObjectValidator;
import notizverwaltung.validators.StringValidator;

import java.time.LocalDate;
import java.util.Date;

import static notizverwaltung.util.DateUtil.convertLocalDate;

/**
 * Stellt Funktionalität für die Dialog-Fenster der GUI zur Verfügung, verwendet die "-dialog.fxml" Dateien
 * TODO Dialog-fxml-Dateien in eigenen Ordner packen für bessere Übersicht
 *
 * @author Michelle Blau
 * @version 10.09.2018
 */

public class DialogController {

    private MainApp mainApp;
    private Stage dialogStage;

//_______________Notiz anlegen______________//
    @FXML
    TextField notizNameField;

    @FXML
    ChoiceBox<Kategorie> kategorieChoiceBox;

    @FXML
    ChoiceBox<Bearbeitungszustand> bearbeitungszustandChoiceBox;

    @FXML
    TextArea notizBeschreibungTextArea;

    @FXML
    DatePicker notizFaelligkeitDatePicker;


//_______________Kategorie anlegen______________//
    @FXML
    TextField kategorieNameField;

//_______________Bearbeitungszustand anlegen______________//
    @FXML
    TextField bearbeitungszustandNameField;


    /**
     * Setzt Referenz auf das Hauptprogramm, initialisiert anschließend ChoiceBoxen, falls diese vorhanden sind
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        if(!ObjectValidator.isObjectNull(bearbeitungszustandChoiceBox)){
            bearbeitungszustandChoiceBox.getItems().addAll(mainApp.getBearbeitungszustandListe());
        }
        if(!ObjectValidator.isObjectNull(kategorieChoiceBox)){
            kategorieChoiceBox.getItems().addAll(mainApp.getKategorieListe());
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
     * Erstellt neue Notiz, wenn auf "Hinzufügen" Button geklickt wird, oder ruft Error-Dialog auf, wenn
     * Nutzereingaben falsch
     * TODO Fertigschreiben, sobald Datenbank funktioniert
     */
    @FXML
    private void handleBtnErstelleNotiz(){
        Notiz tmpNotiz = new NotizImpl();

        if (isInputValid(validateNotiz())) {

            tmpNotiz.setTitle(notizNameField.getText());
            tmpNotiz.setBeschreibung(notizBeschreibungTextArea.getText());
            mainApp.getNotizListe().add(tmpNotiz);

            System.out.println("Notiz erfolgreich in Liste eingefügt");
            dialogStage.close();
        }
    }


    /**
     * Erstellt neue Kategorie, wenn auf "Hinzufügen" Button geklickt wird, oder ruft Error-Dialog auf, wenn
     * Nutzereingaben falsch
     * TODO Fertigschreiben, sobald Datenbank funktioniert
     */
    @FXML
    private void handleBtnErstelleKategorie(){

        if (isInputValid(validateKategorie())) {

            System.out.println("Kategorie wurde nicht erstellt, muss implementiert werden");
            dialogStage.close();
        }
    }


    /**
     * Erstellt neuen Bearbeitungszustand, wenn auf "Hinzufügen" Button geklickt wird, oder ruft Error-Dialog auf, wenn
     * Nutzereingaben falsch
     * TODO Fertigschreiben, sobald Datenbank funktioniert
     */
    @FXML
    private void handleBtnErstelleBearbeitungszustand(){

        if (isInputValid(validateBearbeitungszustand())) {

            System.out.println("Bearbeitungszustand wurde nicht erstellt, muss implementiert werden");
            dialogStage.close();
        }
    }


    /**
     * Validiert die eingegebenen Daten.
     *
     * @return true wenn die Nutzer-Eingabe gueltig ist, sonst false.
     */
    private boolean isInputValid(String errorMessage) {

        if (StringValidator.isStringLeerOderNull(errorMessage)) {
            return true;
        } else {
            FXUtil.showErrorDialog(I18nMessagesUtil.
                            getErrorUngueltigeFelderString(),
                    I18nMessagesUtil.getMessageKorrigiereUngueltigeFelderString(),
                    errorMessage);

            return false;
        }
    }


    /**
     * Validiert die Eingabefelder fuer die Eingabe zur Erstellung einer Notiz.
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     */
    private String validateNotiz() {
        String notizname = notizNameField.getText();
        Kategorie kategorie = kategorieChoiceBox.getValue();
        Bearbeitungszustand bearbeitungszustand = bearbeitungszustandChoiceBox.getValue();
        String beschreibung = notizBeschreibungTextArea.getText();
        LocalDate localDateFaelligkeit = notizFaelligkeitDatePicker.getValue();

        String errorMessage = "";

        if (StringValidator.isStringLeerOderNull(notizname)) {
            errorMessage += I18nMessagesUtil.getErrorNotiznameUngueltig() + "\n";
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
     * Validiert die Eingabefelder fuer die Eingabe zur Erstellung einer Kategorie.
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     */
    private String validateKategorie() {
        String kategoriename = kategorieNameField.getText();

        String errorMessage = "";

        if (StringValidator.isStringLeerOderNull(kategoriename)) {
            errorMessage += I18nMessagesUtil.getErrorKategorienameUngueltig() + "\n";
        }

        return errorMessage;
    }

    /**
     * Validiert die Eingabefelder fuer die Eingabe zur Erstellung eines Bearbeitungszustands.
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     */
    private String validateBearbeitungszustand() {
        String bearbeitungszustandname = bearbeitungszustandNameField.getText();

        String errorMessage = "";

        if (StringValidator.isStringLeerOderNull(bearbeitungszustandname)) {
            errorMessage += I18nMessagesUtil.getErrorBearbeitungszustandnameUngueltig() + "\n";
        }

        return errorMessage;
    }


    @FXML
    private void handleBtnApply(){

    }
}
