package main.java.notizverwaltung.javafx8;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.java.notizverwaltung.i18n.I18nMenuUtil;

import static javafx.application.Application.launch;

public class Fxtest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        final BorderPane root = new BorderPane();
        final Node labelNode = new Label("Hallo JavaFX Welt");

        final MenuBar menuBar = erstelleMenuBar();


        root.setTop(menuBar);
        root.setCenter(labelNode);

        Scene scene = new Scene(root, 250, 75);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Notizverwaltung");
        primaryStage.setResizable(true);
        primaryStage.centerOnScreen();
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String [] args) {
        launch(args);
    }


    private MenuBar erstelleMenuBar(){
        MenuBar menuBar = new MenuBar();

        final Menu menuDatei = new Menu(I18nMenuUtil.getMenuFile());
        final MenuItem itmNeu = new MenuItem(I18nMenuUtil.getMenuNew());

        final Menu menuNeu = new Menu(I18nMenuUtil.getMenuNew());
        final Menu menuBearbeiten = new Menu(I18nMenuUtil.getMenuEdit());
        final Menu menuOptionen = new Menu(I18nMenuUtil.getMenuOptions());
        final Menu menuHilfe = new Menu(I18nMenuUtil.getMenuHelp());
        final Menu menuSuche = new Menu(I18nMenuUtil.getMenuSearch());
        final Menu menuFilter = new Menu(I18nMenuUtil.getMenuFilter());
        final Menu menuSortieren = new Menu(I18nMenuUtil.getMenuSort());


        menuDatei.getItems().addAll(itmNeu);

        menuBar.getMenus().addAll(menuDatei, menuNeu, menuBearbeiten, menuOptionen, menuHilfe, menuSuche, menuFilter, menuSortieren);

        return menuBar;
    }


}





