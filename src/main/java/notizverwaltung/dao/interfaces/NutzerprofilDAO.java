package notizverwaltung.dao.interfaces;

import notizverwaltung.model.classes.NutzerprofilImpl;

/**
 * @author Agra Bimantara
 */

public interface NutzerprofilDAO {
    public void addNutzerprofil(NutzerprofilImpl nutzerprofilImpl);
    public void deleteNutzerprofil(NutzerprofilImpl nutzerprofilImpl);
    public void updateNutzerprofil(NutzerprofilImpl nutzerprofilImpl);

    public NutzerprofilImpl getNutzerprofil(int NutzerprofilID);
}
