package notizverwaltung.model.classes;

import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.model.interfaces.NotizFX;
import notizverwaltung.validators.ObjectValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    void setNotizID() {
        NotizFXImpl notizFXImpl = new NotizFXImpl();
        assertThrows(IntIstNegativException.class, () -> {notizFXImpl.setNotizID(testInt);});

    }

    @Test
    void setTitle() {
        NotizFXImpl notizFXImpl = new NotizFXImpl();
        assertThrows(StringIsEmptyException.class, () -> {notizFXImpl.setTitle(leerString);});

    }

    @Test
    void setKategorieID() {
        NotizFXImpl notizFXImpl = new NotizFXImpl();
        assertThrows(IntIstNegativException.class, () -> {notizFXImpl.setKategorieID(testInt);});

    }

    @Test
    void setBearbeitungszustandID() {
        NotizFXImpl notizFXImpl = new NotizFXImpl();
        assertThrows(IntIstNegativException.class, () -> {notizFXImpl.setBearbeitungszustandID(testInt);});
    }

    @Test
    void setBeschreibung() {
        NotizFXImpl notizFXImpl = new NotizFXImpl();
        assertThrows(StringIsEmptyException.class, () -> {notizFXImpl.setBeschreibung(leerString);});
    }
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


//TODO J Unit Methoden auskommentieren, falls in Klasse NotizFXImpl implementiert.
  //  @Test
  //  void setErinnerung() {
  //      NotizFXImpl notizFXImpl = new NotizFXImpl();
  //      assertThrows(ObjectIstNullException.class, () -> {notizFXImpl.setErinnerung(objectIsNull);});
  //  }

 //   @Test
 //   void setErstellung() {
 //       NotizFXImpl notizFXImpl = new NotizFXImpl();
 //       assertThrows(ObjectIstNullException.class, () -> {notizFXImpl.setErstellung(objectIsNull);});
 //   }


}