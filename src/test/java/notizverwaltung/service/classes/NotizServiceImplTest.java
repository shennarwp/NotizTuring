package notizverwaltung.service.classes;

import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.service.interfaces.NotizService;
import notizverwaltung.validators.IntValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotizServiceImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addNotiz() {
    }

    @Test
    void updateNotiz() {
    }

    @Test
    void deleteNotiz() {
        NotizService notizService = new NotizServiceImpl();
        assertThrows(IntIstNegativException.class, () -> { notizService.deleteNotiz(-1);});
    }
}