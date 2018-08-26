package notizverwaltung.validators;

import notizverwaltung.exceptions.IntIstNegativException;

public class IntValidator {


    public static void checkObIntNullOderNegativIst(int zuueberpruefendesInt) throws IntIstNegativException {
        if(zuueberpruefendesInt<1){
            throw new IntIstNegativException();
        }
    }
}
