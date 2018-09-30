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

    /**
     * Die Methode gibt die NotizID zurueck
     * @return NotizID als IntegerProperty
     */
    public IntegerProperty getNotizID();

    /**
     * Die Methode setzt die NotizID
     * @param notizID NotizID als Integer
     */
    public void setNotizID(int notizID);

    /**
     * Die Methode gibt den Title als StringProperty zurueck
     * @return Title eines NotizFX Objekts als StringProperty
     */
    public StringProperty getTitle();

    /**
     * Die Methode setzt den Title einer NotizFX Klasse
     * @param title als String
     */
    public void setTitle(String title);

    /**
     * Die Methode gibt die KategorieID als IntegerProperty zurueck
     * @return KategorieID als IntegerProperty
     */
    public IntegerProperty getKategorieID();


    /**
     * Die Methode setzt die KategorieID einer NotizFX
     * @param kategorieID KategorieID als Integer. Der Integer darf nicht kleiner als 1 sein
     */
    public void setKategorieID(int kategorieID);

    /**
     * Gibt den BearbeitungszustandID als IntegerProperty zurueck
     * @return Liefert die BearbeitungszustandID als IntegerProperty zurueck
     */
    public IntegerProperty getBearbeitungszustandID();


    /**
     * Die Methode setzt die BearbeitungszustandID
     * @param bearbeitungszustandID BearbeitungszustandID als Integer. Der Integer darf nicht kleiner als 1 sein
     */
    public void setBearbeitungszustandID(int bearbeitungszustandID);


    /**
     * Die Methode liefert die Bescheibung als StringProperty
     * @return Liefert ein StringProperty
     */
    public StringProperty getBeschreibung();


    /**
     * Die Methode setzt die Beschreibung
     * @param beschreibung Beschreibung als String
     */
    public void setBeschreibung(String beschreibung);

    /**
     * Die Methode liefert die Prioritaet
     * @return Liefert ein booleanProperty Objekt
     */
    public BooleanProperty getPrioritaet();


    /**
     * Die Methode setzt die Prioritaet
     * @param prioritaet als boolean
     */
    public void setPrioritaet(boolean prioritaet);


    /**
     * Liefert ein ObjectProperty mit dem Typ Date der Faelligkeit
     * @return ObjectProperty<Date> mit der Faelligkeit
     */
    public ObjectProperty<Date> getFaelligkeit();


    /**
     * Die Methode setzt eine neue Faelligkeit der NotizFX
     * @param faelligkeit Date Objekt
     */
    public void setFaelligkeit(Date faelligkeit);

    /**
     * Liefert ein BooleanProperty zurueck
     * @return Liefert ein BooleanProperty zurueck, ob eine Erinnerung gesetzt ist oder nicht
     */
    public BooleanProperty istErinnerungGesetzt();


    /**
     * Die Methode liefert ein ObjectProperty mit dem Typ Date.
     * Ist das Erinnerungsdatum einer NotizFX Klasse
     * @return Liefert ein ObjectProperty zurueck
     */
    public ObjectProperty<Date> getErinnerung();


    /**
     * Die Methode setzt ein Erinnerungsdatum
     * @param erinnerung Erinnerung als Date Objekt
     */
    public void setErinnerung(Date erinnerung);


    /**
     * Die Methode liefert das Erstellungsdatum als ObjectProperty mit dem Typ Date zurueck.
     * @return Liefert ein ObjectProperty<Date> Objekt zurueck
     */
    public ObjectProperty<Date> getErstellung();

    /**
     * Die Methode setzt das Erstellungdatum eines Notiz Objekts
     * @param erstellung Erstelldatum als Date
     */
    public void setErstellung(Date erstellung);



}
