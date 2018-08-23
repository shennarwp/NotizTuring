package model.interfaces;

public interface AufgabeInterface {

    //Ändern der AufgabenID sinnvoll?
    public void setAufgabeID(int aufgabeID);
    public void setBeschreibung(String beschreibung);
    public void setBearbeitet(boolean bearbeitet);

    public int getAufgabeID();
    public String getBeschreibung();
    public Boolean getBearbeitet();
    public String toString();
}