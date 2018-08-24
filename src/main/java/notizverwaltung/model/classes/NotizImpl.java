package notizverwaltung.model.classes;

import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.validators.StringValidator;


import java.io.IOException;
import java.util.Date;

/**
 * Die Klasse ist eine Modelklasse fuer Notizen
 *
 * @author Tobias Gottschalk
 *
 * @version 1.0
 */

public class NotizImpl implements Notiz {

    private int notizID;
    private Date erstellungsDatum;
    private kategorie;
    private String title;
    private String beschreibung;
    private boolean prioritaet;
    private String bearbeitungszustand;
    private Date faehlligkeit;
    private Date erinnerung;
    private boolean istErinnerungGesetzt;


    /**
     * Konstruktor fuer NotizImplementierung
     * @param kategorie
     * @param title
     * @param beschreibung
     * @param prioritaet
     * @param bearbeitungszustand
     * @param faehlligkeit
     * @param erinnerung
     * @param istErinnerungGesetzt
     * @throws IOException
     */
    public NotizImpl(Kategorie kategorie, String title, String beschreibung, Boolean prioritaet, String bearbeitungszustand, Date faehlligkeit, Date erinnerung, boolean istErinnerungGesetzt) throws IOException {


        this.erstellungsDatum = new Date();
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


    /**Konstruktor mit den minimalen Parameter zum Erstellen einer NotizImpl
     * @param title
     * @param beschreibung
     * @throws IOException
     */

    public NotizImpl(String title, String beschreibung) throws IOException {
        this( new Kategorie(), title, beschreibung, new Boolean(false), "null", new Date(), new Date(),true );

    }

    @Override
    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }


    @Override
    public void setTitle(String title) throws StringIsEmptyException {
        StringValidator.checkObStringLeerIst(title);
        this.title = title;
    }

    @Override
    public void setBeschreibung(String beschreibung) throws StringIsEmptyException {
        StringValidator.checkObStringLeerIst(beschreibung);
        this.beschreibung = beschreibung;
    }

    @Override
    public void setPrioritaet(Boolean prioritaet) {
        this.prioritaet = prioritaet;
    }

    //TODO Wie war das nochmal mit dem Berabeitungszustand
    @Override
    public void setBearbeitungszustand(String Bearbeitungszustand) throws StringIsEmptyException {
        StringValidator.checkObStringLeerIst(beschreibung);
        this.bearbeitungszustand = bearbeitungszustand;
    }

    @Override
    public String getBearbeitungszustand() {
        return bearbeitungszustand;
    }

    @Override
    public boolean isErinnerungGesetzt() {
        return istErinnerungGesetzt;
    }

    @Override
    public Date getErinnerung() {
        return erinnerung;
    }

    @Override
    public void setErinnerung(Date erinnerung) {
        this.erinnerung = erinnerung;
    }

    @Override
    public Date getErstellungsDatum() {
        return erstellungsDatum;
    }

    //TODO Muss noch implemetiert werden
    @Override
    public Kategorie getKategorie() {
        return null;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getBeschreibung() {
        return beschreibung;
    }

    @Override
    public Boolean getPrioritaet() {
        return prioritaet;
    }


}

