package main.java.notizverwaltung.dao.interfaces;

import main.java.notizverwaltung.model.interfaces.Bearbeitungszustand;
import main.java.notizverwaltung.model.interfaces.Notiz;
import main.java.notizverwaltung.model.interfaces.Kategorie;

import java.util.List;

public interface BearbeitungszustandDAO {

    public void addBearbeitungszustand (Bearbeitungszustand bearbeitungszustand);
    public void deleteBearbeitungszustand (int bearbeitungszustand);

    public List<Notiz> getAlleNotizenVonEinemBearbeitungszustand(int bearbeitungszustand);
    public List<Notiz> getAlleNotizenVomNotizblock (int NotizblockID);

}
