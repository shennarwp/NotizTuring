package notizverwaltung.model.classes;

import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.model.interfaces.NotizFX;
import notizverwaltung.validators.ObjectValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse zum Testen der Klasse NotizFXImpl
 * @author Kevin Engelhardt
 * @author Michelle Blau
 * @version 1.0
 */

class NotizFXImplTest {
    int testInt = -1;
    String leerString = " ";
    Date objectIsNull = null;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * testet set Methode auf falsche Eingabe (neg. int)
     * Methode: setNotizID
     */
    @Test
    void setNotizID() {
        NotizFXImpl notizFXImpl = new NotizFXImpl();
        assertThrows(IntIstNegativException.class, () -> {notizFXImpl.setNotizID(testInt);});

    }

    /**
     * testet set Methode auf falsche Eingabe (leerer String)
     * Methode: setTitle
     */
    @Test
    void setTitle() {
        NotizFXImpl notizFXImpl = new NotizFXImpl();
        assertThrows(StringIsEmptyException.class, () -> {notizFXImpl.setTitle(leerString);});

    }

    /**
     * testet set Methode auf falsche Eingabe (neg. int)
     * Methode: setKategorieID
     */
    @Test
    void setKategorieID() {
        NotizFXImpl notizFXImpl = new NotizFXImpl();
        assertThrows(IntIstNegativException.class, () -> {notizFXImpl.setKategorieID(testInt);});

    }

    /**
     * testet set Methode auf falsche Eingabe (neg. int)
     * Methode: setBearbeitungszustandID
     */
    @Test
    void setBearbeitungszustandID() {
        NotizFXImpl notizFXImpl = new NotizFXImpl();
        assertThrows(IntIstNegativException.class, () -> {notizFXImpl.setBearbeitungszustandID(testInt);});
    }

    /**
     * testet set Methode auf falsche Eingabe (leerer String)
     * Methode: setBeschreibung
     */
    @Test
    void setBeschreibung() {
        NotizFXImpl notizFXImpl = new NotizFXImpl();
        assertThrows(StringIsEmptyException.class, () -> {notizFXImpl.setBeschreibung(leerString);});
    }

    /**
     * testet set Methode auf falsche Eingabe (leeres Object)
     * Methode: setFaelligkeit
     */
    @Test
    void setFaelligkeit() {
        NotizFXImpl notizFXImpl = new NotizFXImpl();
        assertThrows(ObjectIstNullException.class,  () -> {notizFXImpl.setFaelligkeit(objectIsNull);});
    }

    /**
     * Testet, was bei Übergabe einer NotizFX mit gleicher ID passiert
     * Methode: equals()
     * ->Erwartet wird der Rückgabewert true
     */
    @Test
    void equalsNotizenSindGleich(){
        NotizFX notizFX1 = new NotizFXImpl();
        notizFX1.setNotizID(244);

        NotizFX notizFX2 = new NotizFXImpl();
        notizFX2.setNotizID(244);

        boolean ergebnis = notizFX1.equals(notizFX2);

        assertEquals(true, ergebnis);
    }

    /**
     * Testet, was bei Übergabe einer KategorieFX mit ungleicher ID passiert
     * Methode: equals()
     * ->Erwartet wird der Rückgabewert false
     */
    @Test
    void equalsNotizenSindUngleich(){
        NotizFX notizFX1 = new NotizFXImpl();
        notizFX1.setNotizID(244);

        NotizFX notizFX2 = new NotizFXImpl();
        notizFX2.setNotizID(249);

        boolean ergebnis = notizFX1.equals(notizFX2);

        assertEquals(false, ergebnis);
    }


    /**
     * Testet, was bei Übergabe einer NotizFXImpl mit gleichem Fälligkeitsdatum passiert
     * Methode: compareTo()
     * ->Erwartet wird der Rückgabewert 0
     */
    @Test
    void compareToFaelligkeitenGleich(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date naechsteWoche = calendar.getTime();

        NotizFXImpl notizFX1 = new NotizFXImpl();
        notizFX1.setFaelligkeit(naechsteWoche);

        NotizFXImpl notizFX2 = new NotizFXImpl();
        notizFX2.setFaelligkeit(naechsteWoche);

        int ergebnis = notizFX1.compareTo(notizFX2);

        assertEquals(0, ergebnis);
    }


    /**
     * Testet, was bei Übergabe einer NotizFXImpl mit kleinerem Fälligkeitsdatum passiert
     * Methode: compareTo()
     * ->Erwartet wird der Rückgabewert 1
     */
    @Test
    void compareToFaelligkeitDesArgumentsKleiner(){
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DAY_OF_YEAR, 7);
        Date naechsteWoche = calendar1.getTime();

        NotizFXImpl notizFX1 = new NotizFXImpl();
        notizFX1.setFaelligkeit(naechsteWoche);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.DAY_OF_YEAR, 6);
        Date sechsTage = calendar2.getTime();

        NotizFXImpl notizFX2 = new NotizFXImpl();
        notizFX2.setFaelligkeit(sechsTage);

        int ergebnis = notizFX1.compareTo(notizFX2);

        assertEquals(1, ergebnis);
    }

    /**
     * Testet, was bei Übergabe einer NotizFXImpl mit größerem Fälligkeitsdatum passiert
     * Methode: compareTo()
     * ->Erwartet wird der Rückgabewert -1
     */
    @Test
    void compareToFaelligkeitDesArgumentsGroesser(){
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DAY_OF_YEAR, 7);
        Date naechsteWoche = calendar1.getTime();

        NotizFXImpl notizFX1 = new NotizFXImpl();
        notizFX1.setFaelligkeit(naechsteWoche);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.DAY_OF_YEAR, 8);
        Date achtTage = calendar2.getTime();

        NotizFXImpl notizFX2 = new NotizFXImpl();
        notizFX2.setFaelligkeit(achtTage);

        int ergebnis = notizFX1.compareTo(notizFX2);

        assertEquals(-1, ergebnis);
    }



}