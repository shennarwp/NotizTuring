package main.notizverwaltung.model.classes;

import main.notizverwaltung.model.interfaces.NotizInterface;

import java.util.Date;

public class Notiz implements NotizInterface {

    private int notizID;
    private Date erstellungsDatum;
    private Kategorie kategorie;
    private String title;
    private String beschreibung;

    //TODO Warum Wrapper Klasse und keine primitiven Datentyp?
    private Boolean prioritaet;

    //TODO Eventuell Problem, Was ist der Bearbeitungszustand? Eventuell eigene Klasse
    private String bearbeitungszustand;

    private Date faehlligkeit;
    private Date erinnerung;
    private boolean istErinnerungGesetzt;

    //TODO Maximale Anzahl an Aufgaben? Steht nix im Pflichtenheft
    private Aufgabe[] aufgaben;


    //Kontruktor mit den maximalen Parameter zum Erstellen einer Notiz

    public Notiz(Date erstellungsDatum, Kategorie kategorie, String title, String beschreibung, Boolean prioritaet, String bearbeitungszustand, Date faehlligkeit, Date erinnerung, boolean istErinnerungGesetzt) {

        int final maximaleAnzahlDerNotizenImArray =
        Integer.parseInt(PropertiesLoader.loadPropertie("AnzahlDerAufgabenMaximal"));
        aufgaben = new Aufgabe[maximaleAnzahlDerNotizenImArray];

        this.erstellungsDatum = new Date();
        this.erstellungsDatum = erstellungsDatum;
        this.kategorie = kategorie;
        this.title = title;
        this.beschreibung = beschreibung;
        this.prioritaet = prioritaet;
        this.bearbeitungszustand = bearbeitungszustand;
        this.faehlligkeit = faehlligkeit;
        this.erinnerung = erinnerung;
        this.istErinnerungGesetzt = istErinnerungGesetzt;

        this.title = title;
        this.beschreibung = beschreibung;

    }



    //Konstruktor mit den minimalen Parameter zum Erstellen einer Notiz
    public Notiz (String title, String beschreibung){
        this(new Date(), new Kategorie(), title, beschreibug, new Boolean(), "null", new Date(), new date(),boolean )

        int final maximaleAnzahlDerNotizenImArray = Integer.parseInt(PropertiesLoader.loadPropertie("AnzahlDerAufgabenMaximal"));
        aufgaben = new Aufgabe[maximaleAnzahlDerNotizenImArray];

        this.erstellungsDatum = new Date();

        this.title = title;
        this.beschreibung = beschreibung;



    }





}

