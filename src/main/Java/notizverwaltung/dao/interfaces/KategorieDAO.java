package notizverwaltung.dao.interfaces;

import notizverwaltung.model.interfaces.Kategorie;

import java.util.List;

/**
 * @author Agra Bimantara
 */

public interface KategorieDAO extends ObjectDAO {

    public int addKategorie(Kategorie kategorie);
    public Kategorie getKategorie(int kategorieID);
    public int istKategorieExist(String kategorieName);
    public void updateKategorie(Kategorie kategorie);
    public void deleteKategorie( int kategorieID);

    public List<Kategorie> getAlleKategorien();



}
