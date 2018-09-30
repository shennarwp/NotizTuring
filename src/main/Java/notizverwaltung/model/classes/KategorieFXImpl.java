package notizverwaltung.model.classes;

import javafx.beans.property.*;
import javafx.scene.paint.Color;
import notizverwaltung.model.interfaces.KategorieFX;
import notizverwaltung.validators.IntValidator;
import notizverwaltung.validators.ObjectValidator;
import notizverwaltung.validators.StringValidator;

/**
 * Klasse fuer KategorieFX. Die Klasse implementiert das KategorieFX Interface.
 *
 * @author Kevin Engelhardt
 * @author Michelle Blau
 *
 * @version 1.0
 */

public class KategorieFXImpl implements KategorieFX {

    private IntegerProperty kategorieID;
    private StringProperty kategorieName;
    private ObjectProperty farbe;

    public KategorieFXImpl(){
        kategorieID = new SimpleIntegerProperty();
        kategorieName = new SimpleStringProperty();
        farbe = new SimpleObjectProperty();
    }

    /**
     *getter-Methode für ID der Kategorie
     * @return gibt KategorieID als IntegerProperty  zurueck.
     */
    @Override
    public IntegerProperty getKategorieID() {
        return kategorieID;
    }

    /**
     *setter-Methode für ID der Kategorie
     * @param kategorieID als int, int darf nicht kleiner 0 sein.
     */

    @Override
    public void setKategorieID(int kategorieID) {
        IntValidator.checkObIntNullOderNegativIst(kategorieID);
        this.kategorieID.set(kategorieID);

    }

    /**
     *suche bestimmte Name einer Kategorie
     * @return Gibt KategorieName als StringProperty zurueck.
     */
    @Override
    public StringProperty getKategorieName() {
        return kategorieName;
    }

    /**
     *erstelle die Name einer Kategorie
     * @param name als String, String darf nicht leer sein.
     */

    @Override
    public void setKategorieName(String name) {
        StringValidator.checkObStringLeerOderNullIst(name);
        this.kategorieName.set(name);
    }

    /**
     *getter-Methode für Farbe einer Kategorie
     * @return Gibt Farbe als ObjectProperty zurueck.
     */
    @Override
    public ObjectProperty getFarbe() {
        return farbe;
    }

    /**
     *setter--Methode für Farbe einer Kategorie
     * @param farbe als Color Object, darf nicht null sein.
     */
    @Override
    public void setFarbe(Color farbe) {
        ObjectValidator.checkObObjectNullIst(farbe);
        this.farbe.set(farbe);
    }

    /**
     * KategorieFX sind gleich, wenn sie die gleiche ID haben
     * @param object zu vergleichende KategorieFX
     * @return true, wenn KategorieFX gleich, sonst false
     *
     * @author Michelle Blau
     */
    @Override
    public boolean equals(Object object){
        if (object instanceof KategorieFX){
            KategorieFX vergleichsKategorieFX = (KategorieFXImpl) object;
            int vergleichdsID = vergleichsKategorieFX.getKategorieID().getValue();
            int eigeneID = this.kategorieID.getValue();

            if (eigeneID == vergleichdsID){
                return true;
            }
        }
        return false;
    }

    /**
     * toString-Methode
     * @return KategorieName
     */
    @Override
    public String toString(){return kategorieName.getValue();}
}
