package notizverwaltung.builders;

import notizverwaltung.dao.classes.BearbeitungszustandDAOImpl;
import notizverwaltung.dao.classes.KategorieDAOImpl;
import notizverwaltung.dao.classes.NotizDAOImpl;
import notizverwaltung.dao.classes.NotizblockDAOImpl;
import notizverwaltung.dao.interfaces.BearbeitungszustandDAO;
import notizverwaltung.dao.interfaces.KategorieDAO;
import notizverwaltung.dao.interfaces.NotizDAO;
import notizverwaltung.dao.interfaces.NotizblockDAO;

/**
 * DAO-Builder
 * ein Klasse für erstellung verschiedene DAO-Objekte
 * @author Shenna RWP
 */
public class DaoObjectBuilder
{

    /**
     * erstelle ein NotizDao-Objekt
     * @return Implementierung von NotizDAO
     */
    public static NotizDAO getNotizDaoObject() {
        return new NotizDAOImpl();
    }

    /**
     * erstelle ein KategorieDAO-Objekt
     * @return Implementierung von KategorieDAO
     */
    public static KategorieDAO getKategorieDaoObject() {
        return new KategorieDAOImpl();
    }

    /**
     * erstelle ein BearbeitungszustandDAO-Objekt
     * @return Implementierung von BearbeitungszustandDAO
     */
    public static BearbeitungszustandDAO getBearbeitungszustandDaoObject() {
        return new BearbeitungszustandDAOImpl();
    }

    /**
     * erstelle ein NotizblockDAO-Objekt
     * @return Implementierung von NotizblockDAO
     */
    public static NotizblockDAO getNotizblockDaoObject() {
        return new NotizblockDAOImpl();
    }
}
