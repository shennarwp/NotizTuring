package notizverwaltung.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import notizverwaltung.MainApp;
import notizverwaltung.constants.FXKonstanten;
import notizverwaltung.i18n.I18nComponentsUtil;
import notizverwaltung.i18n.I18nUtil;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Notiz;

import java.io.IOException;
import java.util.ResourceBundle;

public class BearbeitungszustandOverviewController {

    @FXML
    private TitledPane bearbeitungszustandTitle;
    @FXML
    private VBox notizen;

    private String name = I18nComponentsUtil.getStandardStatusName();
    private ObservableList<Notiz> notizListe;
    private Bearbeitungszustand bazs;

    private MainApp mainApp;

    public BearbeitungszustandOverviewController(){

    }

    @FXML
    private void initialize(){
        bearbeitungszustandTitle.setText(name);
    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;

        notizListe = mainApp.getNotizListe();
    }

    public void setBearbeitungszustand(Bearbeitungszustand bazs){
        this.bazs = bazs;
        bearbeitungszustandTitle.setText(this.bazs.getName());
    }

    public void ladeNotizen(){
        try{
            for(Notiz notiz : notizListe){
                if(this.bazs.getBearbeitungsZustandID() == notiz.getBearbeitungszustandID()){
                    FXMLLoader loader = new FXMLLoader();
                    ResourceBundle bundle = I18nUtil.getComponentsResourceBundle();
                    loader.setLocation(MainApp.class
                            .getResource(FXKonstanten.PFAD_NOTIZ_OVERVIEW_LAYOUT));
                    loader.setResources(bundle);
                    AnchorPane notizView = (AnchorPane) loader.load();

                    notizen.getChildren().add(notizView);

                    NotizOverviewController controller = loader.getController();
                    controller.setMainApp(mainApp);
                    controller.setNotiz(notiz);
                }
            }

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
