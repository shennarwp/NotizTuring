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
 * @author Agra Bimantara
 */

public class NotizblockDAOImpl extends ObjectDAOImpl implements NotizblockDAO {
    @Override
    public NotizblockImpl getNotizblock() {
        return null;
    }

    @Override
    public int addNotizblock(NotizblockImpl notizblockImpl) {
        return 0;
    }


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
