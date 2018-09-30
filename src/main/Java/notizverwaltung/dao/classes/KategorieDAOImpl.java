package notizverwaltung.dao.classes;

import javafx.beans.property.StringProperty;
import notizverwaltung.dao.interfaces.KategorieDAO;
import notizverwaltung.model.classes.KategorieImpl;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Kategorie;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Klasse für Datenbank-Methode von Kategorie
 * @author Agra Bimantara
 * @author Shenna RWP
 */

public class KategorieDAOImpl extends ObjectDAOImpl implements KategorieDAO
{
    /**
     * Standard-konstruktor, nutzt die Konstruktor von Object-DAO superclass damit die benötigte entitymanager erstellt werden
     */
    public KategorieDAOImpl() {
        super();
    }

    /**
     * erstelle neue Kategorie in Datenbank
     * @param kategorie das Kategorie-Objekt
     * @return neue Kategorie
     */
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

    /**
     * suche eine bestimmte Kategorie
     * @param kategorieID die ID von Kategorie
     * @return bestimmte Kategorie
     */
    @Override
    public Kategorie getKategorie(int kategorieID) {
        initTransaction();
        transaction.begin();

        Kategorie kategorie = entityManager.find(KategorieImpl.class, kategorieID);
        if(kategorie == null) {
            finishTransaction();
            throw new IllegalArgumentException("kategorie existiert nicht!");
        }

        finishTransaction();
        return kategorie;
    }

    /**
     * prüfe, ob die Kategorie existiert oder nicht
     * @param kategorieName die Kategoriename
     * @return bestimmte Kategorie
     */
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

    /**
     * Kategorie in Datenbank ändern
     * @param kategorie das Kategorie-Objekt
     */
    @Override
    public void updateKategorie(Kategorie kategorie) {
        initTransaction();
        transaction.begin();

        Kategorie updatedKategorie = entityManager.find(KategorieImpl.class, kategorie.getKategorieID());
        if (updatedKategorie == null){
            finishTransaction();
            throw new IllegalArgumentException("kategorie existiert nicht!");
        }

        entityManager.merge(kategorie);
        transaction.commit();

        finishTransaction();
    }

    /**
     * lösche bestimmte Kategorie in Datenbank
     * @param kategorieID die ID von Kategorie
     */
    @Override
    public void deleteKategorie(int kategorieID) {
        initTransaction();
        transaction.begin();


        Kategorie kategorie = entityManager.find(KategorieImpl.class, kategorieID);
        if (kategorie == null){
            finishTransaction();
            throw new IllegalArgumentException("kategorie existiert nicht!");
        }

        entityManager.remove(kategorie);
        transaction.commit();

        finishTransaction();
    }

    /**
     * suche die Summe von alle Notizen in einer bestimmten Kategorie
     * @param kategorieID die ID von Kategorie
     * @return die Summe von alle Notizen in einer bestimmten Kategorie
     */
    @Override
    public long getAnzahlNotizenInKategorie(int kategorieID) {
        initTransaction();
        transaction.begin();

        long anzahlNotizen = entityManager.createQuery("SELECT COUNT(n.notizID) FROM NotizImpl n WHERE n.kategorieID = :kategorieID", Long.class)
                                    .setParameter("kategorieID", kategorieID )
                                    .getSingleResult();
        transaction.commit();
        finishTransaction();
        return anzahlNotizen;
    }

    /**
     * suche Liste von alle vorhandenen Kategorien in Datenbank
     * @return Liste von alle vorhandenen Kategorien in Datenbank
     */
    @Override
    public List<Kategorie> getAlleKategorien() {
        initTransaction();
        transaction.begin();
        List<Kategorie> listKategorie = entityManager.createQuery("SELECT k FROM KategorieImpl k").getResultList();
        transaction.commit();
        finishTransaction();

        return listKategorie;
    }

    /**
     * suche Kategoriename anhand deren ID
     * @param kategorieID die ID von den gesuchten Kategorie
     * @return die Kategoriename
     */
    public String getKategorieNameVonKategorieID(int kategorieID) {
        initTransaction();
        transaction.begin();
        String kategorieName = entityManager.createQuery("SELECT k.kategorieName FROM KategorieImpl k WHERE k.kategorieID = :id", String.class)
                                .setParameter("id", kategorieID)
                                .getSingleResult();



        transaction.commit();
        finishTransaction();

        return kategorieName;
    }

}
