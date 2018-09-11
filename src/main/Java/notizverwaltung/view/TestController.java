package notizverwaltung.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.classes.NotizServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestController {

    @FXML
    private ListView listView;
    private Set<String> stringSet;


    ObservableList observableList = FXCollections.observableArrayList();


    @FXML
    private void initialize() {

        ArrayList<String> arrayList = new ArrayList<String>();

        arrayList.add("Item 1");
        arrayList.add("Item 2");
        arrayList.add("Item 3");



        List<Notiz> notizList = new NotizServiceImpl().getAlleNotizen();

        


        ObservableList<Notiz> obsList= FXCollections.observableArrayList(notizList);




        //observableList.setAll(stringSet);
        listView.setItems(obsList);

    }

    @FXML
    public void setListView(){

    }
}
