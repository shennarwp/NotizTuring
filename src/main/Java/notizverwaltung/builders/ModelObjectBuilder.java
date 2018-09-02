package notizverwaltung.builders;

import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.model.classes.*;

import notizverwaltung.model.interfaces.*;

import java.io.IOException;
import java.util.Date;


/**
 * Die Klasse stellt ein Model-Objekt bereit
 *
 * @author Tobias Gottschalk
 * @version 1.0
 * @author Agra Bimantara (weiter bearbeitet)
 * @author Shenna RWP
 */
public class ModelObjectBuilder
{

    public static Nutzerprofil getNutzerprofilObject(int nutzerprofilID) {
        return new NutzerprofilImpl();
    }

    public static Notizblock getNotizblockObject (int notizblockID) {
        return new NotizblockImpl();
    }

    public static Notiz getNotizObject(String title, String kategorie, String bearbeitungszustand, String beschreibung, boolean prioritaet,
                                       Date faelligkeit, Date erinnerung) {
        Notiz notiz = null;
        try {
            notiz = new NotizImpl(title, kategorie, bearbeitungszustand, beschreibung, prioritaet, faelligkeit, erinnerung );
        } catch (StringIsEmptyException se) {
            se.printStackTrace();
        } catch (ObjectIstNullException oe) {
            oe.printStackTrace();
        } catch (IntIstNegativException e) {
            e.printStackTrace();
        }
        return  notiz;
    }

    public static Notiz getNotizObject(String title,String beschreibung) {
        Notiz notiz = null;
        try {
            notiz = new NotizImpl(title, beschreibung);
        } catch (StringIsEmptyException se) {
            se.printStackTrace();
        } catch (ObjectIstNullException oe) {
            oe.printStackTrace();
        } catch (IntIstNegativException e) {
            e.printStackTrace();
        }
        return notiz;
    }

    public static Kategorie getKategorieObjekt(String kategorieName) {
        Kategorie kategorie = null;
        try {
            kategorie = new KategorieImpl(kategorieName);
        } catch (StringIsEmptyException se) {
            se.printStackTrace();
        }
        return kategorie;
    }

    public static Bearbeitungszustand getBearbeitungszustandObjekt(String nameDerSpalte) {
        Bearbeitungszustand bearbeitungszustand = null;
        try {
            bearbeitungszustand = new BearbeitungszustandImpl(nameDerSpalte);
        } catch (StringIsEmptyException se) {
            se.printStackTrace();
        }
        return bearbeitungszustand;
    }

    public static Aufgabe getAufgabeObject(String beschreibung, boolean bearbeitet) {
        Aufgabe aufgabe = null;
        try {
            aufgabe = new AufgabeImpl(beschreibung, bearbeitet);
        } catch (StringIsEmptyException se) {
            se.printStackTrace();
        }
        return aufgabe;
    }

}
