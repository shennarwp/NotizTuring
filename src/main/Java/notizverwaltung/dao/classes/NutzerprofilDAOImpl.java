package notizverwaltung.dao.classes;

import notizverwaltung.dao.interfaces.NutzerprofilDAO;
import notizverwaltung.model.classes.NutzerprofilImpl;

/**
 * @author Agra Bimantara
 */

public class NutzerprofilDAOImpl extends ObjectDAOImpl implements NutzerprofilDAO {

    /**
     * erstelle neuer Nutzerprofil in Datenbank
     * @param nutzerprofilImpl
     * @return
     */
    @Override
    public int addNutzerprofil(NutzerprofilImpl nutzerprofilImpl) {
        return 0;
    }

    /**
     * suche einer bestimmte Nutzerprofil
     * @param NutzerprofilID
     * @return
     */
    @Override
    public NutzerprofilImpl getNutzerprofil(int NutzerprofilID) {
        return null;
    }

    /**
     * lösche bestimmter Nutzerprofil in Datenbank
     * @param nutzerprofilImpl
     */
    @Override
    public void deleteNutzerprofil(NutzerprofilImpl nutzerprofilImpl) {

    }

    /**
     * Nutzerprofil in Datenbank ändern
     * @param nutzerprofilImpl
     */
    @Override
    public void updateNutzerprofil(NutzerprofilImpl nutzerprofilImpl) {

    }


}
