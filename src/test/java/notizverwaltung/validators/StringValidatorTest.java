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

    @Test
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
}