package notizverwaltung;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import notizverwaltung.builders.ServiceObjectBuilder;
import notizverwaltung.constants.FXKonstanten;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.i18n.I18nUtil;
import notizverwaltung.model.classes.BearbeitungszustandImpl;
import notizverwaltung.model.classes.KategorieImpl;
import notizverwaltung.model.classes.NotizImpl;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.classes.NotizFilterServiceImpl;
import notizverwaltung.service.classes.NotizServiceImpl;
import notizverwaltung.service.interfaces.NotizFilterService;
import notizverwaltung.service.interfaces.NotizService;
import notizverwaltung.view.RootLayoutController;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Hauptprogramm, welches die GUI initialisiert
 * Kategorien, Notizen, Bearbeitungszustände befinden sich jeweils in einer ObversableList.
 *
 * Die Funktionalität der GUI-Elemente wird durch entsprechende Controller-Klassen und FXML zur Verfügung gestellt.
 *
 * @author Michelle Blau, Johannes Gerwert
 * @version 07.09.2018
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


    /**
     * Fülle die Listen mit entsprechenden Daten, dies sind noch Testdaten für die GUI.
     */
    public MainApp() throws StringIsEmptyException, ObjectIstNullException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date naechsteWoche = calendar.getTime();

        Kategorie kat1 = new KategorieImpl("Prog 3");
        Kategorie kat2 = new KategorieImpl("Mathe");
        Kategorie kat3 = new KategorieImpl("Englisch");
        //Kategorie kat4 = new KategorieImpl("Prog 4", Color.web("#660033\n", 1.0));

        kategorieListe.add(kat1);
        kategorieListe.add(kat2);
        kategorieListe.add(kat3);
        //kategorieListe.add(kat4);

        Notiz notiz1 = new NotizImpl("Program", kat1.getKategorieName(), "To-Do", "Artikel-Klasse schreiben", true, naechsteWoche);
        notizListe.add(notiz1);
        notizListe.add(new NotizImpl("Hausaufgabe", kat2.getKategorieName(), "To-Do", "Übung 12", true, naechsteWoche));
        notizListe.add(new NotizImpl("Aufsatz", kat3.getKategorieName(), "In Bearbeitung", "Shakespeare", false, naechsteWoche));

        //TODO: führt zu einer NullpointerException, evtl weil Datenbank noch leer oder Methode geht nicht
        // notizListe.addAll(notizService.getAlleNotizenVomNotizblock(1));
        Bearbeitungszustand todo = new BearbeitungszustandImpl("To-Do");
        bearbeitungszustandListe.add(todo);
        bearbeitungszustandListe.add(new BearbeitungszustandImpl("In Bearbeitung"));
        bearbeitungszustandListe.add(new BearbeitungszustandImpl("Erledigt"));

        NotizFilterService notizFilterService = new NotizFilterServiceImpl();
        System.out.println("\n\n\n" + notizFilterService.filterAlleNotizenMitEinemBearbeitunszustand(todo.getBearbeitungsZustandID(),notizListe));
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

    }


    /**
     * Initialisiert das RootLayout innerhalb des "rootBorderPane" mit dem Grundgeruest der Anwendung.
     */
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            ResourceBundle bundle = I18nUtil.getMenuResourceBundle();
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
