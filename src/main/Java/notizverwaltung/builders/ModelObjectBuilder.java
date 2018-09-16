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

    public static Nutzerprofil getNutzerprofilObject(int nutzerprofilID) {
        return new NutzerprofilImpl();
    }

    public static Notizblock getNotizblockObject (int notizblockID) {
        return new NotizblockImpl();
    }



    public static Notiz getNotizObject() {

        return new NotizImpl();
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

    public static NotizFX getNotizFXObjekt(){
        return new NotizFXImpl();
    }

}
