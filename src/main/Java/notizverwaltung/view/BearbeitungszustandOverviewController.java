package notizverwaltung.view;

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
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Notiz;

import java.io.IOException;
import java.util.ResourceBundle;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

/**
 * Diese Klasse erzeugt einen Teil des Hauptanzeigefensters.
 * Die Bearbeitungszustaende werden hier bedient.
 *
 * @author Johannes Gerwert
 * @version 12.09.2018
 */
public class BearbeitungszustandOverviewController{

    @FXML
    private TitledPane bearbeitungszustandTitle;
    @FXML
    private VBox notizen;

    private String name = I18nComponentsUtil.getStandardStatusName();
    private ObservableList<Notiz> notizListe;
    private Bearbeitungszustand bazs;

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

        notizListe = mainApp.getNotizListe();
        setListener();
    }

    /**
     * Der Bearbeitungszustand, der zu diesem Controller gehoert, wird festgelegt.
     * Danach wird der Name der zu diesem Bearbeitungszustand gehoert in den
     * TitledPane geladen.
     * @param bazs Der Bearbeitungszustand, der zu diesem Controller gehoert.
     */
    public void setBearbeitungszustand(Bearbeitungszustand bazs){
        this.bazs = bazs;
        bearbeitungszustandTitle.setText(this.bazs.getName());
    }

    /**
     * Die Notizen die zu dem Bearbeitungsstatus gehoeren werden geladen.
     */
    public void ladeNotizen(){

        for(Notiz notiz : notizListe){
            addNotiz(notiz);
        }


    }

    /**
     * Eine Notiz wird in die VBox eingefuegt.
     *
     * @param notiz Die einzufuegende Notiz
     */
    public void addNotiz(Notiz notiz){
        //TODO: Fehler werfen, falls Bearbeitungsstatus nicht gesetzt.
        try{
            if(this.bazs.getBearbeitungsZustandID() == notiz.getBearbeitungszustandID()){
                FXMLLoader loader = new FXMLLoader();
                ResourceBundle bundle = I18nUtil.getComponentsResourceBundle();
                loader.setLocation(MainApp.class
                        .getResource(FXKonstanten.PFAD_NOTIZ_OVERVIEW_LAYOUT));
                loader.setResources(bundle);
                AnchorPane notizView = (AnchorPane) loader.load();
                notizView.setId("" + notiz.getNotizID());

                notizen.getChildren().add(notizView);

                NotizOverviewController controller = loader.getController();
                controller.setMainApp(mainApp);
                controller.setNotiz(notiz);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Eine Notiz wird aus der VBox entfernt.
     *
     * @param notiz Die zu loeschende Notiz
     */
    public void removeNotiz(Notiz notiz){
        String notizID = "" + notiz.getNotizID();

        for(Node notizView: notizen.getChildren()){
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
    private void setListener(){
        notizListe.addListener(new ListChangeListener<Notiz>() {
            @Override
            public void onChanged(Change<? extends Notiz> c) {
                while(c.next()){
                    if(c.wasAdded()){
                        for(Notiz notiz : c.getAddedSubList()){
                            addNotiz(notiz);
                        }
                    }

                    if(c.wasRemoved()){
                        for(Notiz notiz : c.getRemoved()){
                            removeNotiz(notiz);
                        }
                    }
                }
            }
        });
    }
}
