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



    public IntegerProperty getKategorieID();
    public void setKategorieID(int kategorieID);

    public StringProperty getKategorieName();
    public void setKategorieName(String name);

    public ObjectProperty getFarbe();
    public void setFarbe(Color farbe);
}
