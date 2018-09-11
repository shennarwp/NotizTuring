package notizverwaltung.dao.classes;

import notizverwaltung.dao.interfaces.NotizDAO;
import notizverwaltung.model.classes.NotizImpl;
import notizverwaltung.model.interfaces.Notiz;

import javax.persistence.TypedQuery;
import java.util.List;


/**
 * @author Shenna RWP
 */
public class NotizDAOImpl extends ObjectDAOImpl implements NotizDAO
{
    public NotizDAOImpl() {
        super();
    }

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

    @Override
    public Notiz getNotiz(int notizID) {
        initTransaction();
        transaction.begin();

        Notiz notiz = entityManager.find(Notiz.class, notizID);
        if(notiz == null) {
            finishTransaction();
            throw new IllegalArgumentException("Notiz existiert nicht!");
        }

        finishTransaction();
        return notiz;
    }

    @Override
    public List<Notiz> getAlleNotizen() {
        initTransaction();
        transaction.begin();

        List<Notiz> listNotiz = entityManager.createQuery("SELECT n FROM NotizImpl n", Notiz.class).getResultList();

        transaction.commit();

        finishTransaction();
        return listNotiz;
    }

    @Override
    public void updateNotiz(NotizImpl notiz) {

    }

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

    @Override
    public List<Notiz> getAlleNotizenVonEinemBearbeitungszustand(int bearbeitungszustand) {
        initTransaction();
        transaction.begin();

        List<Notiz> listVomNotiz = entityManager
                .createQuery("SELECT n FROM NotizImpl n WHERE n.bearbeitungszustandID = :bearbeitungszustandID", Notiz.class)
                .setParameter("bearbeitungszustandID", bearbeitungszustand)
                .getResultList();

        transaction.commit();
        finishTransaction();

        return listVomNotiz;
    }



}
