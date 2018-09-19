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

import static org.junit.jupiter.api.Assertions.*;
/**
 * Testklasse fuer die Klasse NotizImpl
 *
 * @author Tobias Gottschalk
 *
 * @version 1.0
 */
class NotizImplTest {

    @BeforeEach
    void setUp()  {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void setBeschreibungStringIstNull() throws StringIsEmptyException, IntIstNegativException, IOException, ObjectIstNullException {
        String test = null;
        NotizImpl notiz = new NotizImpl();

        assertThrows(StringIsEmptyException.class, () -> { notiz.setBeschreibung(test);});

    }

    @Test
    void setBeschreibungStringIstLeer() throws StringIsEmptyException, IntIstNegativException, IOException, ObjectIstNullException {
        String test = " ";
        NotizImpl notiz = new NotizImpl();
        assertThrows(StringIsEmptyException.class, () -> { notiz.setBeschreibung(test);});

    }



    @Test
    void getBearbeitungszustand() {
    }

    @Test
    void setKategorie() {
    }

    @Test
    void setTitle1() {
    }

    @Test
    void setBeschreibung() {
    }

    @Test
    void setPrioritaet1() {
    }

    @Test
    void setBearbeitungszustand1() {
    }

    @Test
    void isErinnerungGesetzt() {
    }

    @Test
    void setErinnerung() {
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
}