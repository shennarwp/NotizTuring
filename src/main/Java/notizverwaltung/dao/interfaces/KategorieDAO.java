package notizverwaltung.dao.interfaces;

import notizverwaltung.model.interfaces.Kategorie;

import java.util.List;

/**
 * Interface-Klasse für KategorieDaoImpl
 * @author Agra Bimantara
 */

public interface KategorieDAO extends ObjectDAO {

    //erstelle neue Kategorie in Datenbank
    public int addKategorie(Kategorie kategorie);

    //suche eine bestimmte Kategorie
    public Kategorie getKategorie(int kategorieID);

    //prüfe, ob die Kategorie existiert oder nicht
    public int istKategorieExist(String kategorieName);

    //Kategorie in Datenbank ändern
    public void updateKategorie(Kategorie kategorie);

    //lösche bestimmte Kategorie in Datenbank
    public void deleteKategorie(int kategorieID);

    //suche die Summe von alle Notizen in einer bestimmten Kategorie
    public long getAnzahlNotizenInKategorie(int kategorieID);

    //suche Liste von alle vorhandenen Kategorien in Datenbank
    public List<Kategorie> getAlleKategorien();

    public String getKategorieNameVonKategorieID(int kategorieID);



}
