package notizverwaltung.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import notizverwaltung.model.classes.BearbeitungszustandFXImpl;
import notizverwaltung.model.classes.KategorieFXImpl;
import notizverwaltung.model.interfaces.BearbeitungszustandFX;
import notizverwaltung.model.interfaces.KategorieFX;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testet Methoden er Klasse FXUtil
 *
 * @author Michelle Blau
 * @version 30.09.2018
 */

class FXUtilTest {

    private String zustandName;
    private String zustandNameGroßGeschrieben;
    private String zustandNameFalsch;
    private ObservableList<BearbeitungszustandFX> zustandListe;

    private String kategorieName;
    private String kategorieNameGroßGeschrieben;
    private String kategorieNameFalsch;
    private ObservableList<KategorieFX> kategorieListe;


    @BeforeEach
    void setUp()  {
        initializeZustaende();
        initializeKategorien();
    }


    /**
     * Testet, was bei Übergabe eines bestehenden Namens passiert
     * Methode: isZustandNameInListe()
     * ->Erwartet wird der Rückgabewert true
     */
    @Test
    void isZustandNameInListeNameVorhanden() {
       boolean ergebnis = FXUtil.isZustandNameInListe(zustandName, zustandListe);

       assertEquals(true, ergebnis);
    }


    /**
     * Testet, was bei Übergabe eines nicht vorhandenen Namens passiert
     * Methode: isZustandNameInListe()
     * ->Erwartet wird der Rückgabewert false
     */
    @Test
    void isZustandNameInListeNameNichtVorhanden() {
        boolean ergebnis = FXUtil.isZustandNameInListe(zustandNameFalsch, zustandListe);

        assertEquals(false, ergebnis);
    }


    /**
     * Testet, was bei Übergabe eines großgeschriebenen Namens passiert
     * Methode: isZustandNameInListe()
     * ->Erwartet wird der Rückgabewert true
     */
    @Test
    void isZustandNameInListeNameGroßGeschrieben() {
        boolean ergebnis = FXUtil.isZustandNameInListe(zustandNameGroßGeschrieben, zustandListe);

        assertEquals(true, ergebnis);
    }


    /**
     * Testet, was Übergabe eines bestehenden Kategorienamens passiert
     * Methode: isKategorieNameInListe()
     * ->Erwartet wird der Rückgabewert true
     */
    @Test
    void isKategorieNameInListeNameVorhanden() {
        boolean ergebnis = FXUtil.isKategorieNameInListe(kategorieName, kategorieListe);

        assertEquals(true, ergebnis);
    }


    /**
     * Testet, was bei Übergabe eines nicht vorhandenen Kategorienamens passiert
     * Methode: isKategorieNameInListe()
     * ->Erwartet wird der Rückgabewert false
     */
    @Test
    void isKategorieNameInListeNameNichtVorhanden() {
        boolean ergebnis = FXUtil.isKategorieNameInListe(kategorieNameFalsch, kategorieListe);

        assertEquals(false, ergebnis);
    }


    /**
     * Testet, was bei Übergabe eines großgeschriebenen Kategorienamens passiert
     * Methode: isKategorieNameInListe()
     * ->Erwartet wird der Rückgabewert true
     */
    @Test
    void isKategorieNameInListeNameGroßGeschrieben() {
        boolean ergebnis = FXUtil.isKategorieNameInListe(kategorieNameGroßGeschrieben, kategorieListe);

        assertEquals(true, ergebnis);
    }





    /**
     * Initialisiert Testdaten, die sich auf BearbeitungszustandFX-Objekte beziehen
     */
    private void initializeZustaende(){
        zustandName = "To Do";
        zustandNameGroßGeschrieben = "TO DO";
        zustandNameFalsch = "Sneep Snop";

        zustandListe = FXCollections.observableArrayList();

        BearbeitungszustandFX zustand1 = new BearbeitungszustandFXImpl();
        zustand1.setName("erledigt");
        BearbeitungszustandFX zustand2 = new BearbeitungszustandFXImpl();
        zustand2.setName("To Do");
        BearbeitungszustandFX zustand3 = new BearbeitungszustandFXImpl();
        zustand3.setName("offen");

        zustandListe.add(zustand1);
        zustandListe.add(zustand2);
        zustandListe.add(zustand3);
    }


    /**
     * Initialisiert Testdaten, die sich auf KategorieFX-Objekte beziehen
     */
    private void initializeKategorien(){
        kategorieName = "Prog3";
        kategorieNameGroßGeschrieben = "PROG3";
        kategorieNameFalsch = "Sneep Snop";

        kategorieListe = FXCollections.observableArrayList();

        KategorieFX kategorieFX1 = new KategorieFXImpl();
        kategorieFX1.setKategorieName("Mathe");
        KategorieFX kategorieFX2 = new KategorieFXImpl();
        kategorieFX2.setKategorieName("Prog3");
        KategorieFX kategorieFX3 = new KategorieFXImpl();
        kategorieFX3.setKategorieName("Physik");

        kategorieListe.add(kategorieFX1);
        kategorieListe.add(kategorieFX2);
        kategorieListe.add(kategorieFX3);
    }
}