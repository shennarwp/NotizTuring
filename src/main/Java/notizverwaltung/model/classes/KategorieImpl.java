package notizverwaltung.model.classes;

import javafx.scene.paint.Color;
import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.validators.IntValidator;
import notizverwaltung.validators.ObjectValidator;
import notizverwaltung.validators.StringValidator;

import javax.persistence.*;


/**
 * @author Shenna RWP
 * @author Michelle Blau
 */
@Entity
@Table(name = "Kategorie")
public class KategorieImpl implements Kategorie
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KategorieID", nullable = false, unique = true)
    private int kategorieID;

    @Column(name = "KategorieName")
    private String kategorieName;

    //Derzeit stimmt mit Attribut farbe irgendwas in der Datenbank nicht, deswegen auskommentiert. Bei Konstruktoraufruf von NotizImpl MIT farbe gibt die DB eine Exception
    //    @Column(name = "Farbe")
    //    private Color farbe;

    /**
     * Konstruktor
     * @param kategorieName
     * @throws StringIsEmptyException
     */
    public KategorieImpl(String kategorieName) throws StringIsEmptyException {
        StringValidator.checkObStringLeerOderNullIst(kategorieName);
        setKategorieName(kategorieName);
    }

//    public KategorieImpl(String kategorieName, Color farbe) throws StringIsEmptyException, ObjectIstNullException {
//        StringValidator.checkObStringLeerOderNullIst(kategorieName);
//        setKategorieName(kategorieName);
//
//        this.kategorieName = kategorieName;
//        this.farbe = farbe;
//        setFarbe(farbe);
//    }

    public KategorieImpl(){

    }

    /**
     * getter-Methode für ID der Kategorie
     * @return ID der Kategorie
     */

    @Override
    public int getKategorieID() {

        return this.kategorieID;
    }

    /**
     * setter-Methode für ID der Kategorie
     * @param kategorieID
     * @throws IntIstNegativException
     */
    @Override
    public void setKategorieID(int kategorieID) throws IntIstNegativException {
        IntValidator.checkObIntNullOderNegativIst(kategorieID);
        this.kategorieID = kategorieID;
    }

    /**
     * suche die Name einer Kategorie
     * @return die Name einer Kategorie
     */
    @Override
    public String getKategorieName() {
        return this.kategorieName;
    }

    /**
     * erstelle die Name der Kategorie
     * @param kategorieName
     * @throws StringIsEmptyException
     */

    @Override
    public void setKategorieName(String kategorieName) throws StringIsEmptyException {
        StringValidator.checkObStringLeerOderNullIst(kategorieName);
        this.kategorieName = kategorieName;
    }

    /**
     * getter-Methode für die Farbe der Kategorie
     * @return Dark Green- Farbe
     */
    @Override
    public Color getFarbe() {
//        return this.farbe;
        return Color.DARKGREEN;
    }

    /**
     * setter-Methode für Farbe der Kategorie
      * @param farbe
     * @throws ObjectIstNullException
     */
    @Override
    public void setFarbe(Color farbe) throws ObjectIstNullException {
//        ObjectValidator.checkObObjectNullIst(farbe);
//        this.farbe = farbe;
    }


    /**
     * Kategorien sind gleich, wenn sie die gleiche ID haben
     * Vergleicht 2 Kategorien
     * @param object zu vergleichende Kategorie
     * @return true, wenn Kategorien gleich, sonst false
     *
     * @author Michelle Blau
     */
    @Override
    public boolean equals(Object object){
        if (object instanceof KategorieImpl){
            KategorieImpl vergleichsKategorie = (KategorieImpl) object;

            if (this.kategorieID == vergleichsKategorie.getKategorieID()){
                return true;
            }
        }
        return false;
    }


    /**
     * toString-Methode
     * @return Name der Kategorie
     */
    @Override
    public String toString() {
        return getKategorieName();
    }
}
