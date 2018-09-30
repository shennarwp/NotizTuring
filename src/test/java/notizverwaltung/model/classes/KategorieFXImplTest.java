package notizverwaltung.model.classes;

import javafx.scene.paint.Color;
import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.KategorieFX;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testklasse fuer die Klasse KategorieFXImpl
 *
 * @author Kevin Engelhardt
 *
 * @version 1.0
 */
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testet Methoden der Klasse KategorieFXImpl
 *
 * @author Kevin Engelhardt
 * @author Michelle Blau
 */
class KategorieFXImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void setKategorieID() {
        int testInt = -1;
        KategorieFXImpl kategorieFXImpl = new KategorieFXImpl();
        assertThrows(IntIstNegativException.class, () -> {kategorieFXImpl.setKategorieID(testInt); });
    }



    @Test
    void setKategorieName() {
        String leerstring = " ";
        KategorieFXImpl kategorieFXImpl = new KategorieFXImpl();
        assertThrows(StringIsEmptyException.class, () -> {kategorieFXImpl.setKategorieName(leerstring);});
    }



    @Test
    void setFarbe() {
        Color testObject = null;
        KategorieFXImpl kategorieFXImpl = new KategorieFXImpl();
        assertThrows(ObjectIstNullException.class, () -> {kategorieFXImpl.setFarbe(testObject);});
    }

    /**
     * Testet, was bei Übergabe einer KategorieFX mit gleicher ID passiert
     * Methode: equals()
     * ->Erwartet wird der Rückgabewert true
     */
    @Test
    void equalsKategorienSindGleich(){
        KategorieFX kategorieFX1 = new KategorieFXImpl();
        kategorieFX1.setKategorieID(244);

        KategorieFX kategorieFX2 = new KategorieFXImpl();
        kategorieFX2.setKategorieID(244);

        boolean ergebnis = kategorieFX1.equals(kategorieFX2);

        assertEquals(true, ergebnis);
    }

    /**
     * Testet, was bei Übergabe einer KategorieFX mit ungleicher ID passiert
     * Methode: equals()
     * ->Erwartet wird der Rückgabewert false
     */
    @Test
    void equalsKategorienSindUngleich(){
        KategorieFX kategorieFX1 = new KategorieFXImpl();
        kategorieFX1.setKategorieID(244);

        KategorieFX kategorieFX2 = new KategorieFXImpl();
        kategorieFX2.setKategorieID(249);

        boolean ergebnis = kategorieFX1.equals(kategorieFX2);

        assertEquals(false, ergebnis);
    }
}