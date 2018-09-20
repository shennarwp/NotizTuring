package notizverwaltung.model.classes;

import javafx.scene.paint.Color;
import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.model.interfaces.Kategorie;
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
}