package notizverwaltung.model.interfaces;

import notizverwaltung.exceptions.StringIsEmptyException;

/**
 * @author Shenna RWP
 */
public interface Aufgabe
{

    //____________________ID____________________
    public int getAufgabeID();
    public void setAufgabeID(int aufgabeID);

    //____________________Beschreibung____________________
    public String getBeschreibung();
    public void setBeschreibung(String beschreibung) throws StringIsEmptyException;

    //____________________Bearbeitet____________________
    public boolean getBearbeitet();
    public void setBearbeitet(boolean bearbeitet);

    //to-String
    public String toString();
}