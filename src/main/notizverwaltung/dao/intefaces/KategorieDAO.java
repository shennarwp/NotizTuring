package main.notizverwaltung.dao.intefaces;

import main.notizverwaltung.model.classes.Kategorie;

import java.util.List;

public interface KategorieDAO {

    public void addKategorie(Kategorie kategorie);
    public Kategorie getKategorie(int kategorieID);
    public void deleteKategorie( int kategorieID);
    public void modifiyKategorie(Kategorie kategorie);

    public List<Kategorie> getAlleKategorien();



}
