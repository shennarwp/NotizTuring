package notizverwaltung.service.interfaces;

import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.model.interfaces.Kategorie;

import java.util.List;


/**
 *
 * Die Klasse stellt Funktionalitäten für Kategorien bereit
 *
 *
 * @author Tobias Gottschalk
 * @version 1.0
 * @since
 */
public interface KategorieService {

    public int addKategorie(Kategorie kategorie) throws IntIstNegativException;
    public Kategorie getKategorie(int kategorieID);
    public void updateKategorie (Kategorie kategorie);

    //Achtung nur löschen, wenn keine Artikel mehr eine Kategorie hat
    public void deleteKategorie (int kategorieID);
    public long getAnzahlNotizenInKategorie(int kategorieID);

    public List<Kategorie> getAlleKategorien();

    public String findKategorieName(int kategorieID);

}
