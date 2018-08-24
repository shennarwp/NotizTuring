package notizverwaltung.model.classes;

import notizverwaltung.model.interfaces.AufgabeInterface;

public class Aufgabe implements AufgabeInterface {

    //TODO Wie wird die Aufgaben ID erzeugt?
    private int aufgabeID;
    private String beschreibung;
    private boolean bearbeitet;


    @Override
    public void setAufgabeID(int aufgabeID){

        this.aufgabeID=aufgabeID;
    }

    @Override
    public void setBeschreibung(String beschreibung){

        this.beschreibung=beschreibung;
    }

    @Override

    public void setBearbeitet(boolean bearbeitet){

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


