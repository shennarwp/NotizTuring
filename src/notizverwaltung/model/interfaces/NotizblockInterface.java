package notizverwaltung.model.interfaces;


import notizverwaltung.model.classes.Bearbeitungszustand;
import notizverwaltung.model.classes.Kategorie;

public interface NotizblockInterface {


    public void setNotizblockID(int notizblockID);
    public void getNotizblockID();

    public void addBearbeitungszustand(Bearbeitungszustand bearbeitungszustand);
    public void removeBearbeitungszustand(int BearbeitungszustandID);
    public Bearbeitungszustand getBearbeitungszustand(int BearbeitungszustandID);

    public void addKategorie(Kategorie kategorie);
    public void removeKategorie(int KategorieID);
    public Kategorie getKategorie(int KategorieID);

}

