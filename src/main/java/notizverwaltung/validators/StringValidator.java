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
}
