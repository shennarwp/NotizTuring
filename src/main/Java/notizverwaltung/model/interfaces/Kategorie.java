package notizverwaltung.model.interfaces;

import javafx.scene.paint.Color;
import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.exceptions.StringIsEmptyException;

/**
 *  Das Interface stellt die Methoden für die Modelklasse
 *
 * @author Tobias Gottschalk
 * @author Shenna RWP
 *
 * @version 1.0
 */


public interface Kategorie
{

    /**
     * Die Methode liefert die KategorieID zurueck
     * @return KategorieID als int
     */
    public int getKategorieID();
    public void setKategorieID(int kategorieID) throws IntIstNegativException;

    /**
     * Die Methode liefert den Namen der Kategorie zurueck
     * @return Kategoriename als String
     */
    public String getKategorieName();
    public void setKategorieName(String name) throws StringIsEmptyException;

    /**
     * Die Methode liefert die Farbe einer Kategorie zurueck
     * @return Liefert ein Color Objekt zurueck
     */
    public Color getFarbe();
    public void setFarbe(Color farbe) throws ObjectIstNullException;


    /**
     * ToString Methode
     * @return Liefert den Namen einer Kategorie zurueck
     */
    public String toString();
}
