package notizverwaltung.validators;

import notizverwaltung.exceptions.ObjectIstNullException;

public class ObjectValidator {
    public static void checkObObjectNullIst(Object object) throws ObjectIstNullException {
        if(object == null){
            throw new ObjectIstNullException();
        }
    }
}
