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
    /**
     * Wandelt Bearbeitungszustand in BearbeitungszustandFX um
     * @param bearbeitungszustand
     * @return bearbeitungszustandFX
     */
    public BearbeitungszustandFX wrapBearbeitungszustand(Bearbeitungszustand bearbeitungszustand);

    /**
     * Wandelt BearbeitungszustandFX in Bearbeitungszustand um
     * @param bearbeitungszustandFX
     * @return bearbeitungszustand
     */
    public Bearbeitungszustand unwrapBearbeitungszustandFX(BearbeitungszustandFX bearbeitungszustandFX);

    /**
     * Wandelt bearbeitungszustandListe in bearbeitungszustandFXListe um
     * @param bearbeitungszustandListe
     * @return  bearbeitungszustandFXListe
     */
    public List<BearbeitungszustandFX> convertInBearbeitungszustandFXList(List<Bearbeitungszustand> bearbeitungszustandListe);
}
