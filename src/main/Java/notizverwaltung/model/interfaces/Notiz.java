package notizverwaltung.model.interfaces;

import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.exceptions.StringIsEmptyException;

import java.util.Date;


/**
 *  Das Interface stellt die Methoden für die Modelklasse
 *
 * @author Tobias Gottschalk
 * @author Shenna RWP
 *
 * @version 1.0
 */

public interface Notiz
{
    //____________________ID____________________


    /**
     * Die Methode liefert eine NotizID zurueck
     * @return NotizID als Integer
     */
    public int getNotizID();

    /**
     * Die Methode setzt eine NotizID
     * @param notizID NotizID als Integer
     */
    public void setID(int notizID);

    //____________________TITLE____________________
    /**
     *Die Methode gibt den Title einer Notiz zurueck
     * @return Title einer Notiz als String
     */

    public String getTitle();

    /**
     * Die Methode setzt den Title einer Notiz
     * @param title als String
     * @throws StringIsEmptyException wird geworfen, wenn der String leer oder null ist
     */
    public void setTitle(String title) throws StringIsEmptyException;

    //____________________KATEGORIE____________________
    /**
     * Die Methode gibt eine KategorieID zurueck
     * @return KategorieID als int
     */

    public int getKategorieID();

    /**
     * Die Methode setzt eine KategorieID
     * @param kategorieID als int
     */
    public void setKategorieID(int kategorieID);

    //____________________BEARBEITUNGSZUSTAND____________________




    /**
     * Die Methode gibt die ID des Bearbeitunszustand zurueck
     * @return BearbeitungszustandID als Integer
     */
    public int getBearbeitungszustandID();


    /**
     * Die Methode setzt ein BearbeitungszustandID
     * @param bearbeitungszustandID als in
     */
    public void setBearbeitungszustandID(int bearbeitungszustandID);


    //____________________BESCHREIBUNG____________________


    /**
     * Die Methode gibt eine Beschreibung der Notiz als String zurueck
     * @return Beschreibung als String
     */
    public String getBeschreibung();

    /**
     * Die Methode setzt eine neue Beschreibung in die Notiz
     * @param beschreibung String
     * @throws StringIsEmptyException wirft eine Exception
     */
    public void setBeschreibung(String beschreibung) throws StringIsEmptyException;

//____________________PRIORITÄT____________________


    /**
     * Die Methode gibt die Priorität als boolean zurueck
     * @return Prioritaet als boolean
     */
    public boolean getPrioritaet();

    /**
     * Die Methode setzt die Prioritaet
     * @param prioritaet als boolean
     */
    public void setPrioritaet(boolean prioritaet);

    //____________________FÄLLIGKEIT____________________


    /**
     * Die Methode gibt die Faelligkeit einer Notiz zurueck
     * @return Faelligkeit als Date Objekt
     */
    public Date getFaelligkeit();

    /**
     * Die Methode setzt die Faelligkeit
     * @param faelligkeit als Date Objekt
     * @throws ObjectIstNullException wirft eine Exception, wenn das Date Objekt Null ist
     */
    public void setFaelligkeit(Date faelligkeit) throws ObjectIstNullException;


    /**
     * Die Methode liefert
     * @return Liefert true zurueck, wenn die Erinnerung gesetzt ist. Anderenfalls false
     */
    public boolean istErinnerungGesetzt();

    /**
     * Die Methode liefert das Erinnerungsdatum einer Notiz
     * @return Erinnerungsdatum als Date Objekt
     */
    public Date getErinnerung();


    /**
     * Die Methode setzt eine neue Erinnerung in der Notiz
     * @param erinnerung Erinnerung als Date Objekt
     * @throws ObjectIstNullException wirf eine Exception
     */
    public void setErinnerung(Date erinnerung) throws ObjectIstNullException;

    //____________________ERSTELLUNG____________________

    /**
     * Die Methode liefert das Erstellungsdatum als Date
     * @return Erstellungsdatum als Date
     */
    public Date getErstellung();



}

