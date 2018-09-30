package notizverwaltung.dao.classes;

import notizverwaltung.dao.interfaces.NotizDAO;
import notizverwaltung.model.classes.NotizImpl;
import notizverwaltung.model.interfaces.Notiz;

import javax.persistence.TypedQuery;
import java.util.List;


/**
 * Klasse für Datenbank-Methode von Notiz
 * @author Shenna RWP
 * @author Agra Bimantara
 */
public class NotizDAOImpl extends ObjectDAOImpl implements NotizDAO
{
    /**
     * Standard-konstruktor, nutzt die Konstruktor von Object-DAO superclass damit die benötigte entitymanager erstellt werden
     */
    public NotizDAOImpl() {
        super();
    }


    /**
     * erstelle neue Notiz in Datenbank
     * @param notiz das Notiz-Objekt
     * @param notizblockID die ID von Notizblock
     * @return neue Notiz
     */
    @Override
    public int addNotiz(Notiz notiz, int notizblockID) {
        initTransaction();
        transaction.begin();

        entityManager.persist(notiz);
        transaction.commit();
        int notizID = notiz.getNotizID();

        finishTransaction();
        return notizID;
    }

    /**
     * suche eine bestimmte Notiz
     * @param notizID die ID von Notiz
     * @return gesuchte bestimmte Notiz
     */
    @Override
    public Notiz getNotiz(int notizID) {
        initTransaction();
        transaction.begin();

        Notiz notiz = entityManager.find(NotizImpl.class, notizID);
        if(notiz == null) {
            finishTransaction();
            throw new IllegalArgumentException("Notiz existiert nicht!");
        }

        finishTransaction();
        return notiz;
    }

    /**
     * suche alle vorhandenen Notizen in Datenbank
     * @return alle vorhandenen Notizen in Datenbank
     */
    @Override
    public List<Notiz> getAlleNotizen() {
        initTransaction();
        transaction.begin();

        List<Notiz> listNotiz = entityManager.createQuery("SELECT n FROM NotizImpl n", Notiz.class).getResultList();

        transaction.commit();

        finishTransaction();
        return listNotiz;
    }

    /**
     * die Notiz in Datenbank ändern
     * @param notiz das Notiz-Objekt
     */
    @Override
    public void updateNotiz(Notiz notiz) {
        initTransaction();
        transaction.begin();

        Notiz updatedNotiz = entityManager.find(NotizImpl.class, notiz.getNotizID());
        if(updatedNotiz == null) {
            finishTransaction();
            throw new IllegalArgumentException("Notiz existiert nicht!");
        }
        entityManager.merge(notiz);
        transaction.commit();

        finishTransaction();

    }

    /**
     * lösche bestimmte Notiz in Datenbank
     * @param notizID die ID von Notiz
     */
    @Override
    public void deleteNotiz(int notizID) {
        initTransaction();
        transaction.begin();

        Notiz notiz = entityManager.find(NotizImpl.class, notizID);
        if(notiz == null) {
            finishTransaction();
            throw new IllegalArgumentException("Notiz existiert nicht!");
        }
        entityManager.remove(notiz);
        transaction.commit();

        finishTransaction();
    }

    /**
     * suche alle vorhandenen Notizen von einem bestimmten Notizblock
     * @param notizblockID die ID von Notizblock
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
     * suche alle vorhandenen Notizen von einer bestimmten Kategorie
     * @param kategorieID die ID von Kategorie
     * @return alle vorhandenen Notizen von einer bestimmten Kategorie
     */
    @Override
    public List<Notiz> getAlleNotizenvonEinerKategorie(int kategorieID) {
       initTransaction();
       transaction.begin();

       List<Notiz> notizList = entityManager.createQuery("SELECT n FROM NotizImpl n WHERE n.kategorieID = :kategorieID", Notiz.class)
               .setParameter("kategorieID", kategorieID)
               .getResultList();

        transaction.commit();
        finishTransaction();

        return notizList;
    }

    /**
     * suche alle vorhandenen Notizen von einer bestimmten Priorität
     * @param prioritaet true, falls prioritaet gesetzt werden
     * @return alle vorhandenen Notizen von einer bestimmten Priorität
     */
    @Override
    public List<Notiz> getAlleNotizenMitPrioritaet(boolean prioritaet) {
        initTransaction();
        transaction.begin();

        List<Notiz> notizList = entityManager.createQuery("SELECT n FROM NotizImpl n WHERE n.prioritaet = :prioritaet", Notiz.class)
                .setParameter("prioritaet", prioritaet)
                .getResultList();

        transaction.commit();
        finishTransaction();

        return notizList;

    }
}
