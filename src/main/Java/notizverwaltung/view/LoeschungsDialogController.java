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

public class LoeschungsDialogController {
    private MainApp mainApp;
    private Stage dialogStage;

    private NotizService notizService = ServiceObjectBuilder.getNotizService();
    private KategorieService kategorieService = ServiceObjectBuilder.getKategorieService();
    private BearbeitungszustandService bearbeitungszustandService = ServiceObjectBuilder.getBearbeitungszustandService();


    //_______________Choice-Boxen__________________//
    @FXML
    ChoiceBox<Kategorie> kategorieChoiceBox;

    @FXML
    ChoiceBox<Bearbeitungszustand> bearbeitungszustandChoiceBox;

    @FXML
    ChoiceBox<Notiz> notizChoiceBox;



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
     * Löscht bestehende Kategorie, wenn auf "Löschen" Button geklickt wird, oder ruft Error-Dialog auf, wenn
     * Nutzereingaben falsch. Die Änderung wird direkt in die Datenbank übernommen
     *
     */
    @FXML
    private void handleBtnLoescheKategorie(){

        if (isInputValid(validateKategorieLoeschen())) {
            Kategorie zuLoeschendeKategorie = kategorieChoiceBox.getValue();

            mainApp.getKategorieListe().remove(zuLoeschendeKategorie);
            kategorieService.deleteKategorie(zuLoeschendeKategorie.getKategorieID());

            System.out.println("Kategorie wurde aus Liste und Datenbank gelöscht:" + mainApp.getKategorieListe());
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
     * Validiert die Eingabefelder zum Löschen einer bestehenden Kategorie.
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     *
     */
    private String validateKategorieLoeschen() {
        Kategorie bestehendeKategorie = kategorieChoiceBox.getValue();

        String errorMessage = "";

        if(ObjectValidator.isObjectNull(bestehendeKategorie)){
            errorMessage += I18nMessagesUtil.getErrorBestehendeKategorieUngueltig() + "\n";

        }else if(DaoContentValidator.isNotizMitKategorieVorhanden(bestehendeKategorie)){
            errorMessage += I18nMessagesUtil.getErrorEsGibtNochNotizenMitDieserKategorie() + "\n";
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

        }else if (DaoContentValidator.isNotizMitBearbeitungszustandVorhanden(bestehenderBearbeitungszustand)) {
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
