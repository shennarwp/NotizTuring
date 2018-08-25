package notizverwaltung.model.classes;

import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.validators.StringValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotizImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void setBeschreibungStringIstNull() {
        String test = null;


        assertThrows(StringIsEmptyException.class, () -> { StringValidator.checkObStringLeerIst(test);});

    }

    @Test
    void setBeschreibungStringIstEmpty() {
        String test = " ";
        assertThrows(StringIsEmptyException.class, () -> { StringValidator.checkObStringLeerIst(test);});

    }

    @Test
    void setPrioritaet() {
    }

    @Test
    void setBearbeitungszustand() {
    }

    @Test
    void getBearbeitungszustand() {
    }
}