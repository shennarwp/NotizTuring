package notizverwaltung.model.classes;

import notizverwaltung.model.interfaces.NotizInterface;
import notizverwaltung.util.PropertiesLoader;

import java.io.IOException;
import java.util.Date;

public class Notiz {

    private int notizID;
    private Date erstellungsDatum;
    private Kategorie kategorie;
    private String title;
    private String beschreibung;

    //TODO Warum Wrapper Klasse und keine primitiven Datentyp?
    private boolean prioritaet;

    //TODO Eventuell Problem, Was ist der BearbeitungszustandImpl? Eventuell eigene Klasse
    private String bearbeitungszustand;

    private Date faehlligkeit;
    private Date erinnerung;
    private boolean istErinnerungGesetzt;




    //Kontruktor mit den maximalen Parameter zum Erstellen einer Notiz

    public Notiz(Date erstellungsDatum, Kategorie kategorie, String title, String beschreibung, Boolean prioritaet, String bearbeitungszustand, Date faehlligkeit, Date erinnerung, boolean istErinnerungGesetzt) throws IOException {

        final int  maximaleAnzahlDerNotizenImArray = Integer.parseInt(PropertiesLoader.loadPropertie("AnzahlDerAufgabenMaximal"));
        

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
    public Notiz (String title, String beschreibung) throws IOException {
        this(new Date(), new Kategorie(), title, beschreibung, new Boolean(true), "null", new Date(), new Date(),true );

        final int  maximaleAnzahlDerNotizenImArray = Integer.parseInt(PropertiesLoader.loadPropertie("AnzahlDerAufgabenMaximal"));
        aufgaben = new Aufgabe[maximaleAnzahlDerNotizenImArray];

        this.erstellungsDatum = new Date();

        this.title = title;
        this.beschreibung = beschreibung;



    }





}

