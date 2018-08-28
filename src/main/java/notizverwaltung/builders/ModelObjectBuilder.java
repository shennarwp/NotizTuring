package notizverwaltung.builders;

import notizverwaltung.exceptions.IntIstNegativException;
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
 */
public class ModelObjectBuilder {

   public static Notiz getNotizObject(String title,String beschreibung) throws StringIsEmptyException, IntIstNegativException, IOException {
       return new NotizImpl(title,beschreibung);
   }

    public static Nutzerprofil getNutzerprofilObject(int nutzerprofilID) throws IOException {
        return new NutzerprofilImpl(nutzerprofilID);
    }


    public static Notizblock getNotizblockObject (int notizblockID) throws IOException {
        return new NotizblockImpl(notizblockID);
    }

    public static Bearbeitungszustand getBearbeitungszustandObjekt()throws IOException {
        return new BearbeitungszustandImpl();
    }

    public static Aufgabe getAufgabeObjekt(String beschreibung, String bearbeitet)throws IOException {
        return new AufgabeImpl(beschreibung, bearbeitet);
    }

}
