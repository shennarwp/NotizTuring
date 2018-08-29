package notizverwaltung.javafx8;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import notizverwaltung.i18n.I18nMenuUtil;
import notizverwaltung.model.interfaces.*;

import java.awt.event.MouseEvent;

import static javafx.application.Application.launch;


/**
 * Stellt das Grundfenster ohne weitere Funktionalität zur Verfügung
 *
 *
 * @author Michelle Blau
 * @version 25.08.2018
 */
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
        primaryStage.setTitle("Notizverwaltung"); //TODO: i18n
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

        //TODO: i18n
        final Menu menuNeu = new Menu(I18nMenuUtil.getMenuNew());
        final MenuItem itmKategorie = new MenuItem("Kategorie");
        final MenuItem itmBearbeitungszustand = new MenuItem("Bearbeitungszustand");
        final MenuItem itmNotiz = new MenuItem("Notiz");

        EventHandler<ActionEvent> lambdaErstelleNotizDialog = (actionevent) -> {
           erstelleNotizDialog().showAndWait();
        };


        //itmNotiz.addEventHandler(DragEvent. , lambdaErstelleNotizDialog);

        final Menu menuBearbeiten = new Menu(I18nMenuUtil.getMenuEdit());
        final Menu menuOptionen = new Menu(I18nMenuUtil.getMenuOptions());
        final Menu menuHilfe = new Menu(I18nMenuUtil.getMenuHelp());
        final Menu menuSuche = new Menu(I18nMenuUtil.getMenuSearch());
        final Menu menuFilter = new Menu(I18nMenuUtil.getMenuFilter());
        final Menu menuSortieren = new Menu(I18nMenuUtil.getMenuSort());


        menuDatei.getItems().addAll(itmNeu);
        menuNeu.getItems().addAll(itmKategorie,itmBearbeitungszustand,itmNotiz);

        menuBar.getMenus().addAll(menuDatei, menuNeu, menuBearbeiten, menuOptionen, menuHilfe, menuSuche, menuFilter, menuSortieren);

        return menuBar;
    }





    private Dialog erstelleNotizDialog(){

        Dialog<Notiz> erstelleNotizDialog = new Dialog<>();

        erstelleNotizDialog.setTitle("Neue Notiz erstellen");
        erstelleNotizDialog.setHeaderText("This is a custom dialog. Enter info and \n" +
                "press Okay (or click title bar 'X' for cancel).");
        erstelleNotizDialog.setResizable(true);

        Label label1 = new Label("Name: ");
        Label label2 = new Label("Phone: ");
        TextField text1 = new TextField();
        TextField text2 = new TextField();

        GridPane grid = new GridPane();
        grid.add(label1, 1, 1);
        grid.add(text1, 2, 1);
        grid.add(label2, 1, 2);
        grid.add(text2, 2, 2);

        erstelleNotizDialog.getDialogPane().setContent(grid);



        ButtonType buttonTypeOk = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);

        erstelleNotizDialog.getDialogPane().getButtonTypes().add(buttonTypeOk);

        return erstelleNotizDialog;
    }

}





