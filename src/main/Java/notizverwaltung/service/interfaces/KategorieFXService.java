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
     * Methode wandelt Kategorie in KategorieFX um
     * @param kategorie
     * @return kategorieFX
     */
    public KategorieFX wrapKategorie(Kategorie kategorie);

    /**
     * Methode wandelt KategorieFX in Kategorie um
     * @param kategorieFX
     * @return kategorie
     */
    public Kategorie unwrapKategorieFX(KategorieFX kategorieFX);

    /**
     * Methode wandelt KategorieListe in KategorieFX Liste um
     * @param kategorieListe
     * @return kategorieFXListe
     */
    public List<KategorieFX> convertInKategorieFXList(List<Kategorie> kategorieListe);

    /**
     * Die Methode liefert zu einer KategorieID eine Stringproperty zurueck
     * @param KategorieID
     * @return kategorieIDProperty
     */
    public StringProperty getKategorieNamePropertyVonKategorieID(int KategorieID);
}
