package notizverwaltung.validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse fuer die Klasse StringValidator
 *
 * @author Tobias Gottschalk
 *
 * @version 1.0
 */
class StringValidatorTest {

    @org.junit.Test
    void isStringLeerOderNullTrue() {
        String leererString = " ";
        boolean bool = StringValidator.isStringLeerOderNull(leererString);

        assertEquals(true, bool);
    }

    void isStringLeerOderNullFalse() {
        String leererString = "Test String";
        boolean bool = StringValidator.isStringLeerOderNull(leererString);

        assertEquals(false, bool);
    }

    /**
     * Testet, was bei Übergabe eines Strings mit Sonderzeichen passiert
     * Methode: isSonderzeichenVorhanden()
     * ->Erwartet wird der Rückgabewert true
     * @author Michelle Blau
     */
    @Test
    void isSonderzeichenVorhandenMitSonderzeichen(){
        String sonderzeichenString = "-$Hallo_Welt$-";
        boolean ergebnis = StringValidator.isSonderzeichenVorhanden(sonderzeichenString);

        assertEquals(true, ergebnis);
    }

    /**
     * Testet, was bei Übergabe eines Strings ohne Sonderzeichen passiert
     * Methode: isSonderzeichenVorhanden()
     * ->Erwartet wird der Rückgabewert false
     * @author Michelle Blau
     */
    @Test
    void isSonderzeichenVorhandenOhneSonderzeichen(){
        String normalerString = "Hallo Welt";
        boolean ergebnis = StringValidator.isSonderzeichenVorhanden(normalerString);

        assertEquals(false, ergebnis);
    }

}