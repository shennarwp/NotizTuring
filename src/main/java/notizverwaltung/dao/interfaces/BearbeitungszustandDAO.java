package notizverwaltung.dao.interfaces;

import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.model.interfaces.Kategorie;

import java.util.List;

/**
 * @author Agra Bimantara
 */

public interface BearbeitungszustandDAO {

    public void addBearbeitungszustand (Bearbeitungszustand bearbeitungszustand);
    public void deleteBearbeitungszustand (int bearbeitungszustand);

    public List<Notiz> getAlleNotizenVonEinemBearbeitungszustand(int bearbeitungszustand);
    public List<Notiz> getAlleNotizenVomNotizblock (int NotizblockID);

}
