package notizverwaltung.dao.interfaces;

import notizverwaltung.model.classes.NutzerprofilImpl;

/**
 * @author Agra Bimantara
 */

public interface NutzerprofilDAO extends ObjectDAO {
    public int addNutzerprofil(NutzerprofilImpl nutzerprofilImpl);
    public NutzerprofilImpl getNutzerprofil(int NutzerprofilID);
    public void deleteNutzerprofil(NutzerprofilImpl nutzerprofilImpl);
    public void updateNutzerprofil(NutzerprofilImpl nutzerprofilImpl);
}
