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
 * @author Agra Bimantara
 * @author Shenna RWP
 */
public class ModelObjectBuilder
{

    /**
     * erstelle ein NutzerProfil-Objekt
     * @param nutzerprofilID die ID von Nutzer
     * @return Implementation von Nutzerprofil
     */
    public static Nutzerprofil getNutzerprofilObject(int nutzerprofilID) {
        return new NutzerprofilImpl();
    }

    /**
     * erstelle ein Notizblock-Objekt
     * @param notizblockID die ID von Notizblock
     * @return Implementation von Notizblock
     */
    public static Notizblock getNotizblockObject (int notizblockID) {
        return new NotizblockImpl();
    }

    /**
     * erstelle ein Notiz-Objekt
     * @return Implementation von Notiz
     */
    public static Notiz getNotizObject() {
        return new NotizImpl();
    }

    /**
     * erstelle ein Kategorie-Objekt
     * @param kategorieName name von der Kategorie, darf nicht leer sein
     * @return Implementation von Kategorie
     */
    public static Kategorie getKategorieObjekt(String kategorieName) {
        Kategorie kategorie = null;
        try {
            kategorie = new KategorieImpl(kategorieName);
        } catch (StringIsEmptyException se) {
            se.printStackTrace();
        }
        return kategorie;
    }

    /**
     * erstelle ein Bearbeitungszustand-Objekt
     * @param nameDerSpalte name von der Bearbeitungszustand, darf nicht leer sein
     * @return Implementation von Bearbeitungszustand
     */
    public static Bearbeitungszustand getBearbeitungszustandObjekt(String nameDerSpalte) {
        Bearbeitungszustand bearbeitungszustand = null;
        try {
            bearbeitungszustand = new BearbeitungszustandImpl(nameDerSpalte);
        } catch (StringIsEmptyException se) {
            se.printStackTrace();
        }
        return bearbeitungszustand;
    }

    /**
     * erstelle einAufgaben-Objekt
     * @param beschreibung beschreibung von der Aufgabe
     * @param bearbeitet checkbox, ob es schon bearbeitet oder nicht
     * @return Implementation von der Aufgabe
     */
    public static Aufgabe getAufgabeObject(String beschreibung, boolean bearbeitet) {
        Aufgabe aufgabe = null;
        try {
            aufgabe = new AufgabeImpl(beschreibung, bearbeitet);
        } catch (StringIsEmptyException se) {
            se.printStackTrace();
        }
        return aufgabe;
    }

    /**
     * erstelle ein NotizFX-Objekt
     * @return Implementation von NotizFX
     */
    public static NotizFX getNotizFXObjekt(){
        return new NotizFXImpl();
    }

}
