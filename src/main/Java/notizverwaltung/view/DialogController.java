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

/**
 * Stellt Funktionalität für die Dialog-Fenster der GUI zur Verfügung, verwendet die "-dialog.fxml" Dateien
 *  //TODO falls Zeit, den DialogController in mehrere Controller-Klassen aufteilen... aber nur am Ende des Projekts
 *
 * @author Michelle Blau
 * @version 10.09.2018
 */

public class DialogController {

    private MainApp mainApp;
    private Stage dialogStage;


    //_______________Notiz_____________//
    @FXML
    TextField notizAnlegenNameField;

    @FXML
    TextArea notizAnlegenBeschreibungTextArea;

    @FXML
    DatePicker notizAnlegenFaelligkeitDatePicker;

    //_______________Choice-Boxen__________________//
    @FXML
    ChoiceBox<Kategorie> kategorieChoiceBox;

    @FXML
    ChoiceBox<Bearbeitungszustand> bearbeitungszustandChoiceBox;

//    @FXML
//    ChoiceBox<Notiz> notizChoiceBox;

    //_______________Kategorie______________//
    @FXML
    TextField kategorieAnlegenNameField;

    @FXML
    TextField kategorieAendernNameField;

    //_______________Bearbeitungszustand______________//
    @FXML
    TextField bearbeitungszustandAnlegenNameField;
    @FXML
    TextField bearbeitungszustandAendernNameField;


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
//        if(!ObjectValidator.isObjectNull(notizChoiceBox)){
//            notizChoiceBox.getItems().addAll(mainApp.getNotizListe());
//        }

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

        if (isInputValid(validateNotizErstellen())) {

            tmpNotiz.setTitle(notizAnlegenNameField.getText());
            tmpNotiz.setBeschreibung(notizAnlegenBeschreibungTextArea.getText());
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

        if (isInputValid(validateKategorieErstellen())) {

            System.out.println("Kategorie wurde nicht erstellt, muss implementiert werden");
            dialogStage.close();
        }
    }



    /**
     * Ändert bestehende Kategorie, wenn auf "Anwenden" Button geklickt wird, oder ruft Error-Dialog auf, wenn
     * Nutzereingaben falsch
     * TODO Fertigschreiben, sobald Datenbank funktioniert
     */
    @FXML
    private void handleBtnAendereKategorie(){
        if (isInputValid(validateKategorieAendern())) {

            System.out.println("Kategorie wurde nicht geändert, muss noch implementiert werden");
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

        if (isInputValid(validateBearbeitungszustandErstellen())) {

            System.out.println("Bearbeitungszustand wurde nicht erstellt, muss implementiert werden");
            dialogStage.close();
        }
    }



    /**
     * Ändert bestehenden Bearbeitungszustand, wenn auf "Anwenden" Button geklickt wird, oder ruft Error-Dialog auf, wenn
     * Nutzereingaben falsch
     * TODO Fertigschreiben, sobald Datenbank funktioniert
     */
    @FXML
    private void handleBtnAendereBearbeitungszustand(){

        if (isInputValid(validateBearbeitungszustandAendern())) {

            System.out.println("Bearbeitungszustand wurde nicht geändert, muss implementiert werden");
            dialogStage.close();
        }
    }



    /**
     * Validiert die Eingabefelder fuer die Eingabe zur Erstellung einer Notiz.
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     * TODO fertigschreiben, sobald Datenbank funktioniert
     */
    private String validateNotizErstellen() {
        String notizName = notizAnlegenNameField.getText();
        Kategorie kategorie = kategorieChoiceBox.getValue();
        Bearbeitungszustand bearbeitungszustand = bearbeitungszustandChoiceBox.getValue();
        String beschreibung = notizAnlegenBeschreibungTextArea.getText();
        LocalDate localDateFaelligkeit = notizAnlegenFaelligkeitDatePicker.getValue();

        String errorMessage = "";

        if (StringValidator.isStringLeerOderNull(notizName)) {
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
     * TODO fertigschreiben sobald Datenbank funktioniert
     */
    private String validateKategorieErstellen() {
        String kategorieName = kategorieAnlegenNameField.getText();

        String errorMessage = "";

        if (StringValidator.isStringLeerOderNull(kategorieName)) {
            errorMessage += I18nMessagesUtil.getErrorKategorienameUngueltig() + "\n";
        }

        return errorMessage;
    }



    /**
     * Validiert die Eingabefelder zur Änderung einer bestehenden Kategorie.
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     * TODO fertigstellen sobald Datenbank funktioniert
     */
    private String validateKategorieAendern() {
        String kategorieName = kategorieAendernNameField.getText();
        Kategorie bestehendeKategorie = kategorieChoiceBox.getValue();

        String errorMessage = "";

        if(ObjectValidator.isObjectNull(bestehendeKategorie)){
            errorMessage += I18nMessagesUtil.getErrorBestehendeKategorieUngueltig() + "\n";
        }
        if (StringValidator.isStringLeerOderNull(kategorieName)) {
            errorMessage += I18nMessagesUtil.getErrorKategorienameUngueltig() + "\n";
        }

        return errorMessage;
    }



    /**
     * Validiert die Eingabefelder fuer die Eingabe zur Erstellung eines Bearbeitungszustands.
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     */
    private String validateBearbeitungszustandErstellen() {
        String bearbeitungszustandName = bearbeitungszustandAnlegenNameField.getText();

        String errorMessage = "";

        if (StringValidator.isStringLeerOderNull(bearbeitungszustandName)) {
            errorMessage += I18nMessagesUtil.getErrorBearbeitungszustandnameUngueltig() + "\n";
        }

        return errorMessage;
    }



    /**
     * Validiert die Eingabefelder zur Änderung eines Bearbeitungszustands.
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     */
    private String validateBearbeitungszustandAendern() {

        String bearbeitungszustandName = bearbeitungszustandAendernNameField.getText();
        Bearbeitungszustand bestehenderBearbeitungszustand = bearbeitungszustandChoiceBox.getValue();
        String errorMessage = "";

        if(ObjectValidator.isObjectNull(bestehenderBearbeitungszustand)){
            errorMessage += I18nMessagesUtil.getErrorBestehenderBearbeitungszustandUngueltig() + "\n";
        }
        if (StringValidator.isStringLeerOderNull(bearbeitungszustandName)) {
            errorMessage += I18nMessagesUtil.getErrorBearbeitungszustandnameUngueltig() + "\n";
        }

        return errorMessage;
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


    @FXML
    private void handleBtnApply(){

    }
}
