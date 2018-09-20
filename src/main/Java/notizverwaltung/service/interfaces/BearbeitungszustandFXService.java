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

    public BearbeitungszustandFX wrapBearbeitzungszustandInBearbeitungszustandFX (Bearbeitungszustand bearbeitungszustand);
    public Bearbeitungszustand wrapBearbeitungszustandFXinBearbeitungszustand (BearbeitungszustandFX bearbeitungszustandFX);
    public List<BearbeitungszustandFX> convertInBearbeitungszustandFXList(List<Bearbeitungszustand> bearbeitungszustandListe);
}
