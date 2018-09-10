package notizverwaltung;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import notizverwaltung.view.TestController;

public class TestAPI extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start (Stage primaryStage) throws Exception{
        TestController controller = new TestController();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(controller);

        loader.setLocation(getClass().getResource("/view/test.fxml"));
        HBox vbox = loader.<HBox>load();

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
