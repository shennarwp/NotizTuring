package notizverwaltung.dao.classes;

import notizverwaltung.dao.interfaces.BearbeitungszustandDAO;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Notiz;

import java.util.List;

/**
 * @author Agra Bimantara
 */

public class BearbeitungszustandDAOImpl implements BearbeitungszustandDAO {
    @Override
    public void addBearbeitungszustand(Bearbeitungszustand bearbeitungszustand) {

    }

    @Override
    public void deleteBearbeitungszustand(int bearbeitungszustand) {

    }

    @Override
    public List<Notiz> getAlleNotizenVonEinemBearbeitungszustand(int bearbeitungszustand) {
        return null;
    }

    @Override
    public List<Notiz> getAlleNotizenVomNotizblock(int NotizblockID) {
        return null;
    }
}
