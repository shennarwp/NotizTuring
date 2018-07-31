package main.notizverwaltung.model.classes;

import main.notizverwaltung.model.interfaces.NotizInterface;

import java.util.Date;

public class Notiz implements NotizInterface {

    private Date datum;
    private Kategorie kategorie;
    private String name;
    private String beschreibung;
    private Boolean prioritaet;
    private String bearbeitungszustand;
    private Boolean erinnern;
    private Date erinnerungsDatum;
    private Aufgabe[] aufgaben;

    @Override
    public Date getDatum() {
        return datum;
    }

    @Override
    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public Kategorie getKategorie() {
        return kategorie;
    }

    @Override
    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getBeschreibung() {
        return beschreibung;
    }

    @Override
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    @Override
    public Boolean getPrioritaet() {
        return prioritaet;
    }

    @Override
    public void setPrioritaet(Boolean prioritaet) {
        this.prioritaet = prioritaet;
    }

    @Override
    public String getBearbeitungszustand() {
        return bearbeitungszustand;
    }

    @Override
    public void setBearbeitungszustand(String bearbeitungszustand) {
        this.bearbeitungszustand = bearbeitungszustand;
    }

    @Override
    public Aufgabe[] getAufgaben() {
        return aufgaben;
    }

    public void setAufgaben(Aufgabe[] aufgaben) {
        this.aufgaben = aufgaben;
    }

    @Override
    public Boolean getErinnern() {
        return erinnern;
    }

    @Override
    public void setErinnern(Boolean erinnern) {
        this.erinnern = erinnern;
    }

    @Override
    public Date getErinnerungsDatum() {
        return this.erinnerungsDatum;
    }

    @Override
    public void setErinnerungsDatum(Date erinnerungsDatum) {
        this.erinnerungsDatum = erinnerungsDatum;
    }

    @Override
    public void addAufgabe(Aufgabe aufgabe){

    }

    @Override
    public void removeAufgabe(int aufgabeID){

    }

    @Override
    public Aufgabe getAufgabe(int aufgabeID){
        return null;
    }

    @Override
    public Aufgabe[] getFertigeAufgaben() {
        return new Aufgabe[0];
    }

    @Override
    public Aufgabe[] getUnfertigeAufgaben() {
        return new Aufgabe[0];
    }
}
