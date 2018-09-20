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
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.model.interfaces.NotizFX;
import notizverwaltung.service.classes.KategorieServiceImpl;
import notizverwaltung.service.interfaces.BearbeitungszustandService;
import notizverwaltung.service.interfaces.KategorieService;
import notizverwaltung.service.interfaces.NotizFXService;
import notizverwaltung.service.interfaces.NotizService;

import java.util.Date;
import java.util.ListIterator;

import static notizverwaltung.util.DateUtil.convertDateInLocalDate;

/**
 * Diese Klasse erzeugt einen Teil des Hauptanzeigefensters.
 * Die Notizen werden hier bedient.
 *
 * @author Johannes Gerwert
 * @version 20.09.2018
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
    private ComboBox<Bearbeitungszustand> spaltenWahlBox;

    private NotizFX notizFX;

    private ObservableList<Bearbeitungszustand> bearbeitungszustandListe;

    private MainApp mainApp;

    private KategorieService kategorieService = ServiceObjectBuilder.getKategorieService();
    private BearbeitungszustandService bearbeitungszustandService = ServiceObjectBuilder.getBearbeitungszustandService();
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
        bearbeitungszustandListe = mainApp.getBearbeitungszustandListe();
        spaltenWahlBox.setItems(bearbeitungszustandListe);

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
        Notiz tmpNotiz;
        int position;
        ListIterator<Bearbeitungszustand> iterator;

        bearbeitungszustandID = notizFX.getBearbeitungszustandID().getValue();
        bazs = bearbeitungszustandService.getBearbeitungszustand(bearbeitungszustandID);
        position = bearbeitungszustandListe.indexOf(bazs);
        iterator = bearbeitungszustandListe.listIterator(position);

        if(iterator.hasPrevious()){

            notizFX.setBearbeitungszustandID(iterator.previous().getBearbeitungsZustandID());
            tmpNotiz = notizFXService.wrapNotizFXinNotiz(notizFX);

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
        Notiz tmpNotiz;
        int position;
        ListIterator<Bearbeitungszustand> iterator;

        bearbeitungszustandID = notizFX.getBearbeitungszustandID().getValue();
        bazs = bearbeitungszustandService.getBearbeitungszustand(bearbeitungszustandID);
        position = bearbeitungszustandListe.indexOf(bazs);
        iterator = bearbeitungszustandListe.listIterator(position);
        iterator.next();

        if(iterator.hasNext()){

            notizFX.setBearbeitungszustandID(iterator.next().getBearbeitungsZustandID());
            tmpNotiz = notizFXService.wrapNotizFXinNotiz(notizFX);

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

        Bearbeitungszustand bazs;
        Notiz tmpNotiz;
        bazs = (Bearbeitungszustand) spaltenWahlBox.getValue();

        //TODO: entfernen
        System.out.println("\n\n\n\n\n\nDie Notiz wurde zu Bearbeitungszustand NR." + bazs.getBearbeitungsZustandID() + " bewegt!!!");

        notizFX.setBearbeitungszustandID(bazs.getBearbeitungsZustandID());
        tmpNotiz = notizFXService.wrapNotizFXinNotiz(notizFX);

        notizService.updateNotiz(tmpNotiz);
    }
}
