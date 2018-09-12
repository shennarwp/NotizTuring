package notizverwaltung.dao.classes;

import notizverwaltung.dao.interfaces.BearbeitungszustandDAO;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.model.classes.BearbeitungszustandImpl;


import javax.persistence.NoResultException;
import java.util.List;

/**
 * @author Agra Bimantara
 * @author Shenna RWP
 */

public class BearbeitungszustandDAOImpl extends ObjectDAOImpl implements BearbeitungszustandDAO
{
    public BearbeitungszustandDAOImpl() {
        super();
    }

    @Override
    public int addBearbeitungszustand(Bearbeitungszustand bearbeitungszustand) {
        initTransaction();
        transaction.begin();

        int bearbeitungszustandID = istBearbeitungszustandExist(bearbeitungszustand.getName());
        if( bearbeitungszustandID == -1) {
            entityManager.persist(bearbeitungszustand);
            transaction.commit();
            bearbeitungszustandID = bearbeitungszustand.getBearbeitungsZustandID();
        }

        finishTransaction();
        return bearbeitungszustandID ;
    }

    @Override
    public Bearbeitungszustand getBearbeitungszustand(int bearbeitungszustandID) {
        initTransaction();
        transaction.begin();

        Bearbeitungszustand bearbeitungszustand = entityManager.find(Bearbeitungszustand.class, bearbeitungszustandID);
        if(bearbeitungszustand == null) {
            finishTransaction();
            //throw new IllegalArgumentException("bearbeitungszustand existiert nicht!");
        }

        finishTransaction();
        return bearbeitungszustand;
    }

    @Override
    public List<Bearbeitungszustand> getAlleBearbeitungszustand() {
        initTransaction();
        transaction.begin();

        List<Bearbeitungszustand> listBearbeitungszutand = entityManager.createQuery("SELECT n FROM BearbeitungszustandImpl n").getResultList();
        transaction.commit();

        finishTransaction();
        return listBearbeitungszutand;
    }

    @Override
    public int istBearbeitungszustandExist(String bearbeitungszustand) {
        initTransaction();
        transaction.begin();

        int bearbeitungszustandID = -1;
        try {
            bearbeitungszustandID = entityManager
                    .createQuery("SELECT b.bearbeitungszustandID FROM BearbeitungszustandImpl b WHERE b.nameDerSpalte LIKE :name", Integer.class)
                    .setParameter("name", bearbeitungszustand)
                    .getSingleResult();
        } catch(NoResultException e) {
            e.printStackTrace();
        }

        return bearbeitungszustandID;
    }

    @Override
    public void updateBearbeitungszustand(Bearbeitungszustand bearbeitungszustand) {
        initTransaction();
        transaction.begin();

        Bearbeitungszustand updatedBearbeitungszustand = entityManager.find(BearbeitungszustandImpl.class, bearbeitungszustand.getBearbeitungsZustandID());
        if (updatedBearbeitungszustand == null){
            finishTransaction();
            throw new IllegalArgumentException("Bearbeitungszustand existiert nicht!");
        }
        entityManager.merge(bearbeitungszustand);

        transaction.commit();
        finishTransaction();

    }

    @Override
    public void deleteBearbeitungszustand(int bearbeitungszustandID) {
        initTransaction();
        transaction.begin();

        Bearbeitungszustand bearbeitungszustandZuLoeschen = entityManager.find(BearbeitungszustandImpl.class, bearbeitungszustandID);
        if (bearbeitungszustandZuLoeschen == null){
            finishTransaction();
            throw new IllegalArgumentException("Bearbeitungszustand existiert nicht!");
        }

        entityManager.remove(bearbeitungszustandZuLoeschen);
        transaction.commit();

        finishTransaction();
    }

    @Override
    public long getAnzahlNotizenInBearbeitungszustand(int bearbeitungszustandID) {
        initTransaction();
        transaction.begin();

        long anzahlNotizen = entityManager.createQuery("SELECT COUNT(n.notizID) FROM NotizImpl n WHERE n.bearbeitungszustandID = :bearbeitungszustandID", Long.class)
                .setParameter("bearbeitungszustandID", bearbeitungszustandID )
                .getSingleResult();
        transaction.commit();
        finishTransaction();

        return anzahlNotizen;
    }

    @Override
    public List<Notiz> getAlleNotizenVonEinemBearbeitungszustand(int bearbeitungszustandID) {
        initTransaction();
        transaction.begin();

        List<Notiz> notizList = entityManager
                .createQuery("SELECT n FROM NotizImpl n WHERE n.bearbeitungszustandID = :bearbeitungszustandID", Notiz.class)
                .setParameter("bearbeitungszustandID", bearbeitungszustandID)
                .getResultList();

        transaction.commit();
        finishTransaction();

        return notizList;
    }

    @Override
    public List<Bearbeitungszustand> getAlleBearbeitungszustaendeVomNotizblock(int notizblockID)
    {

        initTransaction();
        transaction.begin();

        List<Bearbeitungszustand> listBearbeitungszutand = entityManager
                .createQuery("SELECT b from BearbeitungszustandImpl b WHERE b.bearbeitungszustandID =" +
                        "(SELECT n.bearbeitungszustandID FROM NotizImpl n WHERE n.notizblockID = :notizblockID)", Bearbeitungszustand.class)
                .setParameter("notizblockID", notizblockID)
                .getResultList();
        transaction.commit();

        finishTransaction();
        return listBearbeitungszutand;

    }


}
