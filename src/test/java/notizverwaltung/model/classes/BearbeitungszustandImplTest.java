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

}