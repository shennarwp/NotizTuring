package notizverwaltung.service.classes;

import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.model.interfaces.NotizFX;
import notizverwaltung.validators.ObjectValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse zum Testen der Klasse  NotizFXServiceImpl
 *
 * @author Kevin Engelhardt
 *
 * @version 1.0
 */

class NotizFXServiceImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void wrapNotiz() {
        Notiz emptyObject = null;
        NotizFXServiceImpl notizFXService = new NotizFXServiceImpl();
        assertThrows(ObjectIstNullException.class, () -> {notizFXService.wrapNotiz(emptyObject);});
    }

    @Test
    void unwrapNotizFX() {
        NotizFX emptyObject = null;
        NotizFXServiceImpl notizFXService = new NotizFXServiceImpl();
        assertThrows(ObjectIstNullException.class, () -> {notizFXService.unwrapNotizFX(emptyObject);});
    }

    @Test
    void convertInNotizFXList() {
        List<Notiz> emptyList = null;
        NotizFXServiceImpl notizFXService  = new NotizFXServiceImpl();
        assertThrows(ObjectIstNullException.class, ()-> {notizFXService.convertInNotizFXList(emptyList);});
    }
}