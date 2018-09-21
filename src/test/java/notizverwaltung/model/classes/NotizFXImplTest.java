package notizverwaltung.model.classes;

import notizverwaltung.model.interfaces.NotizFX;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotizFXImplTest {

    /**
     * Testet, was bei Übergabe einer NotizFX mit gleicher ID passiert
     * Methode: equals()
     * ->Erwartet wird der Rückgabewert true
     */
    @Test
    void equalsNotizenSindGleich(){
        NotizFX notizFX1 = new NotizFXImpl();
        notizFX1.setNotizID(244);

        NotizFX notizFX2 = new NotizFXImpl();
        notizFX2.setNotizID(244);

        boolean ergebnis = notizFX1.equals(notizFX2);

        assertEquals(true, ergebnis);
    }

    /**
     * Testet, was bei Übergabe einer KategorieFX mit ungleicher ID passiert
     * Methode: equals()
     * ->Erwartet wird der Rückgabewert false
     */
    @Test
    void equalsNotizenSindUngleich(){
        NotizFX notizFX1 = new NotizFXImpl();
        notizFX1.setNotizID(244);

        NotizFX notizFX2 = new NotizFXImpl();
        notizFX2.setNotizID(249);

        boolean ergebnis = notizFX1.equals(notizFX2);

        assertEquals(false, ergebnis);
    }
}