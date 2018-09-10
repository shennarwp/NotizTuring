package notizverwaltung.validators;

import notizverwaltung.exceptions.ObjectIstNullException;
import org.junit.jupiter.api.Test;

import static notizverwaltung.validators.ObjectValidator.checkObObjectNullIst;
import static notizverwaltung.validators.ObjectValidator.isObjectNull;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testet Methoden der Klasse ObjectValidator
 *
 * @author Michelle Blau
 */
class ObjectValidatorTest {

    /**
     * Testet, was bei Übergabe einer null-Referenz passiert
     * Methode: checkObObjectNullIst()
     * -> erwartet wird eine ObjectIstNullException
     */
    @Test
    void checkObObjectNullIstObjectIstNull() {
        Object testObject = null;

        assertThrows(ObjectIstNullException.class, () -> { checkObObjectNullIst(testObject);});
    }


    /**
     * Testet, was bei Übergabe eines Objektes, das nicht null ist, passiert
     * Methode: checkObObjectNullIst()
     * -> es soll nichts passieren
     */
    @Test
    void checkObObjectNullIstObjectIstNichtNull() {
        Object testObject = new Object();

        checkObObjectNullIst(testObject);
    }


    /**
     * Testet, was bei Übergabe einer null-Referenz passiert
     * Methode: isObjectNull()
     * -> es soll true zurückgegeben werden
     */
    @Test
    void isObjectNullObjectIstNull() {
        Object testObject = null;
        boolean ergebnis = isObjectNull(testObject);
        assertEquals(true, ergebnis);
    }


    /**
     * Testet, was bei Übergabe eines Objektes, das nicht null ist, passiert
     * Methode: isObjectNull()
     * -> es soll false zurückgegeben werden
     */
    @Test
    void isObjectNullObjectIstNichtNull() {
        Object testObject = new Object();
        boolean ergebnis = isObjectNull(testObject);
        assertEquals(false, ergebnis);
    }

}