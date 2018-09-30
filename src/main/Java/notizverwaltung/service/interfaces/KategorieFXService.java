package notizverwaltung.service.interfaces;

import javafx.beans.property.StringProperty;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.KategorieFX;

import java.util.List;

/**
 * Das Interface stellt die Methoden für die Serviceklasse bereit
 *
 * @author Kevin Engelhardt
 *
 * @version 1.0
 */

public interface KategorieFXService {
    /**
     * Wandelt Kategorie in KategorieFX um
     * @param kategorie
     * @return kategorieFX
     */
    public KategorieFX wrapKategorie(Kategorie kategorie);

    /**
     * Wandelt KategorieFX in Kategorie um
     * @param kategorieFX
     * @return kategorie
     */
    public Kategorie unwrapKategorieFX(KategorieFX kategorieFX);

    /**
     * Wandelt kategorieListe in kategorieFXListe um
     * @param kategorieListe
     * @return ategorieFXListe
     */
    public List<KategorieFX> convertInKategorieFXList(List<Kategorie> kategorieListe);

    /**
     * Gibt Kategorie Name mittels KategorieID zurueck
     * @param KategorieID
     * @return kategorieIDProperty
     */
    public StringProperty getKategorieNamePropertyVonKategorieID(int KategorieID);
}
