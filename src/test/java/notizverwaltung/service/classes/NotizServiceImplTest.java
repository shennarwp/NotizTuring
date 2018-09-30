package notizverwaltung.service.classes;

import notizverwaltung.builders.ModelObjectBuilder;
import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.ObjectIstNullException;

import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.interfaces.NotizService;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Klasse zum Testen der NotizServerImpl Klasse
 * @author Tobias Gottschalk
 */
class NotizServiceImplTest {

    NotizService notizService = new NotizServiceImpl();



    /**
     * Testet die Methode auf ein Null Objekt
     * Methode: updateNotiz
     * Erwartet: ObjectIstNullException
     */
    @Test
    void updateNotiz() {
        Notiz notiz = null;
        assertThrows(ObjectIstNullException.class, () -> { notizService.updateNotiz(notiz);});
    }

    /**
     * Testet die Methode auf ein int, welches kleiner  ist als 1
     * Methode: deleteNotiz
     * Erwartet: IntIstNegativException
     */
    @Test
    void deleteNotiz() {
        assertThrows(IntIstNegativException.class, () -> { notizService.deleteNotiz(-1);});
    }

    /**
     * Testet die Methode auf eine Notiz, welche null ist
     * Methode: addNotiz
     * Erwartet: ObjectIstNullException
     */
    @Test
    void addNotizNotizIstNull() {
        int notizblockID = 1;
        Notiz notiz = null;
        assertThrows(ObjectIstNullException.class, () -> { notizService.addNotiz(notiz,notizblockID);});
    }

    /**
     * Testet die Methode auf ein int, welches kleiner  ist als 1
     * Methode: addNotiz
     * Erwartet: IntIstNegativException
     */
    @Test
    void addNotizNotizblockIDistNegativ() {
        int notizblockID = -1;
        Notiz notiz = ModelObjectBuilder.getNotizObject();
        int notizID;
        assertThrows(IntIstNegativException.class, () -> {notizService.addNotiz(notiz,notizblockID);});
    }



}