package main.notizverwaltung.dao.intefaces;

import main.notizverwaltung.model.classes.Notiz;

import java.util.List;

public interface NotizDAO {

    public void addNotiz(Notiz notiz);
    public Notiz getNotiz(int notizID);
    public void deleteNotiz(int noitzID);
    public void modifiyNotiz (Notiz notiz);


    public List<Notiz> getAlleNotizenVonEinemBearbeitungszustand(String bearbeitungszustand);
    public List<Notiz> getAlleNotizenVomNotizblock (int NotizblockID);


}
