package notizverwaltung.view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import notizverwaltung.MainApp;
import notizverwaltung.builders.ServiceObjectBuilder;
import notizverwaltung.i18n.I18nComponentsUtil;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.model.interfaces.NotizFX;
import notizverwaltung.service.classes.KategorieServiceImpl;
import notizverwaltung.service.interfaces.KategorieService;

/**
 * Diese Klasse erzeugt einen Teil des Hauptanzeigefensters.
 * Die Notizen werden hier bedient.
 *
 * @author Johannes Gerwert
 * @version 12.09.2018
 */
public class NotizOverviewController {

    @FXML
    private Label prioritaetLabel;
    @FXML
    private Label datumLabel;
    @FXML
    private Label kategorieLabel;
    @FXML
    private Label notizLabel;
    @FXML
    private ComboBox spaltenWahlBox;

    private Notiz notiz;
    private NotizFX notizFX;

    private MainApp mainApp;

    private KategorieService kategorieService = ServiceObjectBuilder.getKategorieService();

    /**
     * Konstruktor
     * Tut momentan nichts.
     */
    public NotizOverviewController(){

    }

    /**
     * Die Umgebung in der das Bedienelement agiert wird gesetzt.
     * @param mainApp Ein Verweis auf die MainApp.
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Die Notiz, die zu diesem Controller gehoert wird festgelegt.
     * Danach werden alle Notiz spezifischen Labels beschriftet.
     * @param notiz Die Notiz, die zum Controller gehoert
     */
    public void setNotiz(Notiz notiz){
        this.notiz = notiz;

        if(notiz.getPrioritaet()){
            prioritaetLabel.setText(I18nComponentsUtil.getStandardPriorityHigh());
        }else{
            prioritaetLabel.setText(I18nComponentsUtil.getStandardPriorityLow());
        }

        //TODO: Bessere Loesung zur Datumsanzeige finden
        datumLabel.setText(notiz.getFaelligkeit().toString());
        kategorieLabel.setText(kategorieService.findKategorieName(notiz.getKategorieID()));
        notizLabel.setText(notiz.getTitle());
    }

    public void setNotizFX(NotizFX notizFX){
        this.notizFX = notizFX;

        if(notizFX.getPrioritaet().getValue()){
            prioritaetLabel.setText(I18nComponentsUtil.getStandardPriorityHigh());
        }else{
            prioritaetLabel.setText(I18nComponentsUtil.getStandardPriorityLow());
        }

        //TODO: Besser Loesung zur Datumsanzeige finden
        datumLabel.textProperty().bind(notizFX.getFaelligkeit().asString());
        kategorieLabel.textProperty().bind(notizFX.getKategorieID().asString());
        notizLabel.textProperty().bind(notizFX.getTitle());
    }

    /**
     * Die Notiz wird um eine Spalte nach links bewegt.
     */
    @FXML
    private void handleMoveLeft(){
        //TODO
    }

    /**
     * Die Notiz wird um eine Spalte nach rechts bewegt.
     */
    @FXML
    private void handleMoveRight(){
        //TODO
    }
}
