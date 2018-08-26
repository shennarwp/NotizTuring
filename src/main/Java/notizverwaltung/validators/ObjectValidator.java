package notizverwaltung.validators;

import notizverwaltung.exceptions.ObjectIstNullException;
/**
 * Die Klasse stellt Methoden fuer das Pruefen von Objekten bereit
 *
 * @author Tobias Gottschalk
 *
 * @version 1.0
 */
public class ObjectValidator {


    /**
     * @param zuUberpruefendesObject
     * @throws ObjectIstNullException wirft eine Exception, wenn das Objekt null ist
     */
    public static void checkObObjectNullIst(Object zuUberpruefendesObject) throws ObjectIstNullException {
        if(zuUberpruefendesObject == null){
            throw new ObjectIstNullException();
        }
    }
}
