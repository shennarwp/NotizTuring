package notizverwaltung.model.classes;

import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.validators.StringValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Testklasse fuer die Klasse NotizImpl
 *
 * @author Tobias Gottschalk
 * @author Michelle Blau
 *
 * @version 1.0
 */
class NotizImplTest {
    String stringIstLeer = " ";
    String stringIstNull = null;
    int intIstNegativ = -1;


    NotizImpl notiz = new NotizImpl();

    /**
     * Testet die Methode auf einen leeren String
     * Methode: setBeschreibung
     * Erwartet: StringIsEmptyException
     */
    @Test
    void setTitleStringIstLeer() {
        assertThrows(StringIsEmptyException.class, () -> { notiz.setBeschreibung(stringIstLeer);});

    }

    /**
     * Testet die Methode auf String, welcher null ist
     * Methode: setBeschreibung
     * Erwartet: StringIsEmptyException
     */
    @Test
    void setTitleStringIstNull() {
        assertThrows(StringIsEmptyException.class, () -> { notiz.setBeschreibung(stringIstNull);});

    }

    /**
     * Testetdie Methode auf einen leeren String
     * Methode: setBeschreibung
     * Erwartet: StringIsEmptyException
     */
    @Test
    void setBeschreibungStringIstNull() throws StringIsEmptyException, IntIstNegativException, IOException, ObjectIstNullException {

        notiz = new NotizImpl();

        assertThrows(StringIsEmptyException.class, () -> { notiz.setBeschreibung(stringIstLeer);});

    }
    /**
     * Testet die Methode auf einen String, welcher null ist
     * Methode: setBeschreibung
     * Erwartet: StringIsEmptyException
     */
    @Test
    void setBeschreibungStringIstLeer() throws StringIsEmptyException, IntIstNegativException, IOException, ObjectIstNullException {

        assertThrows(StringIsEmptyException.class, () -> { notiz.setBeschreibung(stringIstLeer);});

    }

    /**
     * Testet die Methode einen int, welcher kleiner ist als 1
     * Methode: setKategorieID
     * Erwartet: IntIstNegativException
     */
    @Test
    void setKategorieID() {
        assertThrows(IntIstNegativException.class, () -> { notiz.setKategorieID(intIstNegativ);});
    }

    /**
     * Testet die Methode auf einen leeren String
     * Methode: setBeschreibung
     * Erwartet: StringIsEmptyException
     */
    @Test
    void setBeschreibungIstLeer() {
        assertThrows(StringIsEmptyException.class, () -> { notiz.setBeschreibung(stringIstLeer);});
    }

    /**
     * Testet die Methode auf einen String, welcher null ist
     * Methode: setKategorieID
     * Erwartet: StringIsEmptyException
     */
    @Test
    void setBeschreibungIstLNull() {
        assertThrows(StringIsEmptyException.class, () -> { notiz.setBeschreibung(stringIstNull);});
    }

    /**
     * Testet die Methode einen int, welcher kleiner ist als 1
     * Methode: setBearbeitungszustandID
     * Erwartet: IntIstNegativException
     */
    @Test
    void setBearbeitungszustandID() {
        assertThrows(IntIstNegativException.class, () -> { notiz.setBearbeitungszustandID(intIstNegativ);});

    }

    /**
     * Testet die Methode auf ein Null Objekt
     * Methode: setErinnerung
     * Erwartet: ObjectIstNullException
     */
    @Test
    void setErinnerung() {
        Date dateIstNull = null;
        assertThrows(ObjectIstNullException.class, () -> { notiz.setErinnerung(dateIstNull);});

    }

    /**
     * Testet, was bei Übergabe einer Notiz mit gleicher ID passiert
     * Methode: equals()
     * ->Erwartet wird der Rückgabewert true
     */
    @Test
    void equalsNotizenSindGleich(){
        Notiz notiz1 = new NotizImpl();
        notiz1.setID(244);
        Notiz notiz2 = new NotizImpl();
        notiz2.setID(244);

        boolean ergebnis = notiz1.equals(notiz2);

        assertEquals(true, ergebnis);
    }

    /**
     * Testet, was bei Übergabe einer Notiz mit ungleicher ID passiert
     * Methode: equals()
     * ->Erwartet wird der Rückgabewert false
     */
    @Test
    void equalsNotizenSindUngleich(){
        Notiz notiz1 = new NotizImpl();
        notiz1.setID(249);
        Notiz notiz2 = new NotizImpl();
        notiz2.setID(244);

        boolean ergebnis = notiz1.equals(notiz2);

        assertEquals(false, ergebnis);
    }

    @Test
    void setID() {
    }


    @Test
    void setFaelligkeit() {
    }



}