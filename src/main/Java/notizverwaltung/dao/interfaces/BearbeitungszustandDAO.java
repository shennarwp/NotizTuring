package notizverwaltung.dao.interfaces;

import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Notiz;

import java.util.List;

/**
 * @author Agra Bimantara
 */

public interface BearbeitungszustandDAO extends ObjectDAO {

    public int addBearbeitungszustand (Bearbeitungszustand bearbeitungszustand);
    public Bearbeitungszustand getBearbeitungszustand(int bearbeitungszustandID);

    List<Bearbeitungszustand> getAlleBearbeitungszustand();

    public int istBearbeitungszustandExist(String bearbeitungszustand);
    public void updateBearbeitungszustand(Bearbeitungszustand bearbeitungszustand);
    public void deleteBearbeitungszustand (int bearbeitungszustandID);

    public List<Notiz> getAlleNotizenVonEinemBearbeitungszustand(int bearbeitungszustand);
    public List<Notiz> getAlleNotizenVomNotizblock (int NotizblockID);

}
