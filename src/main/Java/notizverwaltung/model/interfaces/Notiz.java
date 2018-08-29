package notizverwaltung.model.interfaces;

import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.model.interfaces.Kategorie;

import java.util.Date;


/**
 *  Das Interface stellt die Methoden für die Modelklasse
 *
 * @author Tobias Gottschalk
 *
 * @version 1.0
 */
public interface Notiz {
    //TODO Sollen wir nur mit Objekten arbeiten oder mit der NotizID? 

    //TODO Das Erstellungsdatum wird generiert. Braucht man eigentlich nicht
    //public void setDatum(int NotizID, Date datum);



    public void setKategorie(Kategorie kategorie) throws ObjectIstNullException;
    public void setTitle(String name) throws StringIsEmptyException;
    public void setBeschreibung(String beschreibung) throws StringIsEmptyException;
    public void setPrioritaet(Boolean prioritaet);

    //In welcher Spalte befindet sich die NotizImpl
    public void setBearbeitungszustand(String Bearbeitungszustand) throws StringIsEmptyException;


    public boolean isErinnerungGesetzt();
    public Date getErinnerung();
    public void setErinnerung(Date erinnerung) throws ObjectIstNullException;

    //Wann wurde die NotizImpl erstellt
    public Date getErstellungsDatum();
    public Kategorie getKategorie();
    public String getTitle();
    public String getBeschreibung();
    public Boolean getPrioritaet();

    public String getBearbeitungszustand();


}

