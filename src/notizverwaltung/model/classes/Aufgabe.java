package notizverwaltung.model.classes;

import notizverwaltung.model.interfaces.AufgabeInterface;

public class Aufgabe implements AufgabeInterface {

    //TODO Wie wird die Aufgaben ID erzeugt?
    private int aufgabeID;
    private String beschreibung;
    private Boolean bearbeitet;


    @Override
    public void setAufgabeID(int aufgabeID){

        this.aufgabeID=aufgabeID;
    }

    @Override
    public void setBeschreibung(String beschreibung){

        this.beschreibung=beschreibung;
    }

    @Override
    //TODO Ändern auf Enum
    public void setBearbeitet(Boolean bearbeitet){

        this.bearbeitet=bearbeitet;
    }

    @Override
    public int getAufgabeID(){

        return this.aufgabeID;
    }

    @Override
    public String getBeschreibung(){

        return this.beschreibung;
    }

    @Override
    public Boolean getBearbeitet(){

        return this.bearbeitet;
    }


    @Override
    public String toString() {
        return "Aufgabe{" +
                "aufgabeID=" + aufgabeID +
                ", beschreibung='" + beschreibung + '\'' +
                ", bearbeitet=" + bearbeitet +
                '}';
    }
}


//TODO Es gibt nur zwei Zustände. Eventuell kann man auch bool holen
 enum Bearbeitungszustaende {
    FERTIG, UNFERTIG
}