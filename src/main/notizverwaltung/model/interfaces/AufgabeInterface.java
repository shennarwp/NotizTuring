package main.notizverwaltung.model.interfaces;

public interface AufgabeInterface {

    public void setAufgabeID(int aufgabeID);
    public void setBeschreibung(String beschreibung);
    public void setBearbeitet(Boolean bearbeitet);

    public int getAufgabeID();
    public String getBeschreibung();
    public Boolean getBearbeitet();
    public String toString();
}