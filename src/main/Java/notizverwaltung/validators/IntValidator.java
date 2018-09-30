package notizverwaltung.validators;

import notizverwaltung.exceptions.IntIstNegativException;

/**
 * Die Klasse überprüft primitive Integer auf verschiedene Kriterien
 * @author Tobias Gottschalk
 */
public class IntValidator {


    /**
     * Ueberprueft ob ein int kleiner ist als 1
     * @param zuueberpruefendesInt int, welches ueberprueft werden soll
     * @throws IntIstNegativException wirft eine Exception
     */
    public static void checkObIntNullOderNegativIst(int zuueberpruefendesInt) throws IntIstNegativException {
        if(zuueberpruefendesInt < 1){
            throw new IntIstNegativException();
        }
    }
}
