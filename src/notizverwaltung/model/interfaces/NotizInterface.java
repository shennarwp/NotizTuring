package notizverwaltung.model.interfaces;

import notizverwaltung.model.classes.Aufgabe;
import notizverwaltung.model.classes.Kategorie;

import java.util.Date;



public interface NotizInterface {
    //TODO Sollen wir nur mit Objekten arbeiten oder mit der NotizID? 

    //TODO Das Erstellungsdatum wird generiert. Braucht man eigentlich nicht
    //public void setDatum(int NotizID, Date datum);



    public void setKategorie(Kategorie kategorie);
    public void setName(String name);
    public void setBeschreibung(String beschreibung);
    public void setPrioritaet(Boolean prioritaet);

    //In welcher Spalte befindet sich die Notiz
    public void setBearbeitungszustand(String Bearbeitungszustand);


    public boolean isErinnerungGesetzt();
    public Date getErinnerung();
    public void setErinnerung(Date erinnerung);

    //Wann wurde die Notiz erstellt
    public Date getDatum();
    public Kategorie getKategorie();
    public String getTitle();
    public String getBeschreibung();
    public Boolean getPrioritaet();

    public String getBearbeitungszustand();


}

