package notizverwaltung.model.interfaces;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Das Interface stellt die Methoden für die Modellklasse bereit
 * @author Kevin Engelhardt
 *
 * @version 1.0
 */

public interface BearbeitungszustandFX {

    /**
     * @return Gibt die BearbeitunszustandID als IntegerProperty zureuck.
     */
    //____________________ID___________________
    public IntegerProperty getBearbeitungsZustandID();

    /**
     * @param bearbeitungszustandID als int, int darf nicht kleiner 0 sein.
     */
    public void setBearbeitungsZustandID(int bearbeitungszustandID);

    //____________________Name___________________

    /**
     * @return  liefert den Name des Bearbeitungszustands als Stringproperty zurueck.
     */
    public StringProperty getName();

    /**
     * @param nameDerSpalte als String. String darf nicht leer sein.
     */
    public void setName(String nameDerSpalte);

    /**
     * @return liefert Position des Bearbeitunszustands zurueck.
     */
    //____________________Position___________________
    public IntegerProperty getPosition();

    /**
     * @param position als int, int darf nicht kleiner 0 sein.
     */
    public void setPosition(int position);

}
