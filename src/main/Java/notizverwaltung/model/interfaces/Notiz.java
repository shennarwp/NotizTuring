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


    public int getNotizID();
    public void setID(int notizID);

    public String getTitle();
    public void setTitle(String title) throws StringIsEmptyException;

    public int getKategorieID();
    public void setKategorieID(int kategorieID);

    public int getBearbeitungszustandID();
    public void setBearbeitungszustandID(int bearbeitungszustandID);


    public String getBeschreibung();
    public void setBeschreibung(String beschreibung) throws StringIsEmptyException;

    public boolean getPrioritaet();
    public void setPrioritaet(boolean prioritaet);

    public Date getFaelligkeit();
    public void setFaelligkeit(Date faelligkeit) throws ObjectIstNullException;

    public boolean istErinnerungGesetzt();
    public Date getErinnerung();
    public void setErinnerung(Date erinnerung) throws ObjectIstNullException;

    public Date getErstellung();



}

