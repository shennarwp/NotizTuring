package notizverwaltung.service.classes;

import notizverwaltung.exceptions.IntIstNegativException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KategorieFXServiceImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getKategorieNamePropertyVonKategorieID() {
        int testInt = -1;
        KategorieFXServiceImpl kategorieFXService = new KategorieFXServiceImpl();
        assertThrows(IntIstNegativException.class, () -> {kategorieFXService.getKategorieNamePropertyVonKategorieID(testInt);});

    }
}