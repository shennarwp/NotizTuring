package notizverwaltung;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import notizverwaltung.builders.ServiceObjectBuilder;
import notizverwaltung.constants.DAOKonstanten;
import notizverwaltung.constants.FXKonstanten;
import notizverwaltung.i18n.I18nUtil;
import notizverwaltung.model.interfaces.*;
import notizverwaltung.service.interfaces.*;
import notizverwaltung.view.GesamtOverviewController;
import notizverwaltung.view.NotizblockOverviewController;
import notizverwaltung.view.RootLayoutController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Hauptprogramm, welches die GUI initialisiert
 * Kategorien, Notizen, Bearbeitungszustände befinden sich jeweils in einer ObservableList.
 *
 * Die Funktionalität der GUI-Elemente wird durch entsprechende Controller-Klassen und FXML zur Verfügung gestellt.
 *
 * @author Michelle Blau
 * @author Johannes Gerwert
 * @version 24.09.2018
 */

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootBorderPane;

    /**
     * Die Kategorien, Notizen und Bearbeitungszustände befinden sich in einer ObservableList
     */
    private ObservableList<NotizFX> notizFXListe = FXCollections.observableArrayList();
    private ObservableList<KategorieFX> kategorieFXListe = FXCollections.observableArrayList();
    private ObservableList<BearbeitungszustandFX> bearbeitungszustandFXListe = FXCollections.observableArrayList();

    /**
     * Service-Objekte zum Laden aus der Datenbank
     */
    private NotizService notizService = ServiceObjectBuilder.getNotizService();
    private KategorieService kategorieService = ServiceObjectBuilder.getKategorieService();
    private BearbeitungszustandService bearbeitungszustandService = ServiceObjectBuilder.getBearbeitungszustandService();

    /**
     * Service-Objekte zum Konvertieren zwischen normaler Modellklasse u. FX Modellklasse
     */
    private NotizFXService notizFXService = ServiceObjectBuilder.getNotizFXService();
    private KategorieFXService kategorieFXService = ServiceObjectBuilder.getKategorieFXService();
    private BearbeitungszustandFXService bearbeitungszustandFXService = ServiceObjectBuilder.getBearbeitungszustandFXService();


    /**
     * Füllt die ObservableLists mit entsprechenden Daten aus der Datenbank
     */
    public MainApp() {

        initializeListenMitDatenbankInhalt();
    }


    /**
     * Startet das Hauptprogramm
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(FXKonstanten.ANWENDUNG_NAME);
        initRootLayout();
        showGesamtOverview();

    }


    /**
     * Initialisiert das Grundfenster und die Menü-Leiste.
     */
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            ResourceBundle bundle = I18nUtil.getComponentsResourceBundle();
            loader.setLocation(MainApp.class
                    .getResource(FXKonstanten.PFAD_ROOT_LAYOUT));
            loader.setResources(bundle);
            rootBorderPane = loader.load();
            Scene scene = new Scene(rootBorderPane);
            primaryStage.setScene(scene);
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Erstellt das Hauptanzeigefenster der Notizen.
     */
    public void showGesamtOverview(){
        try{
            //lade TabPane
            FXMLLoader loader = new FXMLLoader();
            ResourceBundle bundle = I18nUtil.getComponentsResourceBundle();
            loader.setLocation(MainApp.class
                    .getResource(FXKonstanten.PFAD_GESAMT_OVERVIEW_LAYOUT));
            loader.setResources(bundle);
            TabPane gesamtOverview = (TabPane) loader.load();

            rootBorderPane.setCenter(gesamtOverview);

            GesamtOverviewController controller = loader.getController();
            controller.setMainApp(this);

            //lade Tab -> Notizblock
            FXMLLoader tabLoader = new FXMLLoader();
            ResourceBundle tabBundle = I18nUtil.getComponentsResourceBundle();
            tabLoader.setLocation(MainApp.class
                    .getResource(FXKonstanten.PFAD_NOTIZBLOCK_OVERVIEW_LAYOUT));
            tabLoader.setResources(tabBundle);
            Tab notizblock = (Tab) tabLoader.load();

            gesamtOverview.getTabs().add(notizblock);

            NotizblockOverviewController tabController = tabLoader.getController();
            tabController.setMainApp(this);
            tabController.ladeBearbeitungszustaende();


        } catch(IOException e){
            e.printStackTrace();
        }
    }


    public ObservableList<NotizFX> getNotizFXListe() {
        return this.notizFXListe;
    }

    public ObservableList<KategorieFX> getKategorieFXListe(){
        return this.kategorieFXListe;
    }

    public ObservableList<BearbeitungszustandFX> getBearbeitungszustandFXListe(){
        return this.bearbeitungszustandFXListe;
    }


    /**
     * Lädt normale Modellklassen aus der Datenbank und konvertiert diese um. Speichert
     * die konvertierten Objekte jeweils in einer ObservableList.
     */
    private void initializeListenMitDatenbankInhalt(){

        ArrayList<Notiz> notizListe = new ArrayList<>();
        ArrayList<Kategorie> kategorieListe =  new ArrayList<>();
        ArrayList<Bearbeitungszustand> bearbeitungszustandListe =  new ArrayList<>();

        notizListe.addAll(notizService.getAlleNotizenVomNotizblock(DAOKonstanten.STANDARD_NOTIZBLOCK_ID));
        kategorieListe.addAll(kategorieService.getAlleKategorien());
        bearbeitungszustandListe.addAll(bearbeitungszustandService.getAllBearbeitungszustand());

        notizFXListe.addAll(notizFXService.convertInNotizFXList(notizListe));
        kategorieFXListe.addAll(kategorieFXService.convertInKategorieFXList(kategorieListe));
        bearbeitungszustandFXListe.addAll(bearbeitungszustandFXService.convertInBearbeitungszustandFXList(bearbeitungszustandListe));

    }



    /**
     * Führt launch()-Methode aus, sollte aus Kompatibilitätsgründen nicht verändert werden
     *
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {
        launch(args);
    }


}
