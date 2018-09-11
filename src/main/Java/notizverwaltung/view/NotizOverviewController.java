package notizverwaltung.view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import notizverwaltung.MainApp;
import notizverwaltung.i18n.I18nComponentsUtil;
import notizverwaltung.model.interfaces.Notiz;


public class NotizOverviewController {

    @FXML
    private Label prioritaetLabel;
    @FXML
    private Label datumLabel;
    @FXML
    private Label kategorieLabel;
    @FXML
    private Label notizLabel;
    @FXML
    private ComboBox spaltenWahlBox;

    private Notiz notiz;

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setNotiz(Notiz notiz){
        this.notiz = notiz;

        if(notiz.getPrioritaet()){
            prioritaetLabel.setText(I18nComponentsUtil.getStandardPriorityLow());
        }else{
            prioritaetLabel.setText(I18nComponentsUtil.getStandardPriorityHigh());
        }

        datumLabel.setText(notiz.getFaelligkeit().toString());
        kategorieLabel.setText(findKategorieName(notiz.getKategorieID()));
        notizLabel.setText(notiz.getTitle());
    }

    @FXML
    private void handleMoveLeft(){
        //TODO
    }

    @FXML
    private void handleMoveRight(){
        //TODO
    }

    private String findKategorieName(int KategorieID){
        //TODO
        return "Kategorie";
    }
}
