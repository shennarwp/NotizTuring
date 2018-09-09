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
import notizverwaltung.service.interfaces.BearbeitungszustandService;
import notizverwaltung.service.interfaces.KategorieService;
import notizverwaltung.service.interfaces.NotizService;
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

    private NotizService notizService = new NotizServiceImpl();
    private KategorieService kategorieService = new KategorieServiceImpl();
    private BearbeitungszustandService bearbeitungszustandService = new BearbeitungszustandServiceImpl();


    /**
     * Fülle die Listen mit entsprechenden Daten, dies sind noch Testdaten für die GUI.
     */
    public MainApp() throws StringIsEmptyException, ObjectIstNullException {
        //TODO hier wird die GUI mit Testdaten gefüllt, hier sollen jedoch später die Inhalte aus der DB geladen werden
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date naechsteWoche = calendar.getTime();

        Kategorie kat1 = ModelObjectBuilder.getKategorieObjekt("Prog 3");
        Kategorie kat2 = ModelObjectBuilder.getKategorieObjekt("Mathe");
        Kategorie kat3 = ModelObjectBuilder.getKategorieObjekt("Englisch");


        kategorieListe.addAll(kategorieService.getAlleKategorien());
        System.out.println(kategorieListe+ "\n\n\n");
//        notizListe.addAll(notizService.getAlleNotizenVomNotizblock(DAOKonstanten.DEFAULT_NOTIZBLOCK_ID));
//        System.out.println(notizListe + "\n\n\n");
//        bearbeitungszustandListe.addAll(bearbeitungszustandService.getAllBearbeitungszustand());
//        System.out.println(bearbeitungszustandListe);



        Bearbeitungszustand bz1 = new BearbeitungszustandImpl("To-Do");
        Bearbeitungszustand bz2 = new BearbeitungszustandImpl("In Bearbeitung");
        Bearbeitungszustand bz3 = new BearbeitungszustandImpl("Erledigt");

        Notiz notiz1 = ModelObjectBuilder.getNotizObject();
        notiz1.setTitle("Programm schreiben");
        notiz1.setBeschreibung("Lagerklasse schreiben mit JUnit-Tests");
        notiz1.setKategorieID(kat1.getKategorieID());
        notiz1.setBearbeitungszustandID(bz1.getBearbeitungsZustandID());
        notiz1.setPrioritaet(true);
        notiz1.setFaelligkeit(naechsteWoche);

//        notizService.addNotiz(notiz1, DAOKonstanten.DEFAULT_NOTIZBLOCK_ID);
//
//        Notiz notiz2 = ModelObjectBuilder.getNotizObject();
//        notiz2.setTitle("Hausaufgaben");
//        notiz2.setBeschreibung("Übung 12, Aufgabe 1 und 2");
//        notiz2.setKategorieID(kat2.getKategorieID());
//        notiz2.setBearbeitungszustandID(bz2.getBearbeitungsZustandID());
//        notiz2.setPrioritaet(true);
//        notiz2.setFaelligkeit(naechsteWoche);
//
//        Notiz notiz3 = ModelObjectBuilder.getNotizObject();
//        notiz3.setTitle("Brief schreiben");
//        notiz3.setBeschreibung("Übung 13, Letter of Application schreiben");
//        notiz3.setKategorieID(kat3.getKategorieID());
//        notiz3.setBearbeitungszustandID(bz3.getBearbeitungsZustandID());
//        notiz3.setPrioritaet(false);
//        notiz3.setFaelligkeit(naechsteWoche);


        //TODO: führt zu einer NullpointerException, evtl weil Datenbank noch leer oder Methode geht nicht
        //notizListe.addAll(notizService.getAlleNotizenVomNotizblock(DAOKonstanten.DEFAULT_NOTIZBLOCK_ID));



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
        //showGesamtOverview();

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

            //lade Tab
            loader.setLocation(MainApp.class
                    .getResource(FXKonstanten.PFAD_NOTIZBLOCK_OVERVIEW_LAYOUT));
            Tab notizblock = (Tab) loader.load();

            gesamtOverview.getTabs().add(notizblock);

            NotizblockOverviewController tabController = loader.getController();
            tabController.setMainApp(this);


        } catch (IOException e){
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
     * Führt launch()-Methode aus, sollte aus Kompatibilitätsgründen nicht verändert werden
     *
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {
        launch(args);
    }

}
