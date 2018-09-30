package notizverwaltung.model.interfaces;

/**
 *  Das Interface stellt Methoden zur Verwaltung des Notizblocks bereit
 *
 * @author Tobias Gottschalk


 */
public interface Notizblock
{
    /**
     * Liefert die ID des Notizblocks zurueck
     * @return int
     */
    public int getNotizblockID();


    /**
     * Setzt eine neue ID eines Notizblocks
     * @param notizblockID als int
     */
    public void setNotizblockID(int notizblockID);
}

