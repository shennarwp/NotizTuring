package notizverwaltung.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import notizverwaltung.MainApp;
import notizverwaltung.builders.ServiceObjectBuilder;
import notizverwaltung.i18n.I18nComponentsUtil;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.BearbeitungszustandFX;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.model.interfaces.NotizFX;
import notizverwaltung.service.interfaces.*;

import java.util.Date;
import java.util.ListIterator;

import static notizverwaltung.util.DateUtil.convertDateInLocalDate;

/**
 * Diese Klasse erzeugt einen Teil des Hauptanzeigefensters.
 * Die Notizen werden hier bedient.
 *
 * @author Johannes Gerwert
 * @version 21.09.2018
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
    private ComboBox<BearbeitungszustandFX> spaltenWahlBox;

    private NotizFX notizFX;

    private ObservableList<BearbeitungszustandFX> bearbeitungszustandFXListe;

    private MainApp mainApp;

    private KategorieService kategorieService = ServiceObjectBuilder.getKategorieService();
    private BearbeitungszustandService bearbeitungszustandService = ServiceObjectBuilder.getBearbeitungszustandService();
    private BearbeitungszustandFXService bearbeitungszustandFXService = ServiceObjectBuilder.getBearbeitungszustandFXService();
    private NotizFXService notizFXService = ServiceObjectBuilder.getNotizFXService();
    private NotizService notizService = ServiceObjectBuilder.getNotizService();

    /**
     * Konstruktor
     * Tut momentan nichts.
     */
    public NotizOverviewController(){

    }

    /**
     * Die Umgebung in der das Bedienelement agiert wird gesetzt.
     * Der Inhalt der Liste zur Spaltenwahl wird eingerichtet.
     * @param mainApp Ein Verweis auf die MainApp.
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        bearbeitungszustandFXListe = mainApp.getBearbeitungszustandFXListe();
        spaltenWahlBox.setItems(bearbeitungszustandFXListe);

    }

    /**
     * Die anzuzeigende Notiz wird dem Objekt zugewiesen.
     * Die anzuzeigenden Daten werden den entsprechenden FXML Objekten zugewiesen.
     *
     * @param notizFX Die anzuzeigende Notiz
     */
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
        int bearbeitungszustandID;
        Bearbeitungszustand bazs;
        BearbeitungszustandFX bazsFX;
        Notiz tmpNotiz;
        int position;
        ListIterator<BearbeitungszustandFX> iterator;

        bearbeitungszustandID = notizFX.getBearbeitungszustandID().getValue();
        bazs = bearbeitungszustandService.getBearbeitungszustand(bearbeitungszustandID);
        bazsFX = bearbeitungszustandFXService.wrapBearbeitungszustand(bazs);
        position = bearbeitungszustandFXListe.indexOf(bazsFX);
        iterator = bearbeitungszustandFXListe.listIterator(position);

        if(iterator.hasPrevious()){

            notizFX.setBearbeitungszustandID(iterator.previous().getBearbeitungsZustandID().getValue());
            tmpNotiz = notizFXService.unwrapNotizFX(notizFX);

            notizService.updateNotiz(tmpNotiz);

            //TODO: entfernen
            System.out.println("\n\n\n\n\n\nDie Notiz wurde nach links bewegt!!!");
        }
    }

    /**
     * Die Notiz wird um eine Spalte nach rechts bewegt.
     */
    @FXML
    private void handleMoveRight(){

        int bearbeitungszustandID;
        Bearbeitungszustand bazs;
        BearbeitungszustandFX bazsFX;
        Notiz tmpNotiz;
        int position;
        ListIterator<BearbeitungszustandFX> iterator;

        bearbeitungszustandID = notizFX.getBearbeitungszustandID().getValue();
        bazs = bearbeitungszustandService.getBearbeitungszustand(bearbeitungszustandID);
        bazsFX = bearbeitungszustandFXService.wrapBearbeitungszustand(bazs);
        position = bearbeitungszustandFXListe.indexOf(bazsFX);
        iterator = bearbeitungszustandFXListe.listIterator(position);
        iterator.next();

        if(iterator.hasNext()){

            notizFX.setBearbeitungszustandID(iterator.next().getBearbeitungsZustandID().getValue());
            tmpNotiz = notizFXService.unwrapNotizFX(notizFX);

            notizService.updateNotiz(tmpNotiz);

            //TODO: entfernen
            System.out.println("\n\n\n\n\n\nDie Notiz wurde nach rechts bewegt!!!");
        }
    }

    /**
     * Die Notiz wird zu der Spalte bewegt, die in der ComboBox ausgewaehlt wurde.
     */
    @FXML
    private void handleMoveToBearbeitungszustand(){

        BearbeitungszustandFX bazsFX;
        Notiz tmpNotiz;
        bazsFX = spaltenWahlBox.getValue();

        //TODO: entfernen
        System.out.println("\n\n\n\n\n\nDie Notiz wurde zu Bearbeitungszustand NR." + bazsFX.getBearbeitungsZustandID().getValue() + " bewegt!!!");

        notizFX.setBearbeitungszustandID(bazsFX.getBearbeitungsZustandID().getValue());
        tmpNotiz = notizFXService.unwrapNotizFX(notizFX);

        notizService.updateNotiz(tmpNotiz);
    }
}
