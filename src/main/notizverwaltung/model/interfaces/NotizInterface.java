package main.notizverwaltung.model.interfaces;

import main.notizverwaltung.model.classes.Kategorie;

import java.util.Date;



public interface NotizInterface {
    //TODO Sollen wir nur mit Objekten arbeiten oder mit der NotizID? 
    public void setDatum(int NotizID, Date datum);
    public void setKategorie(int Kategorie kategorie);
    public void setName(String name);
    public void setBeschreibung(String beschreibung);
    public void setPrioritaet(Boolean prioritaet);
    public void setBearbeitungszustand(String Bearbeitungszustand);
    //TODO Ich haben eine eigene Klasse für Erinnerungen gemacht
    //public void setErinnern(Boolean erinnern);
    //public void setErinnerungsDatum(Date erinnerungsDatum);

    public void getEr

    public Date getDatum();
    public Kategorie getKategorie();
    public String getName();
    public String getBeschreibung();
    public Boolean getPrioritaet();
    public String getBearbeitungszustand();
    public Boolean getErinnern();
    public Date getErinnerungsDatum();

    public void addAufgabe(Aufgabe aufgabe);
    public void removeAufgabe(int aufgabeID);
    public Aufgabe getAufgabe(int aufgabeID);
    public Aufgabe[] getAufgaben();
    public Aufgabe[] getFertigeAufgaben();
    public Aufgabe[] getUnfertigeAufgaben();
}

