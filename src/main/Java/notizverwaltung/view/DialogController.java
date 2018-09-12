package notizverwaltung.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import notizverwaltung.MainApp;
import notizverwaltung.builders.ModelObjectBuilder;
import notizverwaltung.constants.DAOKonstanten;
import notizverwaltung.i18n.I18nMessagesUtil;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.classes.BearbeitungszustandServiceImpl;
import notizverwaltung.service.classes.KategorieServiceImpl;
import notizverwaltung.service.classes.NotizServiceImpl;
import notizverwaltung.service.interfaces.BearbeitungszustandService;
import notizverwaltung.service.interfaces.KategorieService;
import notizverwaltung.service.interfaces.NotizService;
import notizverwaltung.util.DateUtil;
import notizverwaltung.util.FXUtil;
import notizverwaltung.validators.ListValidator;
import notizverwaltung.validators.ObjectValidator;
import notizverwaltung.validators.StringValidator;

import java.time.LocalDate;

/**
 * Stellt Funktionalität für die Dialog-Fenster zur Verfügung, welche Kategorien/Notizen/Bearbeitungszustände erzeugen/ändern/löschen
 *  TODO falls Zeit, den DialogController in mehrere Controller-Klassen aufteilen... aber nur am Ende des Projekts
 *  TODO System.out.printlns rausnehmen, sobald fertig geschrieben und getestet
 *
 * @author Michelle Blau
 * @version 12.09.2018
 */

public class DialogController {

    private MainApp mainApp;
    private Stage dialogStage;

    private NotizService notizService = new NotizServiceImpl();
    private KategorieService kategorieService = new KategorieServiceImpl();
    private BearbeitungszustandService bearbeitungszustandService = new BearbeitungszustandServiceImpl();


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
    ChoiceBox<Kategorie> kategorieChoiceBox;

    @FXML
    ChoiceBox<Bearbeitungszustand> bearbeitungszustandChoiceBox;

