package notizverwaltung.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import notizverwaltung.MainApp;
import notizverwaltung.builders.ModelObjectBuilder;
import notizverwaltung.builders.ServiceObjectBuilder;
import notizverwaltung.constants.DAOKonstanten;
import notizverwaltung.i18n.I18nMessagesUtil;
import notizverwaltung.model.interfaces.*;
import notizverwaltung.service.interfaces.*;
import notizverwaltung.util.DateUtil;
import notizverwaltung.util.FXUtil;
import notizverwaltung.validators.ObjectValidator;
import notizverwaltung.validators.StringValidator;

import java.time.LocalDate;

public class ErstellungsDialogController {
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
            bearbeitungszustandFXChoiceBox.getItems().addAll(mainApp.getBearbeitungszustandFXListe());
        }
        if(!ObjectValidator.isObjectNull(kategorieFXChoiceBox)){
            kategorieFXChoiceBox.getItems().addAll(mainApp.getKategorieFXListe());
        }
        if(!ObjectValidator.isObjectNull(notizFXChoiceBox)){
            notizFXChoiceBox.getItems().addAll(mainApp.getNotizFXListe());
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

        if (FXUtil.isInputValid(validateNotizErstellen())) {
            Notiz tmpNotiz = ModelObjectBuilder.getNotizObject();

            LocalDate faelligkeit = notizFaelligkeitDatePicker.getValue();
            int kategorieID = kategorieFXChoiceBox.getValue().getKategorieID().getValue();
            int zustandID = bearbeitungszustandFXChoiceBox.getValue().getBearbeitungsZustandID().getValue();

            tmpNotiz.setTitle(notizNameField.getText());
            tmpNotiz.setBeschreibung(notizBeschreibungTextArea.getText());
            tmpNotiz.setBearbeitungszustandID(zustandID);
            tmpNotiz.setKategorieID(kategorieID);
            tmpNotiz.setPrioritaet(notizPrioritaetCheckBox.isSelected());
            tmpNotiz.setFaelligkeit(DateUtil.convertLocalDateInDate(faelligkeit));

            notizService.addNotiz(tmpNotiz,DAOKonstanten.STANDARD_NOTIZBLOCK_ID);

            NotizFX tmpNotizFX = notizFXService.wrapNotiz(tmpNotiz);
            mainApp.getNotizFXListe().add(tmpNotizFX);

            System.out.println("Notiz erfolgreich in Liste eingefügt und in DB geschrieben:" + mainApp.getNotizFXListe());
            System.out.println("ID der erstellten Notiz:" + tmpNotiz.getNotizID() +"und FX: " + tmpNotizFX.getNotizID() );
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

        if (FXUtil.isInputValid(validateKategorieErstellen())) {

            Kategorie tmpKategorie = ModelObjectBuilder.getKategorieObjekt(kategorieNameField.getText());
            kategorieService.addKategorie(tmpKategorie);

            KategorieFX tmpKategorieFX = kategorieFXService.wrapKategorie(tmpKategorie);
            mainApp.getKategorieFXListe().add(tmpKategorieFX);

            System.out.println("Kategorie erfolgreich in Liste und in Datenbank eingefügt"+ mainApp.getKategorieFXListe());
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

        if (FXUtil.isInputValid(validateBearbeitungszustandErstellen())) {
            Bearbeitungszustand tmpZustand = ModelObjectBuilder
                    .getBearbeitungszustandObjekt(bearbeitungszustandNameField.getText());


            bearbeitungszustandService.addBearbeitungszustand(tmpZustand);

            BearbeitungszustandFX tmpZustandFX = bearbeitungszustandFXService.wrapBearbeitungszustand(tmpZustand);
            mainApp.getBearbeitungszustandFXListe().add(tmpZustandFX);

            System.out.println("Bearbeitungszustand in Liste und in Datenbank eingefügt"+ mainApp.getBearbeitungszustandFXListe());
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

        KategorieFX kategorieFX = kategorieFXChoiceBox.getValue();

        BearbeitungszustandFX bearbeitungszustandFX = bearbeitungszustandFXChoiceBox.getValue();

        String beschreibung = notizBeschreibungTextArea.getText();
        LocalDate localDateFaelligkeit = notizFaelligkeitDatePicker.getValue();

        String errorMessage = "";

        if (StringValidator.isStringLeerOderNull(notizName)) {
            errorMessage += I18nMessagesUtil.getErrorNotiznameUngueltig() + "\n";
        }
        if (ObjectValidator.isObjectNull(kategorieFX)) {
            errorMessage += I18nMessagesUtil.getErrorBestehendeKategorieUngueltig() + "\n";
        }
        if (ObjectValidator.isObjectNull(bearbeitungszustandFX)) {
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
        ObservableList<KategorieFX> guiKategorieListe = mainApp.getKategorieFXListe();
        String kategorieName = kategorieNameField.getText();

        String errorMessage = "";

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
     * Validiert die Eingabefelder fuer die Eingabe zur Erstellung eines Bearbeitungszustands.
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     */
    private String validateBearbeitungszustandErstellen() {
        ObservableList<BearbeitungszustandFX> guiZustandListe = mainApp.getBearbeitungszustandFXListe();
        String bearbeitungszustandName = bearbeitungszustandNameField.getText();

        String errorMessage = "";

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




}
