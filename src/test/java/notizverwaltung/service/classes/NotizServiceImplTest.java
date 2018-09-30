package notizverwaltung.service.classes;

import notizverwaltung.builders.ModelObjectBuilder;
import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.interfaces.NotizService;
import notizverwaltung.validators.IntValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NotizServiceImplTest {

    NotizService notizService = new NotizServiceImpl();

    @Test
    void updateNotiz() {
        Notiz notiz = null;
        assertThrows(IntIstNegativException.class, () -> { notizService.updateNotiz(notiz);});
    }

    @Test
    void deleteNotiz() {
        assertThrows(IntIstNegativException.class, () -> { notizService.deleteNotiz(-1);});
    }

    @Test
    void addNotizNotizIstNull() {
        int notizblockID = 1;
        Notiz notiz = null;
        assertThrows(ObjectIstNullException.class, () -> { notizService.addNotiz(notiz,notizblockID);});
    }


    @Test
    void addNotizNotizblockIDistNegativ() {
        int notizblockID = -1;
        Notiz notiz = ModelObjectBuilder.getNotizObject();
        int notizID;
        assertThrows(IntIstNegativException.class, () -> {notizService.addNotiz(notiz,notizblockID);});
    }


}