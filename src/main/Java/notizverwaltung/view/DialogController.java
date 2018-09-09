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
import notizverwaltung.validators.StringValidator;

import java.time.LocalDate;
import java.util.Date;

import static notizverwaltung.util.DateUtil.convertLocalDate;

/**
 * Stellt Funktionalität für die Dialog-Fenster der GUI zur Verfügung, verwendet die "-dialog.fxml" Dateien
 * TODO Dialog-fxml-Dateien in eigenen Ordner packen für bessere Übersicht
 *
 * @author Michelle Blau
 * @version 08.09.2018
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
    TextField BearbeitungszustandNameField;


    /**
     * Setzt Referenz auf das Hauptprogramm, initialisiert anschließend ChoiceBoxen, falls diese vorhanden sind
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        if(bearbeitungszustandChoiceBox != null){
            bearbeitungszustandChoiceBox.getItems().addAll(mainApp.getBearbeitungszustandListe());
        }
        if(kategorieChoiceBox != null){
            kategorieChoiceBox.getItems().addAll(mainApp.getKategorieListe());
        }
    }

    /**
     * //TODO: kommentar
     * @param dialogStage
     */
    public void setDialogStage (Stage dialogStage){
        this.dialogStage = dialogStage;

    }


    /**
     * Schließt Stage beim Klicken auf den "Abbrechen" Button
     */
    @FXML
    private void handleBtnCancel(){
        this.dialogStage.close();
    }


    /**
     * Erstellt neue Notiz, wenn auf "Hinzufügen" Button geklickt wird, oder ruft Error-Dialog auf, wenn
     * Nutzereingaben falsch
     */
    @FXML
    private void handleBtnErstelleNotiz(){
        Notiz tmpNotiz = new NotizImpl();
        if (isInputValid()) {
            tmpNotiz.setTitle(notizNameField.getText());
            tmpNotiz.setBeschreibung(notizBeschreibungTextArea.getText());
            mainApp.getNotizListe().add(tmpNotiz);

            System.out.println("Notiz erfolgreich in Liste eingefügt");
            dialogStage.close();
        }
    }


    @FXML
    private void handleBtnApply() {

    }


    /**
     * Validiert die eingegebenen Daten.
     *
     * @return true wenn die Nutzer-Eingabe gueltig ist, sonst false.
     */
    private boolean isInputValid() {
        String errorMessage = validateNotiz();

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



    /** //TODO fertig schreiben
     * Validiert die Eingabefelder fuer die Eingabe einer Notiz.
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     */
    private String validateNotiz() {
        String notizname = notizNameField.getText();
        Kategorie kategorie = kategorieChoiceBox.getValue();
        Bearbeitungszustand bearbeitungszustand = bearbeitungszustandChoiceBox.getValue();
        String beschreibung = notizBeschreibungTextArea.getText();
        LocalDate localDateFaelligkeit = notizFaelligkeitDatePicker.getValue();
        Date dateFaelligkeit = convertLocalDate(localDateFaelligkeit);

        String errorMessage = "";

        if (StringValidator.isStringLeerOderNull(notizname)) {
            errorMessage += I18nMessagesUtil.getErrorNotiznameUngueltig() + "\n";
        }
        if (StringValidator.isStringLeerOderNull(beschreibung)) {
            errorMessage += I18nMessagesUtil.getErrorNotizbeschreibungUngueltig() + "\n";
        }
//        if (PersonValidator.isStreetEmpty(street)) {
//            errorMessage += I18nMessagesUtil.getErrorNoValidStreetString() + "\n";
//        }
//
//        if (StringValidator.isStringLeerOderNull(beschreibung)) {
//            errorMessage += I18nMessagesUtil.getErrorNoValidZipString() + "\n";
//        }

        return errorMessage;
    }
}
