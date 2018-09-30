package notizverwaltung.util;

import notizverwaltung.exceptions.ObjectIstNullException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse für die DateUtil Klasse
 * @author Tobias Gottschalk
 */
class DateUtilTest {




    /**
     * Testet die Methode auf ein Date, welches null ist
     * Methode: convertDateInLocalDate
     * Erwartet: ObjectIstNullException
     */
    @Test
    void convertDateInLocalDate() {
        Date date = null;
        assertThrows(ObjectIstNullException.class, () -> { DateUtil.convertDateInLocalDate(date);});
    }


    /**
     * Testet die Methode auf ein Date, welches null ist
     * Methode: convertDateInLocalDate
     * Erwartet: ObjectIstNullException
     */
    @Test
    void convertLocalDateInDate() {
        LocalDate date = null;
        assertThrows(ObjectIstNullException.class, () -> { DateUtil.convertLocalDateInDate(date);});
    }
}
