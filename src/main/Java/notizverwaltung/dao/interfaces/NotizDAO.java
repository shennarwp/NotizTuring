package notizverwaltung.dao.interfaces;

import notizverwaltung.model.classes.NotizImpl;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;

import java.util.List;

/**
 * @author Agra Bimantara
 */

public interface NotizDAO extends ObjectDAO {

    public int addNotiz(Notiz notiz, int notizblockID);
    public Notiz getNotiz(int notizID);
    public void deleteNotiz(int notizID);
    public void updateNotiz (Notiz notiz);

    public List<Notiz> getAlleNotizen();
    public List<Notiz> getAlleNotizenvonEinerKategorie(int kategorieID);

    public List<Notiz> getAlleNotizenVomNotizblock(int notizblockID);



}
