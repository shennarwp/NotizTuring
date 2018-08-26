package notizverwaltung.model.classes;

import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.validators.IntValidator;
import notizverwaltung.validators.ObjectValidator;
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
    private Kategorie kategorie;
    private String title;
    private String beschreibung;
    private boolean prioritaet;
    private String bearbeitungszustand;
    private Date faehlligkeit;
    private Date erinnerung;
    private boolean istErinnerungGesetzt;



    /**Konstruktor mit den minimalen Parameter zum Erstellen einer NotizImpl
     * @param title
     * @param beschreibung
     * @throws IOException
     */

    //TODO muss jeder Notiz beim Erstellen ein Bearbeitunszustand/Spalte zugewiesen werden?
    public NotizImpl(int notizID,String title, String beschreibung) throws IOException, StringIsEmptyException, IntIstNegativException {
        //this(notizID,title, beschreibung, new Boolean(false), "null", new Date(), new Date(), true);
        IntValidator.checkObIntNullOderNegativIst(notizID);
        StringValidator.checkObStringLeerOderNullIst(title);
        StringValidator.checkObStringLeerOderNullIst(beschreibung);

        this.notizID = notizID;
        this.title = title;
        this.beschreibung = beschreibung;



    }


    @Override
    public void setKategorie(Kategorie kategorie) throws ObjectIstNullException {
        ObjectValidator.checkObObjectNullIst(kategorie);
        this.kategorie = kategorie;
    }


    @Override
    public void setTitle(String title) throws StringIsEmptyException {
        StringValidator.checkObStringLeerOderNullIst(title);
        this.title = title;
    }

    @Override
    public void setBeschreibung(String beschreibung) throws StringIsEmptyException {
        StringValidator.checkObStringLeerOderNullIst(beschreibung);
        this.beschreibung = beschreibung;
    }

    @Override
    public void setPrioritaet(Boolean prioritaet) {
        this.prioritaet = prioritaet;
    }

    //TODO Wie war das nochmal mit dem Berabeitungszustand
    @Override
    public void setBearbeitungszustand(String Bearbeitungszustand) throws StringIsEmptyException {
        StringValidator.checkObStringLeerOderNullIst(beschreibung);
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
    public void setErinnerung(Date erinnerung) throws ObjectIstNullException {
        ObjectValidator.checkObObjectNullIst(erinnerung);
        this.erinnerung = erinnerung;
    }

    @Override
    public Date getErstellungsDatum() {
        return erstellungsDatum;
    }

    //TODO Muss noch implemetiert werden
    @Override
    public Kategorie getKategorie() {
        return kategorie;
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

