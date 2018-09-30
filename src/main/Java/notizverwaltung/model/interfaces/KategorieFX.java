package notizverwaltung.model.interfaces;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;
import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.exceptions.StringIsEmptyException;

/**
 * Das Interface stellt die Methoden für die Modelklasse bereit
 *
 * @author Kevin Engelhardt
 *
 * @version 1.0
 */

public interface KategorieFX {


    /**
     * getter-Methode fuer ID der Kategorie
     * @return gibt KategorieID als IntegerProperty  zurueck.
     */
    //____________________ID___________________
    public IntegerProperty getKategorieID();

    /**
     * setter-Methode fuer ID der Kategorie
     * @param kategorieID als int, int darf nicht kleiner 0 sein.
     */
    public void setKategorieID(int kategorieID);

    /**
     * getter-Methode fuer kategorieName
     * @return Gibt KategorieName als StringProperty zurueck.
     */
    //____________________Name___________________
    public StringProperty getKategorieName();

    /**
     * setter-Methode fuer name
     * @param name als String, String darf nicht leer sein.
     */
    public void setKategorieName(String name);

    /**
     * getter-Methode fuer die Farbe
     * @return Gibt Farbe als ObjectProperty zurueck.
     */
    //____________________Farbe___________________
    public ObjectProperty getFarbe();

    /**
     * setter-Methode fuer die Farbe
     * @param farbe als Color Object, darf nicht null sein.
     */
    public void setFarbe(Color farbe);
}
