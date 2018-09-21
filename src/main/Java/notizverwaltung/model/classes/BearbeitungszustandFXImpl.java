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

    @Override
    public IntegerProperty getBearbeitungsZustandID() {
        return bearbeitzustandID;
    }

    @Override
    public void setBearbeitungsZustandID(int bearbeitungszustandID) {
        IntValidator.checkObIntNullOderNegativIst((bearbeitungszustandID));
        this.bearbeitzustandID.set(bearbeitungszustandID);

    }


    @Override
    public StringProperty getName() {
        return name;
    }

    @Override
    public void setName(String nameDerSpalte) {
        StringValidator.checkObStringLeerOderNullIst(nameDerSpalte);
        this.name.set(nameDerSpalte);
    }

    @Override
    public IntegerProperty getPosition() {
        return position;
    }

    @Override
    public void setPosition(int position) {
        IntValidator.checkObIntNullOderNegativIst(position);
        this.position.set(position);
    }


    /**
     * BearbeitungszustandFX  sind gleich, wenn sie die gleiche ID haben
     * @param object zu vergleichendes BearbeitungszustandFX
     * @return true, wenn ID gleich, sonst false
     */
    @Override
    public boolean equals(Object object){
        if (object instanceof BearbeitungszustandFX){
            BearbeitungszustandFX vergleichsZustandFX = (BearbeitungszustandFX) object;
            int vergleichdsID = vergleichsZustandFX.getBearbeitungsZustandID().getValue();
            int eigeneID = this.bearbeitzustandID.getValue();

            if (eigeneID == vergleichdsID){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){ return name.getValue(); }

}
