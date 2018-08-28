package notizverwaltung.dao.interfaces;

import notizverwaltung.model.interfaces.Kategorie;

import java.util.List;

/**
 * @author Agra Bimantara
 */

public interface KategorieDAO {

    public void addKategorie(Kategorie kategorie);
    public Kategorie getKategorie(int kategorieID);
    public void deleteKategorie( int kategorieID);
    public void updateKategorie(Kategorie kategorie);

    public List<Kategorie> getAlleKategorien();



}
