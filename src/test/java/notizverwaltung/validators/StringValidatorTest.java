package notizverwaltung.validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse fuer die Klasse StringValidator
 *
 * @author Tobias Gottschalk
 * @author Michelle Blau
 *
 * @version 1.0
 */
class StringValidatorTest {

    /**
     * Testet, ob eine die Methode true zurueck liefert, wenn der Methode ein leerer String uebergeben wird
     */
    @org.junit.Test
    void isStringLeerOderNullTrue() {
        String leererString = " ";
        boolean bool = StringValidator.isStringLeerOderNull(leererString);

        assertEquals(true, bool);
    }

    /**
     * Testet, ob die Methode false zurueck liefert, wenn der zuueberpruefende String nicht leer ist.
     */
    void isStringLeerOderNullFalse() {
        String leererString = "Test String";
        boolean bool = StringValidator.isStringLeerOderNull(leererString);

        assertEquals(false, bool);
    }

    /**
     * Testet, was bei Übergabe eines Strings mit Sonderzeichen passiert
     * Methode: isSonderzeichenVorhanden()
     * ->Erwartet wird der Rückgabewert true
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
     */
    @Test
    void isSonderzeichenVorhandenOhneSonderzeichen(){
        String normalerString = "Hallo Welt";
        boolean ergebnis = StringValidator.isSonderzeichenVorhanden(normalerString);

        assertEquals(false, ergebnis);
    }

}