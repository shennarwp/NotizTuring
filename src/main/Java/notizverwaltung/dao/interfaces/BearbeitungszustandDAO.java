package notizverwaltung.dao.interfaces;

import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Notiz;

import java.util.List;

/**
 * Interface-Klasse für BearbeitungszutandDaoImpl
 * @author Agra Bimantara
 */

public interface BearbeitungszustandDAO extends ObjectDAO {

    //erstelle neue Bearbeitungszustand in Datenbank
    public int addBearbeitungszustand (Bearbeitungszustand bearbeitungszustand);

    //suche einer bestimmte Bearbeitungszustand
    public Bearbeitungszustand getBearbeitungszustand(int bearbeitungszustandID);

    //suche Liste von alle vorhandenen Bearbeitungszustände in Datenbank
    List<Bearbeitungszustand> getAlleBearbeitungszustand();

    //prüfe, ob der Bearbeitungszutand existiert oder nicht
    public int istBearbeitungszustandExist(String bearbeitungszustand);

    //Bearbeitungszutand in Datenbank ändern
    public void updateBearbeitungszustand(Bearbeitungszustand bearbeitungszustand);

    //lösche bestimmter Bearbeitungszutand in Datenbank
    public void deleteBearbeitungszustand (int bearbeitungszustandID);

    //suche die Summe von alle Notizen in einem bestimmten Bearbeitungszutand
    public long getAnzahlNotizenInBearbeitungszustand(int bearbeitungszustandID);

    //suche alle vorhandenen Notizen von einem bestimmten Bearbeitungszustand
    public List<Notiz> getAlleNotizenVonEinemBearbeitungszustand(int bearbeitungszustand);

    //suche alle vorhandenen Bearbeitungszustände von einem bestimmten Notizblock
    List<Bearbeitungszustand> getAlleBearbeitungszustaendeVomNotizblock(int notizblockID);
}
