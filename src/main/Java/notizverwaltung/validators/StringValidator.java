package main.java.notizverwaltung.validators;


import main.java.notizverwaltung.exceptions.StringIsEmptyException;

/**
 * Die Klasse beinhaltet Methoden zur Ueberprufung von Strings
 *
 * @author Tobias Gottschalk
 *
 * @version 1.0
 */

public class StringValidator {

    public static boolean isStringLeer(String zuUeberpruefenderString){
        if(zuUeberpruefenderString == null|| zuUeberpruefenderString.trim().isEmpty()){
            return true;
        }

        return false;
    }


    public static void checkObStringLeerIst(String zuUeberpruefenderString) throws StringIsEmptyException{
        if (isStringLeer(zuUeberpruefenderString)){
            throw new StringIsEmptyException();
        }
    }
}
