package main.notizverwaltung.service.interfaces;

import main.notizverwaltung.model.classes.Kategorie;

import java.util.List;

public interface KategorieService {
    public List<Kategorie> getAllKategorien();
    public void getKategorie(int kategorieID);
    public void updateKategorie (Kategorie kategorie);

    //Achtung nur löschen, wenn keine Artikel mehr eine Kategorie hat
    public void removeKategorie (Kategorie kategorie);

}
