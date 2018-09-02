package notizverwaltung.service.interfaces;

import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.model.interfaces.Kategorie;

import java.util.List;

public interface KategorieService {

    public int addKategorie(Kategorie kategorie) throws IntIstNegativException;
    public Kategorie getKategorie(int kategorieID);
    public void updateKategorie (Kategorie kategorie);

    //Achtung nur löschen, wenn keine Artikel mehr eine Kategorie hat
    public void deleteKategorie (int kategorieID);

    public List<Kategorie> getAllKategorien();

}