    @FXML
    ChoiceBox<Notiz> notizChoiceBox;

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
        if(!ObjectValidator.isObjectNull(bearbeitungszustandChoiceBox)){
            bearbeitungszustandChoiceBox.getItems().addAll(mainApp.getBearbeitungszustandListe());
        }
        if(!ObjectValidator.isObjectNull(kategorieChoiceBox)){
            kategorieChoiceBox.getItems().addAll(mainApp.getKategorieListe());
        }
        if(!ObjectValidator.isObjectNull(notizChoiceBox)){
            notizChoiceBox.getItems().addAll(mainApp.getNotizListe());
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
     * Nutzereingaben falsch. Die Notiz wird direkt in die Datenbank übernommen.
     *
     */
    @FXML
    private void handleBtnErstelleNotiz(){

        if (isInputValid(validateNotizErstellen())) {
            Notiz tmpNotiz = ModelObjectBuilder.getNotizObject();

            LocalDate faelligkeit = notizFaelligkeitDatePicker.getValue();

            tmpNotiz.setTitle(notizNameField.getText());
            tmpNotiz.setBeschreibung(notizBeschreibungTextArea.getText());
            tmpNotiz.setBearbeitungszustandID(bearbeitungszustandChoiceBox.getValue().getBearbeitungsZustandID());
            tmpNotiz.setKategorieID(kategorieChoiceBox.getValue().getKategorieID());
            tmpNotiz.setPrioritaet(notizPrioritaetCheckBox.isSelected());
            tmpNotiz.setFaelligkeit(DateUtil.convertLocalDate(faelligkeit));

            notizService.addNotiz(tmpNotiz,DAOKonstanten.DEFAULT_NOTIZBLOCK_ID);
            mainApp.getNotizListe().add(tmpNotiz);

            System.out.println("Notiz erfolgreich in Liste eingefügt und in DB geschrieben:" + mainApp.getNotizListe());
            dialogStage.close();
        }
    }

    /**
     * Löscht bestehende Notiz, wenn auf "Löschen" Button geklickt wird, oder ruft Error-Dialog auf, wenn
     * Nutzereingaben falsch. Die Änderung wird direkt in die Datenbank übernommen
     *
     */
    @FXML
    private void handleBtnLoescheNotiz(){

        if (isInputValid(validateNotizLoeschen())) {
            Notiz zuLoeschendeNotiz = notizChoiceBox.getValue();

            mainApp.getNotizListe().remove(zuLoeschendeNotiz);
            notizService.deleteNotiz(zuLoeschendeNotiz.getNotizID());

            System.out.println("Notiz wurde aus Liste und Datenbank gelöscht:" + mainApp.getNotizListe());
            dialogStage.close();
        }
    }

    /**
     * Ändert bestehende Notiz, wenn auf "Anwenden" Button geklickt wird, oder ruft Error-Dialog auf, wenn
     * Nutzereingaben falsch. Die Änderung wird direkt in die Datenbank übernommen
     * TODO Fertigschreiben, sobald Datenbank funktioniert
     */
    @FXML
    private void handleBtnAendereNotiz(){

        if (isInputValid(validateNotizAendern())) {

            System.out.println("Notiz wurde nicht geändert, muss noch implementiert werden");
            dialogStage.close();
        }
    }



    /**
     * Erstellt neue Kategorie, wenn auf "Hinzufügen" Button geklickt wird, oder ruft Error-Dialog auf, wenn
     * Nutzereingaben falsch. Die Kategorie wird direkt in die Datenbank übernommen.
     *
     */
    @FXML
    private void handleBtnErstelleKategorie(){

        if (isInputValid(validateKategorieErstellen())) {

            Kategorie tmpKategorie = ModelObjectBuilder.getKategorieObjekt(kategorieNameField.getText());

            kategorieService.addKategorie(tmpKategorie);
            mainApp.getKategorieListe().add(tmpKategorie);

            System.out.println("Kategorie erfolgreich in Liste und in Datenbank eingefügt"+ mainApp.getKategorieListe());
            dialogStage.close();
        }
    }

    /**
     * Ändert bestehende Kategorie, wenn auf "Anwenden" Button geklickt wird, oder ruft Error-Dialog auf, wenn
     * Nutzereingaben falsch. Die Änderung wird direkt in die Datenbank übernommen
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
     * Löscht bestehende Kategorie, wenn auf "Löschen" Button geklickt wird, oder ruft Error-Dialog auf, wenn
     * Nutzereingaben falsch. Die Änderung wird direkt in die Datenbank übernommen
     *
     */
    @FXML
    private void handleBtnLoescheKategorie(){

        if (isInputValid(validateKategorieLoeschen())) {
            Kategorie zuLoeschendeKategorie = kategorieChoiceBox.getValue();

            mainApp.getNotizListe().remove(zuLoeschendeKategorie);
            kategorieService.deleteKategorie(zuLoeschendeKategorie.getKategorieID());

            System.out.println("Kategorie wurde aus Liste und Datenbank gelöscht:" + mainApp.getKategorieListe());
            dialogStage.close();
        }
    }




    /**
     * Erstellt neuen Bearbeitungszustand, wenn auf "Hinzufügen" Button geklickt wird, oder ruft Error-Dialog auf, wenn
     * Nutzereingaben falsch. Der Bearbeitungszustand wird direkt in die Datenbank übernommen.
     *
     */
    @FXML
    private void handleBtnErstelleBearbeitungszustand(){

        if (isInputValid(validateBearbeitungszustandErstellen())) {
            Bearbeitungszustand tmpBearbeitungszustand = ModelObjectBuilder
                    .getBearbeitungszustandObjekt(bearbeitungszustandNameField.getText());


            bearbeitungszustandService.addBearbeitungszustand(tmpBearbeitungszustand);
            mainApp.getBearbeitungszustandListe().add(tmpBearbeitungszustand);

            System.out.println("Bearbeitungszustand in Liste und in Datenbank eingefügt"+ mainApp.getBearbeitungszustandListe());
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
     * Löscht bestehenden Bearbeitungszustand, wenn auf "Löschen" Button geklickt wird, oder ruft Error-Dialog auf, wenn
     * Nutzereingaben falsch
     */
    @FXML
    private void handleBtnLoescheBearbeitungszustand(){

        if (isInputValid(validateBearbeitungszustandLoeschen())) {
            Bearbeitungszustand bestehenderBearbeitungszustand = bearbeitungszustandChoiceBox.getValue();
            int bearbeitungszustandID = bestehenderBearbeitungszustand.getBearbeitungsZustandID();

            mainApp.getBearbeitungszustandListe().remove(bestehenderBearbeitungszustand);
            bearbeitungszustandService.deleteBearbeitungszustand(bearbeitungszustandID);

            System.out.println("Bearbeitungszustand wurde in Liste und Datenbank gelöscht:" + mainApp.getBearbeitungszustandListe());
            dialogStage.close();
        }
    }



    /**
     * Validiert die Eingabefelder fuer die Eingabe zur Erstellung einer Notiz.
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     *
     */
    private String validateNotizErstellen() {
        String notizName = notizNameField.getText();
        Kategorie kategorie = kategorieChoiceBox.getValue();
        Bearbeitungszustand bearbeitungszustand = bearbeitungszustandChoiceBox.getValue();
        String beschreibung = notizBeschreibungTextArea.getText();
        LocalDate localDateFaelligkeit = notizFaelligkeitDatePicker.getValue();

        String errorMessage = "";

        if (StringValidator.isStringLeerOderNull(notizName)) {
            errorMessage += I18nMessagesUtil.getErrorNotiznameUngueltig() + "\n";
        }
        if (ObjectValidator.isObjectNull(kategorie)) {
            errorMessage += I18nMessagesUtil.getErrorBestehendeKategorieUngueltig() + "\n";
        }
        if (ObjectValidator.isObjectNull(bearbeitungszustand)) {
            errorMessage += I18nMessagesUtil.getErrorBestehenderBearbeitungszustandUngueltig() + "\n";
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
     * Validiert die Eingabefelder fuer die Änderung einer Notiz.
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     *
     */
    private String validateNotizAendern(){
        Notiz bestehendeNotiz = notizChoiceBox.getValue();
        String notizName = notizNameField.getText();
        Kategorie kategorie = kategorieChoiceBox.getValue();
        String beschreibung = notizBeschreibungTextArea.getText();
        LocalDate localDateFaelligkeit = notizFaelligkeitDatePicker.getValue();

        String errorMessage = "";

        if (ObjectValidator.isObjectNull(bestehendeNotiz)) {
            errorMessage += I18nMessagesUtil.getErrorBestehendeNotizUngueltig() + "\n";
        }
        if (StringValidator.isStringLeerOderNull(notizName)) {
            errorMessage += I18nMessagesUtil.getErrorNotiznameUngueltig() + "\n";
        }
        if (ObjectValidator.isObjectNull(kategorie)) {
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
     * Validiert die Eingabefelder fuer die Änderung einer Notiz.
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     *
     */
    private String validateNotizLoeschen(){
        Notiz bestehendeNotiz = notizChoiceBox.getValue();

        String errorMessage = "";

        if (ObjectValidator.isObjectNull(bestehendeNotiz)) {
            errorMessage += I18nMessagesUtil.getErrorBestehendeNotizUngueltig() + "\n";
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
        String kategorieName = kategorieNameField.getText();

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
        String kategorieName = kategorieNameField.getText();
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
     * Validiert die Eingabefelder zum Löschen einer bestehenden Kategorie.
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     * TODO isNotizMitKategorieVorhanden() fertigstellen sobald Service-Methode implementiert
     */
    private String validateKategorieLoeschen() {
        Kategorie bestehendeKategorie = kategorieChoiceBox.getValue();

        String errorMessage = "";

        if(ObjectValidator.isObjectNull(bestehendeKategorie)){
            errorMessage += I18nMessagesUtil.getErrorBestehendeKategorieUngueltig() + "\n";
        }else if(ListValidator.isNotizMitKategorieVorhanden(bestehendeKategorie)){
            errorMessage += I18nMessagesUtil.getErrorEsGibtNochNotizenMitDieserKategorie() + "\n";
        }

        return errorMessage;
    }




    /**
     * Validiert die Eingabefelder fuer die Eingabe zur Erstellung eines Bearbeitungszustands.
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     */
    private String validateBearbeitungszustandErstellen() {
        String bearbeitungszustandName = bearbeitungszustandNameField.getText();

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

        String bearbeitungszustandName = bearbeitungszustandNameField.getText();
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
     * Validiert die Eingabefelder zur Änderung eines Bearbeitungszustands.
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     */
    private String validateBearbeitungszustandLoeschen() {

        Bearbeitungszustand bestehenderBearbeitungszustand = bearbeitungszustandChoiceBox.getValue();

        String errorMessage = "";

        if(ObjectValidator.isObjectNull(bestehenderBearbeitungszustand)){
            errorMessage += I18nMessagesUtil.getErrorBestehenderBearbeitungszustandUngueltig() + "\n";

        }else if (ListValidator.isNotizMitBearbeitungszustandVorhanden(bestehenderBearbeitungszustand)) {
            errorMessage += I18nMessagesUtil.getErrorEsGibtNochNotizenMitDiesemBearbeitungszustand() + "\n";
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

}
