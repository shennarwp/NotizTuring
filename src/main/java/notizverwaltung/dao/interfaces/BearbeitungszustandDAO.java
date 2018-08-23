package notizverwaltung.dao.interfaces;

import model.classes.NotizImpl;
import model.interfaces.Bearbeitungszustand;

import java.util.List;

public interface BearbeitungszustandDAO {

    public void addBearbeitungszustand (Bearbeitungszustand bearbeitungszustand);
    public void deleteBearbeitungszustand (int bearbeitungszustand);

    public List<NotizImpl> getAlleNotizenVonEinemBearbeitungszustand(int bearbeitungszustand);
    public List<NotizImpl> getAlleNotizenVomNotizblock (int NotizblockID);

}
