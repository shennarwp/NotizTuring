package notizverwaltung.service.classes;

import notizverwaltung.exceptions.IntIstNegativException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void filterAlleNotizenMitPrioritätNotizblockIDIstNegativ() {
        int testInt = -1;
        NotizFilterServiceImpl notizFilterService = new NotizFilterServiceImpl();
        assertThrows(IntIstNegativException.class, () -> {notizFilterService.filterAlleNotizenMiteinerBestimmtenKategorie(testInt,1);});

    }

    @Test
    void filterAlleNotizenMitPrioritätKategorieIstNegativ() {
        int testInt = -1;
        NotizFilterServiceImpl notizFilterService = new NotizFilterServiceImpl();
        assertThrows(IntIstNegativException.class, () -> {notizFilterService.filterAlleNotizenMiteinerBestimmtenKategorie(1,testInt);});

    }

    @Test
    void filterAlleNotizenOhnePrioritätNotizblockIDIstNegativ() {
        int testInt = -1;
        NotizFilterServiceImpl notizFilterService = new NotizFilterServiceImpl();
        assertThrows(IntIstNegativException.class, () -> {notizFilterService.filterAlleNotizenOhnePriorität(testInt,1);});
    }

    @Test
    void filterAlleNotizenOhnePrioritätBearbeitungszustandIDIstNegativ() {
        int testInt = -1;
        NotizFilterServiceImpl notizFilterService = new NotizFilterServiceImpl();
        assertThrows(IntIstNegativException.class, () -> {notizFilterService.filterAlleNotizenOhnePriorität(testInt,1);});
    }


    @Test
    void filterAlleNotizenMiteinerBestimmtenKategorieNotizblockIDIstNegativ() {
        int testInt = -1;
        NotizFilterServiceImpl notizFilterService = new NotizFilterServiceImpl();
        assertThrows(IntIstNegativException.class, () -> {notizFilterService.filterAlleNotizenMiteinerBestimmtenKategorie(testInt,1);});
    }

    @Test
    void filterAlleNotizenMiteinerBestimmtenKategorieBearbeitungszustandIDIstNegativ() {
        int testInt = -1;
        NotizFilterServiceImpl notizFilterService = new NotizFilterServiceImpl();
        assertThrows(IntIstNegativException.class, () -> {notizFilterService.filterAlleNotizenMiteinerBestimmtenKategorie(1,testInt);});
    }
}