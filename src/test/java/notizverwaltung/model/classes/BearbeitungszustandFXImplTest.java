package notizverwaltung.model.classes;

import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.StringIsEmptyException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testklasse fuer die Klasse BearbeitungszustandFXImpl
 *
 * @author Kevin Engelhardt
 *
 * @version 1.0
 */

import static org.junit.jupiter.api.Assertions.*;

class BearbeitungszustandFXImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setBearbeitungsZustandID() {
        int testInt = -1;
        BearbeitungszustandFXImpl bearbeitungszustandFXImpl = new BearbeitungszustandFXImpl();
        assertThrows(IntIstNegativException.class, () -> {bearbeitungszustandFXImpl.setBearbeitungsZustandID(testInt); });
    }


    @Test
    void setName() {
        String leerstring = " ";
        BearbeitungszustandFXImpl bearbeitungszustandFXImpl = new BearbeitungszustandFXImpl();
        assertThrows(StringIsEmptyException.class, () -> {bearbeitungszustandFXImpl.setName(leerstring);});
    }

    @Test
    void setPosition() {
        int testInt = -1;
        BearbeitungszustandFXImpl bearbeitungszustandFXImpl = new BearbeitungszustandFXImpl();
        assertThrows(IntIstNegativException.class, () -> {bearbeitungszustandFXImpl.setPosition(testInt); });
    }
}