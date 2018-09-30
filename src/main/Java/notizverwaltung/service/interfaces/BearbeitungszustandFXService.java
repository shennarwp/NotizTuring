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

    //Methode wandelt Bearbeitungszustand in BearbeitungszustandFX um
    public BearbeitungszustandFX wrapBearbeitungszustand(Bearbeitungszustand bearbeitungszustand);

    //Methode wandelt BearbeitungszustandFX in Bearbeitungszustand um
    public Bearbeitungszustand unwrapBearbeitungszustandFX(BearbeitungszustandFX bearbeitungszustandFX);

    //Methode wandelt BearbeitungszustandList in BearbeitungszustandFXList um
    public List<BearbeitungszustandFX> convertInBearbeitungszustandFXList(List<Bearbeitungszustand> bearbeitungszustandListe);
}
