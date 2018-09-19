package notizverwaltung.service.classes;

import notizverwaltung.builders.DaoObjectBuilder;
import notizverwaltung.dao.classes.BearbeitungszustandDAOImpl;
import notizverwaltung.dao.classes.NotizDAOImpl;
import notizverwaltung.dao.classes.NotizblockDAOImpl;
import notizverwaltung.dao.interfaces.NotizDAO;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.interfaces.NotizService;
import notizverwaltung.validators.IntValidator;
import notizverwaltung.validators.ObjectValidator;

import java.util.List;

/**
 *
 * Die Klasse stellt Funktionalitaeten für Notizen bereit
 *
 *
 * @author Tobias Gottschalk
 * @version 1.0
 * @since
 */
public class NotizServiceImpl implements NotizService {

    private NotizDAO notizDAO;


    /**
     * Konstruktor
     * @param notizDAO Nimmt ein NotizDAO Objekt entgegen
     * @throws ObjectIstNullException
     */
    public NotizServiceImpl(NotizDAO notizDAO) throws ObjectIstNullException {
        ObjectValidator.checkObObjectNullIst(notizDAO);
        this.notizDAO = notizDAO;

    }

    /**
     * Default Konstruktor
     * @throws ObjectIstNullException
     */
    public NotizServiceImpl() throws ObjectIstNullException {
        this(DaoObjectBuilder.getNotizDaoObject());
    }

    /**
     * Fuegt eine Notiz in die Datenbank ein
     * @param notiz Ein Notiz Objekt
     * @param notizblockID NotizblockID in welches die Notiz hinzugefuegt werden soll
     * @return Liefert den Primary Key des in der Datenbank erstellte Notizobjeckt zurueck
     */
    @Override
    public int addNotiz(Notiz notiz, int notizblockID) {
        //TODO Was passiert, wenn in DAO ein Fehler passiert?
        int notizID = notizDAO.addNotiz(notiz, notizblockID);
        IntValidator.checkObIntNullOderNegativIst(notizID);
        notiz.setID(notizID);
        return notizID;
    }

    /**
     * @param notizID nimmt eine NotizID entgegen
     * @return Liefert ein Notizobjekt zurueck
     */
    @Override
    public Notiz getNotiz(int notizID) {
        return notizDAO.getNotiz(notizID);
    }

    /**
     * Speichert ein Notizobjekt wieder in die Datenbank nachdem es geändert wurde
     * @param notiz Ein Notizobjekt
     */
    @Override
    public void updateNotiz(Notiz notiz) {
        ObjectValidator.checkObObjectNullIst(notiz);
        notizDAO.updateNotiz(notiz);
    }

    /**
     * Die Methode loescht eine Notiz aus der Datenbank
     * @param notizID Die ID der Notiz
     */
    @Override
    public void deleteNotiz(int notizID) {
        IntValidator.checkObIntNullOderNegativIst(notizID);
        notizDAO.deleteNotiz(notizID);

    }

    /**
     * @param kategorieID Die ID der Kategorie
     * @return Gibt eine Liste<Notiz> mit einer bestimmten Kategorie zurueck
     */
    @Override
    public List<Notiz> getAlleNotizenvonEinerKategorie(int kategorieID) {
        IntValidator.checkObIntNullOderNegativIst(kategorieID);
        return notizDAO.getAlleNotizenvonEinerKategorie(kategorieID);
    }



    //TODO
    @Override
    public List<Notiz> getAlleNotizenImNotizblock(int notizblockID) {
        IntValidator.checkObIntNullOderNegativIst(notizblockID);
        return notizDAO.getAlleNotizenVomNotizblock(notizblockID);
    }


    @Override
    public List<Notiz> getAlleNotizen()
    {
        return new NotizDAOImpl().getAlleNotizen();
    }

    @Override
    public List<Notiz> getAlleNotizenVonEinemBearbeitungszustand(int bearbeitungszustand)
    {
        IntValidator.checkObIntNullOderNegativIst(bearbeitungszustand);
        return new BearbeitungszustandDAOImpl().getAlleNotizenVonEinemBearbeitungszustand(bearbeitungszustand);
    }

    @Override
    public List<Notiz> getAlleNotizenVomNotizblock(int notizblockID)
    {
        IntValidator.checkObIntNullOderNegativIst(notizblockID);
        return new NotizblockDAOImpl().getAlleNotizenVomNotizblock(notizblockID);
    }

    @Override
    public List<Notiz> getAlleNotizenMitPrioritaet(boolean prioritaet){
        ObjectValidator.checkObObjectNullIst(prioritaet);
        return notizDAO.getAlleNotizenMitPrioritaet(prioritaet);
    }
}
