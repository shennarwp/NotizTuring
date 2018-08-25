package main.java.notizverwaltung.dao.interfaces;

import main.java.notizverwaltung.model.interfaces.Kategorie;

import java.util.List;

public interface KategorieDAO {

    public void addKategorie(Kategorie kategorie);
    public Kategorie getKategorie(int kategorieID);
    public void deleteKategorie( int kategorieID);
    public void updateKategorie(Kategorie kategorie);

    public List<Kategorie> getAlleKategorien();



}
