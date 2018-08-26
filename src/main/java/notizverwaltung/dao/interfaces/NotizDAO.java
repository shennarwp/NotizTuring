package notizverwaltung.dao.interfaces;

import notizverwaltung.model.classes.NotizImpl;
import notizverwaltung.model.interfaces.Notiz;

public interface NotizDAO {

    public void addNotiz(Notiz notiz, int notizblockID);
    public NotizImpl getNotiz(int notizID);
    public void deleteNotiz(int noitzID);
    public void updateNotiz (NotizImpl notiz);



}
