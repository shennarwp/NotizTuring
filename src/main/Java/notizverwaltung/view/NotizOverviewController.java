package notizverwaltung.view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import notizverwaltung.MainApp;
import notizverwaltung.builders.ServiceObjectBuilder;
import notizverwaltung.i18n.I18nComponentsUtil;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.classes.KategorieServiceImpl;
import notizverwaltung.service.interfaces.KategorieService;


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

    private KategorieService kategorieService = ServiceObjectBuilder.getKategorieService();

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setNotiz(Notiz notiz){
        this.notiz = notiz;

        if(notiz.getPrioritaet()){
            prioritaetLabel.setText(I18nComponentsUtil.getStandardPriorityHigh());
        }else{
            prioritaetLabel.setText(I18nComponentsUtil.getStandardPriorityLow());
        }

        datumLabel.setText(notiz.getFaelligkeit().toString());
        kategorieLabel.setText(kategorieService.findKategorieName(notiz.getKategorieID()));
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
}
