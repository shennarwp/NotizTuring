package notizverwaltung.service.interfaces;

import notizverwaltung.model.interfaces.Bearbeitungszustand;

import java.util.List;

/**
 * @author Shenna RWP
 */
public interface BearbeitungszustandService {

    public int addBearbeitungszustand (Bearbeitungszustand bearbeitungszustand);
    public Bearbeitungszustand getBearbeitungszustand (int bearbeitungszustandID);
    public void updateBearbeitungszustand (Bearbeitungszustand bearbeitungszustand);
    public void deleteBearbeitungszustand (int bearbeitungszustandID);
    public long getAnzahlNotizenInBearbeitungszustand(int bearbeitungszustandID);
    public List<Bearbeitungszustand> getAllBearbeitungszustand();

}
