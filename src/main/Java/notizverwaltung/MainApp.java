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
import notizverwaltung.builders.ModelObjectBuilder;
import notizverwaltung.constants.DAOKonstanten;
import notizverwaltung.constants.FXKonstanten;
import notizverwaltung.dao.classes.NotizDAOImpl;
import notizverwaltung.dao.interfaces.NotizDAO;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.i18n.I18nUtil;
import notizverwaltung.model.classes.BearbeitungszustandImpl;
import notizverwaltung.model.classes.KategorieImpl;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.classes.BearbeitungszustandServiceImpl;
import notizverwaltung.service.classes.KategorieServiceImpl;
import notizverwaltung.service.classes.NotizServiceImpl;
import notizverwaltung.service.classes.NotizblockServiceImpl;
import notizverwaltung.service.interfaces.BearbeitungszustandService;
import notizverwaltung.service.interfaces.KategorieService;
import notizverwaltung.service.interfaces.NotizService;
import notizverwaltung.service.interfaces.NotizblockService;
import notizverwaltung.view.GesamtOverviewController;
import notizverwaltung.view.NotizblockOverviewController;
import notizverwaltung.view.RootLayoutController;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Hauptprogramm, welches die GUI initialisiert
 * Kategorien, Notizen, Bearbeitungszustände befinden sich jeweils in einer ObversableList.
 *
 * Die Funktionalität der GUI-Elemente wird durch entsprechende Controller-Klassen und FXML zur Verfügung gestellt.
 *
 * @author Michelle Blau, Johannes Gerwert
 * @version 09.09.2018
 */

public class MainApp extends Application {


    private Stage primaryStage;
    private BorderPane rootBorderPane;

    /**
     * Die Kategorien, Notizen und Bearbeitungszustände befinden sich in einer ObservableList
     */
    private ObservableList<Kategorie> kategorieListe = FXCollections.observableArrayList();
    private ObservableList<Notiz> notizListe = FXCollections.observableArrayList();
    private ObservableList<Bearbeitungszustand> bearbeitungszustandListe = FXCollections.observableArrayList();

    private NotizblockService notizblockService = new NotizblockServiceImpl();
    private NotizService notizService = new NotizServiceImpl();
    private KategorieService kategorieService = new KategorieServiceImpl();
    private BearbeitungszustandService bearbeitungszustandService = new BearbeitungszustandServiceImpl();


    /**
     * Fülle die Listen mit entsprechenden Daten, dies sind noch Testdaten für die GUI.
     */
    public MainApp() throws StringIsEmptyException, ObjectIstNullException {

        initializeListenMitDatenbankInhalt();

        System.out.println("\n\n\n\n"+notizListe);
        System.out.println("\n\n\n\n"+kategorieListe);
        System.out.println("\n\n\n\n"+bearbeitungszustandListe);

    }


    /**
     * Startet das Hauptprogramm
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        System.out.println(kategorieListe.size() + notizListe.size() + bearbeitungszustandListe.size());
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(FXKonstanten.ANWENDUNG_NAME);
        //initSpalten();
        initRootLayout();
        showGesamtOverview();

    }


    /**
     * Initialisiert das RootLayout innerhalb des "rootBorderPane" mit dem Grundgeruest der Anwendung.
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

    public ObservableList<Kategorie> getKategorieListe(){
        return this.kategorieListe;
    }

    public ObservableList<Notiz> getNotizListe() {
        return notizListe;
    }

    public ObservableList<Bearbeitungszustand> getBearbeitungszustandListe() {
        return bearbeitungszustandListe;
    }


    /**
     * Initialisiert die ObservableLists mit Notizen, Kategorien, Bearbeitungszuständen, durch Verbindung zur Datenbank
     */
    private void initializeListenMitDatenbankInhalt(){
        notizListe.addAll(notizService.getAlleNotizenVomNotizblock(DAOKonstanten.DEFAULT_NOTIZBLOCK_ID));
        kategorieListe.addAll(kategorieService.getAlleKategorien());
        bearbeitungszustandListe.addAll(bearbeitungszustandService.getAllBearbeitungszustand());
    }


    /**
     * Initialisiert die ObservableLists mit Kategorien und Bearbeitungszuständen, keine Verbindung zur Datenbank
     */
    private void initializeListenMitTestdaten(){
        Kategorie kat1 = ModelObjectBuilder.getKategorieObjekt("Prog 3");
        Kategorie kat2 = ModelObjectBuilder.getKategorieObjekt("Mathe");
        Kategorie kat3 = ModelObjectBuilder.getKategorieObjekt("Englisch");
        kategorieListe.add(kat1);
        kategorieListe.add(kat2);
        kategorieListe.add(kat3);

        Bearbeitungszustand bz1 = new BearbeitungszustandImpl("To-Do");
        Bearbeitungszustand bz2 = new BearbeitungszustandImpl("In Bearbeitung");
        Bearbeitungszustand bz3 = new BearbeitungszustandImpl("Erledigt");
        bearbeitungszustandListe.add(bz1);
        bearbeitungszustandListe.add(bz2);
        bearbeitungszustandListe.add(bz3);

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
