package main.java.notizverwaltung.model.interfaces;

import main.java.notizverwaltung.exceptions.StringIsEmptyException;
import main.java.notizverwaltung.model.interfaces.Kategorie;

import java.util.Date;



public interface Notiz {
    //TODO Sollen wir nur mit Objekten arbeiten oder mit der NotizID? 

    //TODO Das Erstellungsdatum wird generiert. Braucht man eigentlich nicht
    //public void setDatum(int NotizID, Date datum);



    public void setKategorie(Kategorie kategorie);
    public void setTitle(String name) throws StringIsEmptyException;
    public void setBeschreibung(String beschreibung) throws StringIsEmptyException;
    public void setPrioritaet(Boolean prioritaet);

    //In welcher Spalte befindet sich die NotizImpl
    public void setBearbeitungszustand(String Bearbeitungszustand) throws StringIsEmptyException;


    public boolean isErinnerungGesetzt();
    public Date getErinnerung();
    public void setErinnerung(Date erinnerung);

    //Wann wurde die NotizImpl erstellt
    public Date getErstellungsDatum();
    public Kategorie getKategorie();
    public String getTitle();
    public String getBeschreibung();
    public Boolean getPrioritaet();

    public String getBearbeitungszustand();


}

