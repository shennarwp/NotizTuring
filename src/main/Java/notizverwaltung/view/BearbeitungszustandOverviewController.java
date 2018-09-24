package notizverwaltung.view;

import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import notizverwaltung.MainApp;
import notizverwaltung.constants.FXKonstanten;
import notizverwaltung.i18n.I18nComponentsUtil;
import notizverwaltung.i18n.I18nUtil;
import notizverwaltung.model.interfaces.BearbeitungszustandFX;
import notizverwaltung.model.interfaces.NotizFX;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Diese Klasse erzeugt einen Teil des Hauptanzeigefensters.
 * Die Bearbeitungszustaende werden hier bedient.
 *
 * @author Johannes Gerwert
 * @version 21.09.2018
 */
public class BearbeitungszustandOverviewController{

    @FXML
    private TitledPane bearbeitungszustandTitle;
    @FXML
    private VBox notizen;

    private String name = I18nComponentsUtil.getStandardStatusName();


    private ObservableList<NotizFX> notizFXListe;
    private BearbeitungszustandFX bazs;

    private MainApp mainApp;

    /**
     * Konstruktor
     * Tut momentan nichts.
     */
    public BearbeitungszustandOverviewController(){

    }

    /**
     * Das Bedienelement wird initialisiert. Dieser Code wird direkt nach dem laden der
     * FXML Datei ausgefuehrt.
     * Der Standard Name fuer Bearbeitungszustaende wird in den TitledPane geladen.
     */
    @FXML
    private void initialize(){
        bearbeitungszustandTitle.setText(name);
    }

    /**
     * Die Umgebung in der das Bedienelement agiert wird gesetzt.
     * Außerdem wird eine Liste aus der MainApp geladen, die alle
     * entsprechenden Notizen enthaelt.
     * @param mainApp Ein Verweis auf die MainApp.
     */
    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;

        notizFXListe = mainApp.getNotizFXListe();
        addNotizListener();
    }

    /**
     * Der Bearbeitungszustand, der zu diesem Controller gehoert, wird festgelegt.
     * Danach wird der Name der zu diesem Bearbeitungszustand gehoert in den
     * TitledPane geladen.
     * @param bazs Der Bearbeitungszustand, der zu diesem Controller gehoert.
     */
    public void setBearbeitungszustand(BearbeitungszustandFX bazs){
        this.bazs = bazs;
        bearbeitungszustandTitle.textProperty().bind((this.bazs.getName()));
    }

    /**
     * Die Notizen die zu dem Bearbeitungsstatus gehoeren werden geladen.
     */
    public void ladeNotizen(){

        for(NotizFX notizFX: notizFXListe){
            addNotiz(notizFX);
            addMoveListener(notizFX);
        }


    }

    /**
     * Eine Notiz wird in die VBox eingefuegt.
     *
     * @param notizFX Die einzufuegende Notiz
     */
    private void addNotiz(NotizFX notizFX){
        try{
            if(this.bazs.getBearbeitungsZustandID().getValue() == notizFX.getBearbeitungszustandID().getValue()){
                FXMLLoader loader = new FXMLLoader();
                ResourceBundle bundle = I18nUtil.getComponentsResourceBundle();
                loader.setLocation(MainApp.class
                        .getResource(FXKonstanten.PFAD_NOTIZ_OVERVIEW_LAYOUT));
                loader.setResources(bundle);
                AnchorPane notizView = (AnchorPane) loader.load();
                notizView.setId("" + notizFX.getNotizID().getValue());

                notizen.getChildren().add(notizView);

                NotizOverviewController controller = loader.getController();
                controller.setMainApp(mainApp);
                controller.setNotizFX(notizFX);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Eine Notiz wird aus der VBox entfernt.
     *
     * @param notizFX Die zu loeschende Notiz
     */
    private void removeNotiz(NotizFX notizFX){
        String notizID = "" + notizFX.getNotizID().getValue();

        for(Node notizView : notizen.getChildren()){
            if(notizID.equals(notizView.getId())){
                notizen.getChildren().remove(notizView);
            }
        }
    }

    /**
     * Ein Listener wird zur notizListe hinzugefuegt.
     * Wenn eine Notiz zur Liste hinzugefuegt oder daraus entfernt wird,
     * wird dies auch in der GUI dargestellt.
     */
    private void addNotizListener(){
        notizFXListe.addListener(new ListChangeListener<NotizFX>() {
            @Override
            public void onChanged(Change<? extends NotizFX> c) {
                while(c.next()){
                    if(c.wasAdded()){
                        for(NotizFX notizFX : c.getAddedSubList()){
                            addNotiz(notizFX);
                            addMoveListener(notizFX);
                        }
                    }

                    if(c.wasRemoved()){
                        for(NotizFX notizFX : c.getRemoved()){
                            removeNotiz(notizFX);
                        }
                    }
                }
            }
        });
    }

    /**
     * Dem Bearbeitungszustand der Notiz wird ein Listener hinzugefuegt.
     * Wenn der Bearbeitungszustand geaendert wird, wird das zur Notiz gehoerende JavaFX
     * Element aus der Liste geloescht und wieder neu eingefuegt.
     * Dadurch wird die Notiz im richtigen Bearbeitungszustand eingeordnet.
     *
     * @param notizFX
     */
    private void addMoveListener(NotizFX notizFX){
        IntegerProperty bazsID = notizFX.getBearbeitungszustandID();

        bazsID.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                removeNotiz(notizFX);
                addNotiz(notizFX);
            }
        });
    }
}
