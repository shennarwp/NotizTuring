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
    //TODO Sollen wir nur mit Objekten arbeiten oder mit der NotizID? 

    //TODO Das Erstellungsdatum wird generiert. Braucht man eigentlich nicht
    //public void setDatum(int NotizID, Date datum);

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
    public void setBeschreibung(String beschreibung) throws StringIsEmptyException;

    //____________________PRIORITÄT____________________
    public boolean getPrioritaet();
    public void setPrioritaet(boolean prioritaet);

    //____________________FÄLLIGKEIT____________________
    public Date getFaelligkeit();
    public void setFaelligkeit(Date faelligkeit) throws ObjectIstNullException;

    //____________________ERRINERUNG____________________
    public boolean istErinnerungGesetzt();
    public Date getErinnerung();
    public void setErinnerung(Date erinnerung) throws ObjectIstNullException;

    //____________________ERSTELLUNG____________________
    public Date getErstellung();



}

