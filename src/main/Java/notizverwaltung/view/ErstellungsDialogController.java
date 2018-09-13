package notizverwaltung.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import notizverwaltung.MainApp;
import notizverwaltung.builders.ModelObjectBuilder;
import notizverwaltung.builders.ServiceObjectBuilder;
import notizverwaltung.constants.DAOKonstanten;
import notizverwaltung.i18n.I18nMessagesUtil;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.interfaces.BearbeitungszustandService;
import notizverwaltung.service.interfaces.KategorieService;
import notizverwaltung.service.interfaces.NotizService;
import notizverwaltung.util.DateUtil;
import notizverwaltung.util.FXUtil;
import notizverwaltung.validators.DaoContentValidator;
import notizverwaltung.validators.ObjectValidator;
import notizverwaltung.validators.StringValidator;

import java.time.LocalDate;

public class ErstellungsDialogController {
    private MainApp mainApp;
    private Stage dialogStage;

    private NotizService notizService = ServiceObjectBuilder.getNotizService();
    private KategorieService kategorieService = ServiceObjectBuilder.getKategorieService();
    private BearbeitungszustandService bearbeitungszustandService = ServiceObjectBuilder.getBearbeitungszustandService();


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
     * Validiert die Eingabefelder fuer die Eingabe zur Erstellung einer Kategorie.
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     *
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