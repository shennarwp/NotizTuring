package notizverwaltung.model.interfaces;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import notizverwaltung.model.classes.NotizFXImpl;

import java.util.Date;

/**
 *  Das Interface stellt die Methoden für die Modelklasse bereit
 *
 * @author Tobias Gottschalk

 *
 * @version 1.0
 */

public interface NotizFX extends Comparable<NotizFX> {

    public IntegerProperty getNotizID();
    public void setNotizID(int notizID);

    public StringProperty getTitle();
    public void setTitle(String title);

    public IntegerProperty getKategorieID();
    public void setKategorieID(int kategorieID);

    public IntegerProperty getBearbeitungszustandID();
    public void setBearbeitungszustandID(int bearbeitungszustandID);

    public StringProperty getBeschreibung();
    public void setBeschreibung(String beschreibung);

    public BooleanProperty getPrioritaet();
    public void setPrioritaet(boolean prioritaet);

    public ObjectProperty<Date> getFaelligkeit();
    public void setFaelligkeit(Date faelligkeit);

    public BooleanProperty istErinnerungGesetzt();
    public ObjectProperty<Date> getErinnerung();
    public void setErinnerung(Date erinnerung);


    public ObjectProperty<Date> getErstellung();
    public void setErstellung(Date erstellung);



}
