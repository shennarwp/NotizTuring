package notizverwaltung.service.classes;

import notizverwaltung.exceptions.IntIstNegativException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse zum Testen der Klasse NotizFilterServiceImpl
 * @author Kevin Engelhardt
 * @version 1.0
 */

class NotizFilterServiceImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void filterAlleNotizenMitLambda() {
    }

    /**
     * testet Methode auf falsche Eingabe  im Notizblock (neg. int)
     * Methode: filterAlleNotizenMitPriorität
     */
    @Test
    void filterAlleNotizenMitPrioritätNotizblockIDIstNegativ() {
        int testInt = -1;
        NotizFilterServiceImpl notizFilterService = new NotizFilterServiceImpl();
        assertThrows(IntIstNegativException.class, () -> {notizFilterService.filterAlleNotizenMiteinerBestimmtenKategorie(testInt,1);});

    }


    /**
     * testet Methode auf falsche Eingabe in der Kategorie(neg. int)
     * Methode: filterAlleNotizenMitPriorität
     */
    @Test
    void filterAlleNotizenMitPrioritätKategorieIstNegativ() {
        int testInt = -1;
        NotizFilterServiceImpl notizFilterService = new NotizFilterServiceImpl();
        assertThrows(IntIstNegativException.class, () -> {notizFilterService.filterAlleNotizenMiteinerBestimmtenKategorie(1,testInt);});

    }

    /**
     * testet Methode auf falsche Eingabe im Notizblock(neg. int)
     * Methode: filterAlleNotizenOhnePriorität
     */
    @Test
    void filterAlleNotizenOhnePrioritätNotizblockIDIstNegativ() {
        int testInt = -1;
        NotizFilterServiceImpl notizFilterService = new NotizFilterServiceImpl();
        assertThrows(IntIstNegativException.class, () -> {notizFilterService.filterAlleNotizenOhnePrioritaet(testInt,1);});
    }

    /**
     * testet Methode auf falsche Eingabe im Bearbeitungszustand(neg. int)
     * Methode: filterAlleNotizenOhnePriorität
     */
    @Test
    void filterAlleNotizenOhnePrioritätBearbeitungszustandIDIstNegativ() {
        int testInt = -1;
        NotizFilterServiceImpl notizFilterService = new NotizFilterServiceImpl();
        assertThrows(IntIstNegativException.class, () -> {notizFilterService.filterAlleNotizenOhnePrioritaet(testInt,1);});
    }


    /**
     * testet Methode auf falsche Eingabe im Notizblock(neg. int)
     * Methode: filterAlleNotizenMiteinerBestimmtenKategorie
     */
    @Test
    void filterAlleNotizenMiteinerBestimmtenKategorieNotizblockIDIstNegativ() {
        int testInt = -1;
        NotizFilterServiceImpl notizFilterService = new NotizFilterServiceImpl();
        assertThrows(IntIstNegativException.class, () -> {notizFilterService.filterAlleNotizenMiteinerBestimmtenKategorie(testInt,1);});
    }

    /**
     * testet Methode auf falsche Eingabe im Bearbeitungszustand(neg. int)
     * Methode: filterALleNotizenMiteinerBestimmtenKategorie
     */
    @Test
    void filterAlleNotizenMiteinerBestimmtenKategorieBearbeitungszustandIDIstNegativ() {
        int testInt = -1;
        NotizFilterServiceImpl notizFilterService = new NotizFilterServiceImpl();
        assertThrows(IntIstNegativException.class, () -> {notizFilterService.filterAlleNotizenMiteinerBestimmtenKategorie(1,testInt);});
    }
}