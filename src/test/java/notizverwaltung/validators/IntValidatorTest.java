package notizverwaltung.validators;

import notizverwaltung.exceptions.IntIstNegativException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse für IntValidator
 * @author Tobias Gottschalk
 */
class IntValidatorTest {

    /**
     *
     * Test, ob die Methode eine IntIStNegativException wirft
     * Methode: checkObIntNullOderNegativIst()
     *      * -> erwartet wird eine IntIStNegativException
     */
    @Test
    void checkObIntNullOderNegativIst() {
        int zuUberpruefendesInt = -1;


        assertThrows(IntIstNegativException.class, () -> { IntValidator.checkObIntNullOderNegativIst(zuUberpruefendesInt);});
    }
}