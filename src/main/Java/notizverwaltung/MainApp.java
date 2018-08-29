package notizverwaltung;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import notizverwaltung.constants.FXKonstanten;
import notizverwaltung.i18n.I18nUtil;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.view.RootLayoutController;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Hauptprogramm, welches die GUI initialisiert
 *
 * @author Michelle Blau
 * @version 28.08.2018
 */

public class MainApp extends Application {


    private Stage primaryStage;
    private BorderPane rootBorderPane;

    /**
     * Die Daten befinden sich in einer ObservableList
     */
    private ObservableList<Kategorie> kategorieListe = FXCollections.observableArrayList();



    @Override
    public void start(Stage primaryStage) {
        System.out.println("HIIIIIIIIIIIIIIIIIIIIIIIIIII");
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(FXKonstanten.ANWENDUNG_NAME);
        //this.primaryStage.setMaximized(true);
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
            rootBorderPane = (BorderPane)loader.load();
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

    public static void main(String[] args) {
        launch(args);
    }

}
