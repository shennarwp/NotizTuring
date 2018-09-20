package notizverwaltung.dao.interfaces;

import notizverwaltung.model.classes.NotizImpl;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;

import java.util.List;

/**
 * Interface-Klasse für NotizDaoImpl
 * @author Agra Bimantara
 */

public interface NotizDAO extends ObjectDAO {

    //erstelle neue Notiz in Datenbank
    public int addNotiz(Notiz notiz, int notizblockID);

    //suche eine bestimmte Notiz
    public Notiz getNotiz(int notizID);

    //lösche bestimmte Notiz in Datenbank
    public void deleteNotiz(int notizID);

    //die Notiz in Datenbank ändern
    public void updateNotiz (Notiz notiz);

    //suche alle vorhandenen Notizen in Datenbank
    public List<Notiz> getAlleNotizen();

    //suche alle vorhandenen Notizen von einer bestimmten Kategorie
    public List<Notiz> getAlleNotizenvonEinerKategorie(int kategorieID);

    //suche alle vorhandenen Notizen von einer bestimmten Priorität
    public List<Notiz> getAlleNotizenMitPrioritaet(boolean prioritaet);

    //suche alle vorhandenen Notizen von einem bestimmten Notizblock
    public List<Notiz> getAlleNotizenVomNotizblock(int notizblockID);



}
