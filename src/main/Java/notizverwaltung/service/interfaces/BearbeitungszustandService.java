package notizverwaltung.service.interfaces;

import notizverwaltung.model.interfaces.Bearbeitungszustand;

import java.util.List;

/**
 * @author Shenna RWP
 */
public interface BearbeitungszustandService {

    //erstelle einen neue Bearbeitungszustand
    public int addBearbeitungszustand (Bearbeitungszustand bearbeitungszustand);

    //suche einen bestimmte Bearbeitungszustand
    public Bearbeitungszustand getBearbeitungszustand (int bearbeitungszustandID);

    //Inhalt von Bearbeitungszustand ändern
    public void updateBearbeitungszustand (Bearbeitungszustand bearbeitungszustand);

    //lösche einen bestimmte Bearbeitungszustand
    public void deleteBearbeitungszustand (int bearbeitungszustandID);

    //suche die Summe von Notizen in einem bestimmten Bearbeitungszustand
    public long getAnzahlNotizenInBearbeitungszustand(int bearbeitungszustandID);

    //suche die Liste von aller Bearbeitungszustände
    public List<Bearbeitungszustand> getAllBearbeitungszustand();

}
