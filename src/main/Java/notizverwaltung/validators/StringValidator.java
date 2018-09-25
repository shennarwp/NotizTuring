package notizverwaltung.validators;


import notizverwaltung.exceptions.StringIsEmptyException;


/**
 * Die Klasse beinhaltet Methoden zur Ueberprufung von Strings
 *
 * @author Tobias Gottschalk
 *
 * @version 1.0
 */

public class StringValidator {

    public static final String STRING_OHNE_SONDERZEICHEN_REGEX = "[A-Za-z0-9 ÄäÖöÜüß]*";


    /**
     * Die Methode ueberprueft, ob der String leer oder null ist
     * @param zuUeberpruefenderString
     * @return true, wenn der String leer oder null ist ansonsten liefert die Methode false zurueck
     */
    public static boolean isStringLeerOderNull(String zuUeberpruefenderString){
        if(zuUeberpruefenderString == null|| zuUeberpruefenderString.trim().isEmpty()){
            return true;
        }

        return false;
    }


    /** Die Methode ueberpruft ob ein String leer oder null ist und wirft dann eine Exception
     * @param zuUeberpruefenderString
     * @throws StringIsEmptyException wirft eine Exception, wenn der String leer oder nulll ist
     */
    public static void checkObStringLeerOderNullIst(String zuUeberpruefenderString) throws StringIsEmptyException{
        if (isStringLeerOderNull(zuUeberpruefenderString)){
            throw new StringIsEmptyException();
        }
    }

    /**
     * Prueft, ob ein uebergebener String Sonderzeichen enthaelt
     * @param zuUeberpruefenderString
     * @return true, wenn Sonderzeichen vorhanden, sonst false
     */
    public static boolean isSonderzeichenVorhanden(String zuUeberpruefenderString){
        //TODO JUNIT TEST

        if (zuUeberpruefenderString.matches(STRING_OHNE_SONDERZEICHEN_REGEX)){
            return false;
        }
        return true;
    }
}
