package notizverwaltung.builders;


import notizverwaltung.dao.classes.*;
import notizverwaltung.dao.interfaces.*;

/**
 * @author Agra Bimantara
 * Erzeugt Implementierungen der DAO-Schicht.
 */
public class DaoObjectBuilder {

    public static NotizDAO getNotizDaoObject(){
        return new NotizDAOImpl();
    }

    public static BearbeitungszustandDAO getBearbeitungszustandDAOObject(){
        return new BearbeitungszustandDAOImpl();
    }

    public static NotizblockDAO getNotizblockDAOObject(){
        return new NotizblockDAOImpl();
    }

    public static KategorieDAO getKategorieDAOObject(){
        return new KategorieDAOImpl();
    }

    public static NutzerprofilDAO getNutzerprofilDAOObject(){
        return new NutzerprofilDAOImpl();
    }
}
