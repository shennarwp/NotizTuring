package notizverwaltung.dao.interfaces;

import notizverwaltung.model.classes.Notiz;

import java.util.List;

public interface NotizDAO {

    public void addNotiz(Notiz notiz);
    public Notiz getNotiz(int notizID);
    public void deleteNotiz(int noitzID);
    public void updateNotiz (Notiz notiz);



}
