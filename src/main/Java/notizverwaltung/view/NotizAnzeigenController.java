package notizverwaltung.view;

import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import notizverwaltung.MainApp;
import notizverwaltung.constants.FXKonstanten;
import notizverwaltung.i18n.I18nUtil;
import notizverwaltung.model.interfaces.BearbeitungszustandFX;
import notizverwaltung.model.interfaces.KategorieFX;
import notizverwaltung.model.interfaces.NotizFX;



import java.io.IOException;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * @author Tobias Gottschalk
 */

public class NotizAnzeigenController {


    private Stage dialogStage;

    @FXML
    TextField notizNameField;

    @FXML
    TextField notizBearbeitungszustandField;

    @FXML
    TextField kategorieNameField;

    @FXML
    TextArea notizBeschreibungTextArea;

    @FXML
    TextField notizFaelligkeitField;

    @FXML
    CheckBox notizPrioritaetCheckBox;

    @FXML
    TextField bearbeitungszustandNameField;


/*
    @FXML
    public void showNotizAnzeigeDialog(NotizFX notizFX){
        try {
            FXMLLoader loader = new FXMLLoader();
            ResourceBundle bundle = I18nUtil.getDialogResourceBundle();
            loader.setLocation(MainApp.class
                    .getResource(FXKonstanten.PFAD_NOTIZ_ANZEIGEN_LAYOUT));
            loader.setResources(bundle);
            AnchorPane anchorPane = (AnchorPane) loader.load();

            this.dialogStage = new Stage();
            Scene scene = new Scene(anchorPane);
            this.dialogStage.setScene(scene);

           NotizAnzeigenController controller = loader.getController();


            this.dialogStage.setTitle(FXKonstanten.DIALOG);
            this.dialogStage.setResizable(false);
            this.dialogStage.initModality(Modality.APPLICATION_MODAL);

            showNotizFXDetails(notizFX);
            this.dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    */

    @FXML
    public void showNotizFXDetails(NotizFX notizFX){

        ObjectProperty<Date> erinnerung = notizFX.getFaelligkeit();


        notizNameField.setText(notizFX.getTitle().getValue());

        notizBearbeitungszustandField.setText(notizFX.getBearbeitungszustandID().getValue().toString());

        kategorieNameField.setText(notizFX.getKategorieID().getValue().toString());

        notizBeschreibungTextArea.setText(notizFX.getBeschreibung().getValue());

        notizFaelligkeitField.setText(erinnerung.getValue().toString());

       notizPrioritaetCheckBox.setSelected(notizFX.getPrioritaet().getValue());


    }

    @FXML
    private void handleBtnCancel(){

        System.out.println("Tes2t");
        //TODO Ist aus einem Grund null
        dialogStage.close();

    }

    public void setDialogStage(Stage stage){
        this.dialogStage = stage;
    }

}
