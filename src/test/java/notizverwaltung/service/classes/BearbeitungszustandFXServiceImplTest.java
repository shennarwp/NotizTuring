package notizverwaltung.service.classes;

import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.BearbeitungszustandFX;
import notizverwaltung.service.classes.BearbeitungszustandFXServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse zum Testen der Klasse  BearbeitungszustandFXServiceImpl
 *
 * @author Kevin Engelhardt
 *
 * @version 1.0
 */

class BearbeitungszustandFXServiceImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * testet Methode auf falsche Eingabe (leeres Object)
     * Methode: wrapBearbeitungszustand
     */
    @Test
    void wrapBearbeitungszustand() {
        Bearbeitungszustand emptyObject =  null;
        BearbeitungszustandFXServiceImpl bearbeitungszustandFXService = new BearbeitungszustandFXServiceImpl();
        assertThrows(ObjectIstNullException.class, () -> {bearbeitungszustandFXService.wrapBearbeitungszustand(emptyObject);});

    }

    /**
     * testet Methode auf falsche Eingabe (leeres Object)
     * Methode: unwrapBearbeitungszustandFX
     */
    @Test
    void unwrapBearbeitungszustandFX() {
        BearbeitungszustandFX emptyObject = null;
        BearbeitungszustandFXServiceImpl bearbeitungszustandFXService = new BearbeitungszustandFXServiceImpl();
        assertThrows(ObjectIstNullException.class, () -> {bearbeitungszustandFXService.unwrapBearbeitungszustandFX(emptyObject);});
    }

    /**
     * testet Methode auf falsche Eingabe (leere Liste)
     * Methode: convertInBearbeitungszustandListe
     */
    @Test
    void convertInBearbeitungszustandFXList(){
        ArrayList<Bearbeitungszustand> emptyList = null;
        BearbeitungszustandFXServiceImpl bearbeitungszustandFXService = new BearbeitungszustandFXServiceImpl();
        assertThrows(ObjectIstNullException.class, ()  -> {bearbeitungszustandFXService.convertInBearbeitungszustandFXList(emptyList);});
    }
}