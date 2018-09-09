package notizverwaltung.dao.classes;

import notizverwaltung.dao.interfaces.BearbeitungszustandDAO;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Notiz;


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

        List<Bearbeitungszustand> listBearbeitungszutand = entityManager.createQuery("SELECT n FROM BearbeitungszutandImpl n").getResultList();
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

    }

    @Override
    public void deleteBearbeitungszustand(int bearbeitungszustandID) {
        initTransaction();
        transaction.begin();

        Bearbeitungszustand bearbeitungszustandZuLoeschen = entityManager.find(Bearbeitungszustand.class, bearbeitungszustandID);
        if (bearbeitungszustandZuLoeschen == null){
            finishTransaction();
            throw new IllegalArgumentException("Bearbeitungszustand existiert nicht!");
        }

        entityManager.remove(bearbeitungszustandZuLoeschen);
        transaction.commit();

        finishTransaction();
    }

//TODO hier muss noch bearbeiten
    @Override
    public List<Notiz> getAlleNotizenVonEinemBearbeitungszustand(int bearbeitungszustand) {
        return null;
    }

    @Override
    public List<Notiz> getAlleNotizenVomNotizblock(int NotizblockID)
    {
        return new NotizDAOImpl().getAlleNotizen();
    }

    @Override
    public List<Bearbeitungszustand> getAlleBearbeitungszustaendeVomNotizblock(int bearbeitungszustand)
    {
        return new BearbeitungszustandDAOImpl().getAlleBearbeitungszustand();
    }


}
