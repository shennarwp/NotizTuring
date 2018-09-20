package notizverwaltung.dao.interfaces;

import notizverwaltung.model.classes.NutzerprofilImpl;

/**
 * Interface-Klasse für NutzerprofilDaoImpl
 * @author Agra Bimantara
 */

public interface NutzerprofilDAO extends ObjectDAO {
    //erstelle neuer Nutzerprofil in Datenbank
    public int addNutzerprofil(NutzerprofilImpl nutzerprofilImpl);

    //suche einer bestimmte Nutzerprofil
    public NutzerprofilImpl getNutzerprofil(int NutzerprofilID);

    //lösche bestimmter Nutzerprofil in Datenbank
    public void deleteNutzerprofil(NutzerprofilImpl nutzerprofilImpl);

    //Nutzerprofil in Datenbank ändern
    public void updateNutzerprofil(NutzerprofilImpl nutzerprofilImpl);
}
