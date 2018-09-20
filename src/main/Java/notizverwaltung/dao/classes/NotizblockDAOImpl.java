package notizverwaltung.dao.classes;

import notizverwaltung.dao.interfaces.NotizblockDAO;
import notizverwaltung.model.classes.KategorieImpl;
import notizverwaltung.model.classes.NotizblockImpl;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Klasse für Datenbank-Methode von Notizblock
 * @author Agra Bimantara
 */

public class NotizblockDAOImpl extends ObjectDAOImpl implements NotizblockDAO {

    /**
     * suche einer bestimmte Notizblock
     * @return null
     */
    @Override
    public NotizblockImpl getNotizblock() {
        return null;
    }

    /**
     * erstelle neuer Notizblock in Datenbank
     * @param notizblockImpl
     * @return neuer Notizblock
     */
    @Override
    public int addNotizblock(NotizblockImpl notizblockImpl) {
        return 0;
    }

    /**
     * lösche bestimmter Notizblock in Datenbank
     * @param notizblockID
     */
    @Override
    public void deleteNotizblock(int notizblockID) {
            initTransaction();
            transaction.begin();


            Bearbeitungszustand notizblock = entityManager.find(Bearbeitungszustand.class, notizblockID);
            if (notizblock == null){
                finishTransaction();
                throw new IllegalArgumentException("notizblock existiert nicht!");
            }

            entityManager.remove(notizblockID);
            transaction.commit();

            finishTransaction();
    }

    /**
     * suche alle vorhandenen Notizen von einem bestimmten Notizblock
     * @param notizblockID
     * @return alle vorhandenen Notizen von einem bestimmten Notizblock
     */
    @Override
    public List<Notiz> getAlleNotizenVomNotizblock(int notizblockID) {
        initTransaction();
        transaction.begin();

        List<Notiz> notizList = entityManager
                    .createQuery("SELECT n FROM NotizImpl n WHERE n.notizblockID = :notizblockID", Notiz.class)
                    .setParameter("notizblockID", notizblockID)
                    .getResultList();

        transaction.commit();
        finishTransaction();

        return notizList;
    }

    /**
     * suche alle vorhandenen Kategorien von einem bestimmten Notizblock
     * @param notizblockID
     * @return alle vorhandenen Kategorien von einem bestimmten Notizblock
     */
    @Override
    public List<Kategorie> getAlleKategorienVomNotizblock(int notizblockID) {
        initTransaction();
        transaction.begin();

        List<Kategorie> kategorieList = entityManager
                    .createQuery("SELECT k from KategorieImpl k, NotizImpl n WHERE k.kategorieID = n.kategorieID AND n.notizblockID = :notizblockID", Kategorie.class)
                    .setParameter("notizblockID", notizblockID)
                    .getResultList();

        transaction.commit();
        finishTransaction();

        return kategorieList;
    }

    /**
     * suche alle vorhandenen Bearbeitungszustände von einem bestimmten Notizblock
     * @param notizblockID
     * @return alle vorhandenen Bearbeitungszustände von einem bestimmten Notizblock
     */
    @Override
    public List<Bearbeitungszustand> getAlleBearbeitungszustaendeVomNotizblock(int notizblockID) {
        initTransaction();
        transaction.begin();

        List<Bearbeitungszustand> bearbeitungszustandList = entityManager
                .createQuery("SELECT b from BearbeitungszustandImpl b, NotizImpl n WHERE b.bearbeitungszustandID = n.bearbeitungszustandID AND n.notizblockID = :notizblockID", Bearbeitungszustand.class)
                .setParameter("notizblockID", notizblockID)
                .getResultList();

        transaction.commit();
        finishTransaction();

        return bearbeitungszustandList;
    }
}
