package notizverwaltung.model.classes;

import javafx.beans.property.*;
import javafx.scene.paint.Color;
import notizverwaltung.model.interfaces.KategorieFX;
import notizverwaltung.validators.IntValidator;
import notizverwaltung.validators.ObjectValidator;
import notizverwaltung.validators.StringValidator;

public class KategorieFXImpl implements KategorieFX {

    private IntegerProperty kategorieID;
    private StringProperty kategorieName;
    private ObjectProperty farbe;

    public KategorieFXImpl(){
        kategorieID = new SimpleIntegerProperty();
        kategorieName = new SimpleStringProperty();
        farbe = new SimpleObjectProperty();
    }

    @Override
    public IntegerProperty getKategorieID() {
        return kategorieID;
    }

    @Override
    public void setKategorieID(int kategorieID) {
        IntValidator.checkObIntNullOderNegativIst(kategorieID);
        this.kategorieID.set(kategorieID);

    }

    @Override
    public StringProperty getKategorieName() {
        return kategorieName;
    }

    @Override
    public void setKategorieName(String name) {
        StringValidator.checkObStringLeerOderNullIst(name);
        this.kategorieName.set(name);
    }

    @Override
    public ObjectProperty getFarbe() {
        return farbe;
    }

    @Override
    public void setFarbe(Color farbe) {
        ObjectValidator.checkObObjectNullIst(farbe);
        this.farbe.set(farbe);
    }

    @Override
    public String toString(){return kategorieName.getValue();}
}
