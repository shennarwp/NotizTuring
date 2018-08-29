package notizverwaltung.dao.classes;

import notizverwaltung.dao.interfaces.NutzerprofilDAO;
import notizverwaltung.model.classes.NutzerprofilImpl;

/**
 * @author Agra Bimantara
 */

public class NutzerprofilDAOImpl extends ObjectDAOImpl implements NutzerprofilDAO {
    @Override
    public int addNutzerprofil(NutzerprofilImpl nutzerprofilImpl) {
        return 0;
    }

    @Override
    public NutzerprofilImpl getNutzerprofil(int NutzerprofilID) {
        return null;
    }

    @Override
    public void deleteNutzerprofil(NutzerprofilImpl nutzerprofilImpl) {

    }

    @Override
    public void updateNutzerprofil(NutzerprofilImpl nutzerprofilImpl) {

    }


}
