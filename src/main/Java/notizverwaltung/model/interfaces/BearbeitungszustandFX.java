package notizverwaltung.model.interfaces;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Das Interface stellt die Methoden für die Modellklasse bereit
 * @autho Kevin Engelhardt
 *
 * @version 1.0
 */

public interface BearbeitungszustandFX {

    public IntegerProperty getBearbeitungsZustandID();
    public void setBearbeitungsZustandID(int bearbeitungszustandID);

    public StringProperty getName();
    public void setName(String nameDerSpalte);

    public IntegerProperty getPosition();
    public void setPosition(int position);

}
