package notizverwaltung.model.classes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import notizverwaltung.model.interfaces.BearbeitungszustandFX;
import notizverwaltung.validators.IntValidator;
import notizverwaltung.validators.StringValidator;

/**
 * Klasse fuer BearbeitungszustandFX. Die Klasse implementiert das BearbeitungszustandFX Interface.
 *
 * @author Kevin Engelhardt
 *
 * @version 1.0
 */

public class BearbeitungszustandFXImpl implements BearbeitungszustandFX {

    private IntegerProperty bearbeitzustandID;
    private StringProperty name;
    private IntegerProperty position;


    public BearbeitungszustandFXImpl(){
        bearbeitzustandID = new SimpleIntegerProperty();
        name = new SimpleStringProperty();
        position = new SimpleIntegerProperty();
    }

    /**
     *
     * @return Gibt die BearbeitunszustandID als IntegerProperty zureuck.
     */
    @Override
    public IntegerProperty getBearbeitungsZustandID() {
        return bearbeitzustandID;
    }

    /**
     * @param bearbeitungszustandID  als int, int darf nicht kleiner 0 sein.
     */

    @Override
    public void setBearbeitungsZustandID(int bearbeitungszustandID) {
        IntValidator.checkObIntNullOderNegativIst((bearbeitungszustandID));
        this.bearbeitzustandID.set(bearbeitungszustandID);

    }

    /**
     *
     * @return liefert den Name des Bearbeitungszustands als Stringproperty zurueck.
     */

    @Override
    public StringProperty getName() {
        return name;
    }

    /**
     *
     * @param nameDerSpalte als String. String darf nicht leer sein.
     */
    @Override
    public void setName(String nameDerSpalte) {
        StringValidator.checkObStringLeerOderNullIst(nameDerSpalte);
        this.name.set(nameDerSpalte);
    }

    /**
     *
     * @return liefert Position des Bearbeitunszustands zurueck.
     */

    @Override
    public IntegerProperty getPosition() {
        return position;
    }

    /**
     * @param position als int, int darf nicht kleiner 0 sein.
     */

    @Override
    public void setPosition(int position) {
        IntValidator.checkObIntNullOderNegativIst(position);
        this.position.set(position);
    }

    @Override
    public String toString(){ return name.getValue(); }

}
