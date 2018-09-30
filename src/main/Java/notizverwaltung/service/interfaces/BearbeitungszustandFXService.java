package notizverwaltung.service.interfaces;

import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.BearbeitungszustandFX;

import java.util.List;

/**
 * Das Interface stellt die Methoden für die Serviceklasse bereit
 *
 * @author Kevin Engelhardt
 *
 * @version 1.0
 */

public interface BearbeitungszustandFXService {
    //Wandelt Bearbeitungszustand in BearbeitungszustandFX um
    public BearbeitungszustandFX wrapBearbeitungszustand(Bearbeitungszustand bearbeitungszustand);
    //Wandelt BearbeitungszustandFX in Bearbeitungszustand um
    public Bearbeitungszustand unwrapBearbeitungszustandFX(BearbeitungszustandFX bearbeitungszustandFX);
    //Wandelt bearbeitungszustandListe in bearbeitungszustandFXListe um
    public List<BearbeitungszustandFX> convertInBearbeitungszustandFXList(List<Bearbeitungszustand> bearbeitungszustandListe);
}
