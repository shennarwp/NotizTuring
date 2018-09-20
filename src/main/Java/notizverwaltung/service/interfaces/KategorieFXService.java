package notizverwaltung.service.interfaces;

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

    public KategorieFX wrapKategorieInKategorieFX (Kategorie kategorie);
    public Kategorie wrapKategorieFXInKategorie(KategorieFX kategorieFX);
    public List<KategorieFX> convertInKategorieFXList(List<Kategorie> kategorieListe);
}
