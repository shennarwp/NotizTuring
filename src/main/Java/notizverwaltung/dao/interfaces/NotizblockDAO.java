package notizverwaltung.dao.interfaces;

import notizverwaltung.model.classes.NotizblockImpl;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Kategorie;

import java.util.List;

/**
 * @author Agra Bimantara
 */

public interface NotizblockDAO extends ObjectDAO {

    public int addNotizblock (NotizblockImpl notizblockImpl);
    public NotizblockImpl getNotizblock();
    public void deleteNotizblock(int notizblockID);

    public List<Kategorie> getAlleKategorienVomNotizblock(int notizblockID);
    public List<Bearbeitungszustand> getAlleBearbeitungszustaendeVomNotizblock(int notizblockID);
}
