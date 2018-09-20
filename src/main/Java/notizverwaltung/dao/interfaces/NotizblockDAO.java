package notizverwaltung.dao.interfaces;

import notizverwaltung.model.classes.NotizblockImpl;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;

import java.util.List;

/**
 * Interface-Klasse für NotizblockDaoImpl
 * @author Agra Bimantara
 */

public interface NotizblockDAO extends ObjectDAO {

    //erstelle neuer Notizblock in Datenbank
    public int addNotizblock (NotizblockImpl notizblockImpl);

    //suche einer bestimmte Notizblock
    public NotizblockImpl getNotizblock();

    //lösche bestimmter Notizblock in Datenbank
    public void deleteNotizblock(int notizblockID);

    //suche alle vorhandenen Notizen von einem bestimmten Notizblock
    public List<Notiz> getAlleNotizenVomNotizblock(int notizblockID);

    //suche alle vorhandenen Kategorien von einem bestimmten Notizblock
    public List<Kategorie> getAlleKategorienVomNotizblock(int notizblockID);

    //suche alle vorhandenen Bearbeitungszustände von einem bestimmten Notizblock
    public List<Bearbeitungszustand> getAlleBearbeitungszustaendeVomNotizblock(int notizblockID);
}
