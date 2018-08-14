package notizverwaltung.model.classes;

import notizverwaltung.model.interfaces.NotizInterface;

import java.util.Date;

public class Notiz  {


    private Date erstellungsDatum;
    private Kategorie kategorie;
    private String title;
    private String beschreibung;
    private Boolean prioritaet;

    //TODO Eventuell Problem
    private String bearbeitungszustand;

    private Date faehlligkeit;
    private Date erinnerung;
    private boolean istErinnerungGesetzt;

    //TODO Maximale Anzahl an Aufgaben? Steht nix im Pflichtenheft
    private Aufgabe[] aufgaben;

}
