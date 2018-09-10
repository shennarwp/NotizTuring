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
 *
 * @author Shenna RWP
 */
public class DaoObjectBuilder
{

    public static NotizDAO getNotizDaoObject() {
        return new NotizDAOImpl();
    }

    public static KategorieDAO getKategorieDaoObject() {
        return new KategorieDAOImpl();
    }

    public static BearbeitungszustandDAO getBearbeitungszustandDaoObject() {
        return new BearbeitungszustandDAOImpl();
    }

    public static NotizblockDAO getNotizblockDaoObject() {
        return new NotizblockDAOImpl();
    }
}
