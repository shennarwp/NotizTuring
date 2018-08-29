package notizverwaltung.model.interfaces;

import notizverwaltung.exceptions.StringIsEmptyException;

/**
 * @author Shenna RWP
 */
public interface Aufgabe
{

    public int getAufgabeID();
    public void setAufgabeID(int aufgabeID);

    public String getBeschreibung();
    public void setBeschreibung(String beschreibung) throws StringIsEmptyException;

    public boolean getBearbeitet();
    public void setBearbeitet(boolean bearbeitet);

    public String toString();
}