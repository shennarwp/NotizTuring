package notizverwaltung.service.classes;

import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.ObjectIstNullException;;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.KategorieFX;
import notizverwaltung.service.interfaces.KategorieFXService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse zum Testen der Klasse KategorieFXServiceImpl
 *
 * @author Kevin Engelhardt
 *
 * @version 1.0
 */

class KategorieFXServiceImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * testet Methode auf falsche Eingabe (leeres Object)
     * Methode: wrapKategorie
     */
    @Test
    void wrapKategorie(){
        Kategorie emptyObject = null;
        KategorieFXService kategorieFXService = new KategorieFXServiceImpl();
        assertThrows(ObjectIstNullException.class, () -> {kategorieFXService.wrapKategorie(emptyObject);});
    }

    /**
     * testet Methode auf falsche Eingabe (leeres Object)
     * Methode: unwrapKategorieFX
     */
    @Test
    void unwrapKategorieFX(){
        KategorieFX emptyObject = null;
        KategorieFXServiceImpl kategorieFXService = new KategorieFXServiceImpl();
        assertThrows(ObjectIstNullException.class, () -> {kategorieFXService.unwrapKategorieFX(emptyObject);});
    }

    /**
     * testet Methode auf falsche Eingabe (leere Liste)
     * Methode: convertInKategorieFXList
     */
    @Test
    void convertInKategorieFXList(){
        List<Kategorie> emptyList = null;
        KategorieFXServiceImpl kategorieFXService = new KategorieFXServiceImpl();
        assertThrows(ObjectIstNullException.class, () -> {kategorieFXService.convertInKategorieFXList(emptyList);});
    }

    /**
     * testet Methode auf falsche Eingabe
     * Methode: getKategorieNamePropertyVonKategorieID
     */
    @Test
    void getKategorieNamePropertyVonKategorieID() {
        int testInt = -1;
        KategorieFXServiceImpl kategorieFXService = new KategorieFXServiceImpl();
        assertThrows(IntIstNegativException.class, () -> {kategorieFXService.getKategorieNamePropertyVonKategorieID(testInt);});

    }
}