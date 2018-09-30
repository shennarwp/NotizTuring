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

    //____________________ID___________________
    public IntegerProperty getBearbeitungsZustandID();
    public void setBearbeitungsZustandID(int bearbeitungszustandID);

    //____________________Name___________________
    public StringProperty getName();
    public void setName(String nameDerSpalte);

    //____________________Position___________________
    public IntegerProperty getPosition();
    public void setPosition(int position);

}
