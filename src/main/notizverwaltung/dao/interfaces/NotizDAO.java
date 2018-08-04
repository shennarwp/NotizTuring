package main.notizverwaltung.dao.interfaces;

import main.notizverwaltung.model.classes.Notiz;

import java.util.List;

public interface NotizDAO {

    public void addNotiz(Notiz notiz);
    public Notiz getNotiz(int notizID);
    public void deleteNotiz(int noitzID);
    public void updateNotiz (Notiz notiz);


    public List<Notiz> getAlleNotizenVonEinemBearbeitungszustand(String bearbeitungszustand);
    public List<Notiz> getAlleNotizenVomNotizblock (int NotizblockID);


}
