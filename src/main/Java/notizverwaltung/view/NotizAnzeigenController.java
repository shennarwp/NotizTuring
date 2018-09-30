package notizverwaltung.view;

import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.model.interfaces.NotizFX;
import notizverwaltung.validators.ObjectValidator;


import java.io.IOException;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Klasse zum Anziegen des Inhalts einer Notiz
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


    /**
     * Die Methode entnimmt der NotizFX, welche uebergeben wurde, alle Informationen und
     * schreibt sie in die entsprechenden GUI Elemente
     * @param notizFX NotizFX Objekt
     * @throws ObjectIstNullException wirft eine Exception, wenn das Objekt null ist
     */
    @FXML
    public void showNotizFXDetails(NotizFX notizFX) throws ObjectIstNullException {
        ObjectValidator.checkObObjectNullIst(notizFX);

        ObjectProperty<Date> erinnerung = notizFX.getFaelligkeit();


        notizNameField.setText(notizFX.getTitle().getValue());

        notizBearbeitungszustandField.setText(notizFX.getBearbeitungszustandID().getValue().toString());

        kategorieNameField.setText(notizFX.getKategorieID().getValue().toString());

        notizBeschreibungTextArea.setText(notizFX.getBeschreibung().getValue());

        notizFaelligkeitField.setText(erinnerung.getValue().toString());

       notizPrioritaetCheckBox.setSelected(notizFX.getPrioritaet().getValue());


    }

    /**
     * Handler fuer den Cancel Button. Wenn der Button gedrueckt wird,
     * schliesst sich das Fenster
     */
    @FXML
    private void handleBtnCancel(){

        dialogStage.close();

    }

    /**
     * Die Methode setzt die Stage
     * @param stage Object
     * @throws ObjectIstNullException wirft eine Exception, wenn das Objekt null ist
     */
    public void setDialogStage(Stage stage)throws ObjectIstNullException{
        ObjectValidator.checkObObjectNullIst(stage);
        this.dialogStage = stage;
    }

}
