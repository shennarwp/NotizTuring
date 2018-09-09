package notizverwaltung.dao.classes;

import notizverwaltung.dao.interfaces.KategorieDAO;
import notizverwaltung.model.interfaces.Kategorie;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * @author Agra Bimantara
 * @author Shenna RWP
 */

public class KategorieDAOImpl extends ObjectDAOImpl implements KategorieDAO
{
    public KategorieDAOImpl() {
        super();
    }

    @Override
    public int addKategorie(Kategorie kategorie) {
        initTransaction();
        transaction.begin();

        int kategorieID = istKategorieExist(kategorie.getKategorieName());
        if( kategorieID == -1) {
            entityManager.persist(kategorie);
            transaction.commit();
            kategorieID = kategorie.getKategorieID();
        }

        finishTransaction();
        return kategorieID;
    }

    @Override
    public Kategorie getKategorie(int kategorieID) {
        initTransaction();
        transaction.begin();

        Kategorie kategorie = entityManager.find(Kategorie.class, kategorieID);
        if(kategorie == null) {
            finishTransaction();
            //throw new IllegalArgumentException("kategorie existiert nicht!");
        }

        finishTransaction();
        return kategorie;
    }

    @Override
    public int istKategorieExist(String kategorieName) {
        initTransaction();
        transaction.begin();

        int kategorieID = -1;
        try {
            kategorieID = entityManager
                    .createQuery("SELECT k.kategorieID FROM KategorieImpl k WHERE k.kategorieName LIKE :name", Integer.class)
                    .setParameter("name", kategorieName)
                    .getSingleResult();
        } catch(NoResultException e) {
            e.printStackTrace();
        }

        return kategorieID;
    }



    @Override
    public void updateKategorie(Kategorie kategorie) {

    }

    @Override
    public void deleteKategorie(int kategorieID) {

    }

    @Override
    public List<Kategorie> getAlleKategorien() {
        initTransaction();
        transaction.begin();
        List<Kategorie> listKategorie = entityManager.createQuery("SELECT k FROM KategorieImpl k").getResultList();
        transaction.commit();
        finishTransaction();

        return listKategorie;

    }

}
