package notizverwaltung.model.classes;

import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testet Methoden der Klasse BearbeitungszustandImpl
 *
 * @author Michelle Blau
 * @version 31.08.2018
 */

class BearbeitungszustandImplTest {


    @BeforeEach
    void setUp()  {

    }

    @AfterEach
    void tearDown() {
    }


    /**
     * Testet, was bei Überegabe eines leeren Strings passiert
     * Methode: setName()
     * -> Erwartet wird eine StringIsEmptyException
     */
    @Test
    void setNameStringIstLeer() {
        String leerString ="";
        Bearbeitungszustand testZustand = new BearbeitungszustandImpl();

        assertThrows(StringIsEmptyException.class, () -> { testZustand.setName(leerString);});
    }



    /**
     * Testet, was bei Überegabe eines null-Strings passiert
     * Methode: setName()
     * -> Erwartet wird eine StringIsEmptyException
     */
    @Test
    void setNameStringIstNull() {
        String nullString =null;
        Bearbeitungszustand testZustand = new BearbeitungszustandImpl();

        assertThrows(StringIsEmptyException.class, () -> { testZustand.setName(nullString);});
    }


    /**
     * Testet, was bei Übergabe eines Bearbeitungszustands mit gleicher ID passiert
     * Methode: equals()
     * ->Erwartet wird der Rückgabewert true
     */
    @Test
    void equalsZustaendeSindGleich(){
        Bearbeitungszustand zustand1 = new BearbeitungszustandImpl();
        zustand1.setBearbeitungszustandID(244);
        Bearbeitungszustand zustand2 = new BearbeitungszustandImpl();
        zustand2.setBearbeitungszustandID(244);

        boolean ergebnis = zustand1.equals(zustand2);

        assertEquals(true, ergebnis);
    }

    /**
     * Testet, was bei Übergabe eines Bearbeitungszustands mit ungleicher ID passiert
     * Methode: equals()
     * ->Erwartet wird der Rückgabewert false
     */
    @Test
    void equalsZustaendeSindUngleich(){
        Bearbeitungszustand zustand1 = new BearbeitungszustandImpl();
        zustand1.setBearbeitungszustandID(249);
        Bearbeitungszustand zustand2 = new BearbeitungszustandImpl();
        zustand2.setBearbeitungszustandID(244);

        boolean ergebnis = zustand1.equals(zustand2);

        assertEquals(false, ergebnis);
    }

}