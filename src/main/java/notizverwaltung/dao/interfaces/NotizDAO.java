package notizverwaltung.dao.interfaces;

import model.classes.NotizImpl;

public interface NotizDAO {

    public void addNotiz(NotizImpl notiz);
    public NotizImpl getNotiz(int notizID);
    public void deleteNotiz(int noitzID);
    public void updateNotiz (NotizImpl notiz);



}
