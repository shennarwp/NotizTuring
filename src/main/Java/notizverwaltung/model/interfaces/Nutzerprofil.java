package notizverwaltung.model.interfaces;

/**
 * Interface fuer Nutzerprofil
 * @author Tobias Gottschalk
 */
public interface Nutzerprofil
{
    /**
     * Gibt die ID des Nutzerprofil zurueck
     * @return int
     */
    public int getNutzerprofilID();


    /**
     * Die Methode setzt die ID des Nutzprofils
     * @param nutzerprofilID Integer des Nutzerprofils
     */
    public void setNutzerprofilID(int nutzerprofilID);

}
