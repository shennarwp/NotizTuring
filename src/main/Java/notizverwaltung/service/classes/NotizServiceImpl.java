package notizverwaltung.service.classes;

import notizverwaltung.builders.DaoObjectBuilder;
import notizverwaltung.dao.classes.BearbeitungszustandDAOImpl;
import notizverwaltung.dao.classes.NotizDAOImpl;
import notizverwaltung.dao.interfaces.NotizDAO;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.model.classes.NotizImpl;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.interfaces.NotizService;
import notizverwaltung.validators.IntValidator;
import notizverwaltung.validators.ObjectValidator;

import java.util.List;

/**
 *
 * Die Klasse stellt Funktionalitäten für Notizen bereit
 *
 *
 * @author Tobias Gottschalk
 * @version 1.0
 * @since
 */
public class NotizServiceImpl implements NotizService {

    private NotizDAO notizDAO;

    //TODO Olbertz hat den Konstruktor so in seinem Beispiel aufgebaut. Warum sollte man das machen? Kann man es auch weglassen -> abklären
    public NotizServiceImpl(NotizDAO notizDAO) throws ObjectIstNullException {
        ObjectValidator.checkObObjectNullIst(notizDAO);
        this.notizDAO = notizDAO;

    }

    public NotizServiceImpl() throws ObjectIstNullException {
        this(DaoObjectBuilder.getNotizDaoObject());
    }

    @Override
    public int addNotiz(Notiz notiz, int notizblockID) {
        //TODO Was passiert, wenn in DAO ein Fehler passiert?
        int notizID = notizDAO.addNotiz(notiz, notizblockID);
        IntValidator.checkObIntNullOderNegativIst(notizID);
        notiz.setID(notizID);
        return notizID;
    }

    @Override
    public Notiz getNotiz(int notizID) {
        return notizDAO.getNotiz(notizID);
    }

    @Override
    public void updateNotiz(Notiz notiz) {

    }

    @Override
    public void deleteNotiz(int notizID) {
        IntValidator.checkObIntNullOderNegativIst(notizID);
        notizDAO.deleteNotiz(notizID);

    }

    @Override
    public List<Notiz> getAlleNotizenvonEinerKategorie(Kategorie kategorie) {
        return null;
    }

    @Override
    public List<Notiz> getAlleNotizenImNotizblock(int notizblockID) {
        IntValidator.checkObIntNullOderNegativIst(notizblockID);
        return null;
    }
    @Override
    public List<Notiz> getAlleNotizen()
    {
        return new NotizDAOImpl().getAlleNotizen();
    }

    public List<Notiz> getAlleNotizenVonEinemBearbeitungszustand(int bearbeitungszustand) {
        IntValidator.checkObIntNullOderNegativIst(bearbeitungszustand);
        return new BearbeitungszustandDAOImpl().getAlleNotizenVonEinemBearbeitungszustand(bearbeitungszustand);
    }
    @Override
    public List<Notiz> getAlleNotizenVomNotizblock(int notizblockID)
    {
        IntValidator.checkObIntNullOderNegativIst(notizblockID);
        return new BearbeitungszustandDAOImpl().getAlleNotizenVomNotizblock(notizblockID);
    }
}
