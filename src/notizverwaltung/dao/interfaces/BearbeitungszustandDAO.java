package notizverwaltung.dao.interfaces;

import notizverwaltung.model.classes.Notiz;
import notizverwaltung.model.interfaces.Bearbeitungszustand;

import java.util.List;

public interface BearbeitungszustandDAO {

    public void addBearbeitungszustand (Bearbeitungszustand bearbeitungszustand);
    public void deleteBearbeitungszustand (int bearbeitungszustand);

    public List<Notiz> getAlleNotizenVonEinemBearbeitungszustand(int bearbeitungszustand);
    public List<Notiz> getAlleNotizenVomNotizblock (int NotizblockID);

}
