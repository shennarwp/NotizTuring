package notizverwaltung.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import notizverwaltung.MainApp;
import notizverwaltung.builders.ServiceObjectBuilder;
import notizverwaltung.i18n.I18nMessagesUtil;
import notizverwaltung.model.interfaces.*;
import notizverwaltung.service.interfaces.*;
import notizverwaltung.util.FXUtil;
import notizverwaltung.validators.DaoContentValidator;
import notizverwaltung.validators.ObjectValidator;

public class LoeschungsDialogController {
    private MainApp mainApp;
    private Stage dialogStage;

    private NotizService notizService = ServiceObjectBuilder.getNotizService();
    private KategorieService kategorieService = ServiceObjectBuilder.getKategorieService();
    private BearbeitungszustandService bearbeitungszustandService = ServiceObjectBuilder.getBearbeitungszustandService();
    private NotizFXService notizFXService = ServiceObjectBuilder.getNotizFXService();
    private KategorieFXService kategorieFXService = ServiceObjectBuilder.getKategorieFXService();
    private BearbeitungszustandFXService bearbeitungszustandFXService = ServiceObjectBuilder.getBearbeitungszustandFXService();


    //_______________Choice-Boxen__________________//
    @FXML
    ChoiceBox<KategorieFX> kategorieFXChoiceBox;

    @FXML
    ChoiceBox<BearbeitungszustandFX> bearbeitungszustandFXChoiceBox;

    @FXML
    ChoiceBox<NotizFX> notizFXChoiceBox;



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
     * Löscht bestehende Notiz, wenn auf "Löschen" Button geklickt wird, oder ruft Error-Dialog auf, wenn
     * Nutzereingaben falsch. Die Änderung wird direkt in die Datenbank übernommen
     *
     */
    @FXML
    private void handleBtnLoescheNotiz(){

        if (FXUtil.isInputValid(validateNotizLoeschen())) {
            NotizFX zuLoeschendeNotizFX = notizFXChoiceBox.getValue();

            mainApp.getNotizFXListe().remove(zuLoeschendeNotizFX);
            notizService.deleteNotiz(zuLoeschendeNotizFX.getNotizID().getValue());

            System.out.println("Notiz wurde aus Liste und Datenbank gelöscht:" + mainApp.getNotizFXListe());
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

        if (FXUtil.isInputValid(validateKategorieLoeschen())) {
            KategorieFX zuLoeschendeKategorieFX = kategorieFXChoiceBox.getValue();

            mainApp.getKategorieFXListe().remove(zuLoeschendeKategorieFX);
            kategorieService.deleteKategorie(zuLoeschendeKategorieFX.getKategorieID().getValue());

            System.out.println("Kategorie wurde aus Liste und Datenbank gelöscht:" + mainApp.getKategorieFXListe());
            dialogStage.close();
        }
    }



    /**
     * Löscht bestehenden Bearbeitungszustand, wenn auf "Löschen" Button geklickt wird, oder ruft Error-Dialog auf, wenn
     * Nutzereingaben falsch
     */
    @FXML
    private void handleBtnLoescheBearbeitungszustand(){

        if (FXUtil.isInputValid(validateBearbeitungszustandLoeschen())) {
            BearbeitungszustandFX bestehenderBearbeitungszustandFX = bearbeitungszustandFXChoiceBox.getValue();
            int bearbeitungszustandID = bestehenderBearbeitungszustandFX.getBearbeitungsZustandID().getValue();

            mainApp.getBearbeitungszustandFXListe().remove(bestehenderBearbeitungszustandFX);
            bearbeitungszustandService.deleteBearbeitungszustand(bearbeitungszustandID);

            System.out.println("Bearbeitungszustand wurde in Liste und Datenbank gelöscht:" + mainApp.getBearbeitungszustandFXListe());
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
        NotizFX bestehendeNotizFX = notizFXChoiceBox.getValue();

        String errorMessage = "";

        if (ObjectValidator.isObjectNull(bestehendeNotizFX)) {
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
        KategorieFX bestehendeKategorieFX = kategorieFXChoiceBox.getValue();
        Kategorie tmpKategorie;

        String errorMessage = "";

        if(ObjectValidator.isObjectNull(bestehendeKategorieFX)){
            errorMessage += I18nMessagesUtil.getErrorBestehendeKategorieUngueltig() + "\n";

        }else{
            tmpKategorie = kategorieFXService.unwrapKategorieFX(bestehendeKategorieFX);
            if(DaoContentValidator.isNotizMitKategorieVorhanden(tmpKategorie)){
                errorMessage += I18nMessagesUtil.getErrorEsGibtNochNotizenMitDieserKategorie() + "\n";
            }
        }

        return errorMessage;
    }



    /**
     * Validiert die Eingabefelder zur Änderung eines Bearbeitungszustands.
     * @return Fehlermeldungen, wenn Validierungsfehler aufgetreten sind, oder ein
     * leerer String.
     */
    private String validateBearbeitungszustandLoeschen() {

        BearbeitungszustandFX bestehenderZustandFX = bearbeitungszustandFXChoiceBox.getValue();
        Bearbeitungszustand tmpZustand;

        String errorMessage = "";

        if(ObjectValidator.isObjectNull(bestehenderZustandFX)){
            errorMessage += I18nMessagesUtil.getErrorBestehenderBearbeitungszustandUngueltig() + "\n";

        }else{
            tmpZustand = bearbeitungszustandFXService.unwrapBearbeitungszustandFX(bestehenderZustandFX);

            if (DaoContentValidator.isNotizMitBearbeitungszustandVorhanden(tmpZustand)) {
                errorMessage += I18nMessagesUtil.getErrorEsGibtNochNotizenMitDiesemBearbeitungszustand() + "\n";
            }
        }

        return errorMessage;
    }

}
