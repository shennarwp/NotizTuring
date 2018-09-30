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

    //Methode wandelt Kategorie in KategorieFX um
    public KategorieFX wrapKategorie(Kategorie kategorie);

    //Methode wandelt KategorieFX in Kategorie um
    public Kategorie unwrapKategorieFX(KategorieFX kategorieFX);

    // Methode wandelt KategorieListe in KategorieFX Liste um
    public List<KategorieFX> convertInKategorieFXList(List<Kategorie> kategorieListe);

    //Die Methode liefert zu einer KategorieID eine Stringproperty mit dem Name der
    public StringProperty getKategorieNamePropertyVonKategorieID(int KategorieID);
}
