package main.notizverwaltung.model.classes;

import main.notizverwaltung.model.interfaces.AufgabeInterface;

public class Aufgabe implements AufgabeInterface {

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
