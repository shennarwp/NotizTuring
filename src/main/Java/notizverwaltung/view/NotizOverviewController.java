package notizverwaltung.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

import java.util.Date;

import static notizverwaltung.util.DateUtil.convertDateInLocalDate;

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

    //TODO: entfernen
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
        //TODO: entfernen

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

        //--------------------------------------------------------------------------------------------------------------
        // zeigt Prioritaet an und updatet diese
        if(notizFX.getPrioritaet().getValue()){
            prioritaetLabel.setText(I18nComponentsUtil.getStandardPriorityHigh());
        }else{
            prioritaetLabel.setText(I18nComponentsUtil.getStandardPriorityLow());
        }
        notizFX.getPrioritaet().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(notizFX.getPrioritaet().getValue()){
                    prioritaetLabel.setText(I18nComponentsUtil.getStandardPriorityHigh());
                }else{
                    prioritaetLabel.setText(I18nComponentsUtil.getStandardPriorityLow());
                }
            }
        });

        //--------------------------------------------------------------------------------------------------------------
        //zeigt Faelligkeitsdatum an und updatet dieses
        datumLabel.setText(convertDateInLocalDate(notizFX.getFaelligkeit().getValue()).toString());
        notizFX.getFaelligkeit().addListener(new ChangeListener<Date>() {
            @Override
            public void changed(ObservableValue<? extends Date> observable, Date oldValue, Date newValue) {
                datumLabel.setText(convertDateInLocalDate(notizFX.getFaelligkeit().getValue()).toString());
            }
        });

        //--------------------------------------------------------------------------------------------------------------
        //zeigt Kategorie Namen an und updatet diesen
        kategorieLabel.setText(kategorieService.findKategorieName(notizFX.getKategorieID().getValue()));
        notizFX.getKategorieID().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                kategorieLabel.setText(kategorieService.findKategorieName(notizFX.getKategorieID().getValue()));
            }
        });

        //--------------------------------------------------------------------------------------------------------------
        // zeigt Notiz Namen an und updatet diesen
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
