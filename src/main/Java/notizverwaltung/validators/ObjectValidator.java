package notizverwaltung.validators;

import notizverwaltung.exceptions.ObjectIstNullException;
/**
 * Die Klasse stellt Methoden fuer das Pruefen von Objekten bereit
 *  TODO Validatoren mit JUnit testen
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


    /**
     * Prüft, ob ein übergebens Objekt null ist
     *
     * @param zuUeberpruefendesObject zu prüfendes Objekt
     * @return true,wenn das Objekt null ist, sonst false
     */
    public static boolean isObjectNull(Object zuUeberpruefendesObject){
        if(zuUeberpruefendesObject == null){
            return true;
        }else{
            return false;
        }
    }

}
