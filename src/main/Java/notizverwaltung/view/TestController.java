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



    //ObservableList observableList = FXCollections.observableArrayList();
    private ObservableList<Notiz> notizObservableList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        ArrayList<String> arrayList = new ArrayList<String>();

        arrayList.add("Item 1");
        arrayList.add("Item 2");
        arrayList.add("Item 3");



        List<Notiz> notizList = new NotizServiceImpl().getAlleNotizen();


        //observableList.setAll(stringSet);
        //listView.setItems(notizObservableList);
        //listView.setItems(notizObservableList);
        //initListViews();

        listView.setCellFactory(param -> new ListCell<Notiz>() {
            @Override
            protected void updateItem(Notiz item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getTitle() == null) {
                    setText("test");
                } else {
                    setText(item.getTitle());
                }
            }
        });

        System.out.println("test");

    }

    @FXML
    public void setListView(){

    }

    private void initListViews(){
        listView.setCellFactory(param -> new ListCell<Notiz>() {
            @Override
            protected void updateItem(Notiz item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getTitle() == null) {
                    setText("test");
                } else {
                    setText(item.getTitle());
                }
            }
        });

    }
}
