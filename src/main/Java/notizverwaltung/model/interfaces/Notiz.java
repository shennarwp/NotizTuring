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
    public int getNotizID();
    public void setID(int notizID);

    //____________________TITLE____________________
    public String getTitle();
    public void setTitle(String title) throws StringIsEmptyException;

    //____________________KATEGORIE____________________
    public int getKategorieID();
   public void setKategorieID(int kategorieID);

    //____________________BEARBEITUNGSZUSTAND____________________
    public int getBearbeitungszustandID();
    public void setBearbeitungszustandID(int bearbeitungszustandID);


    //____________________BESCHREIBUNG____________________
    public String getBeschreibung();

    /**
     * Die Methode setzt eine neue Beschreibung in die Notiz
     * @param beschreibung String
     * @throws StringIsEmptyException wirft eine Exception
     */
    public void setBeschreibung(String beschreibung) throws StringIsEmptyException;


    //____________________PRIORITÄT____________________
    public boolean getPrioritaet();

    public void setPrioritaet(boolean prioritaet);

    //____________________FÄLLIGKEIT____________________
    public Date getFaelligkeit();

    public void setFaelligkeit(Date faelligkeit) throws ObjectIstNullException;

    //____________________ERRINERUNG____________________
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
    public Date getErstellung();



}

