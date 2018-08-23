package model.classes;

import javafx.scene.paint.Color;
import model.interfaces.KategorieInterface;

public class Kategorie implements KategorieInterface {

    private int kategorieID;
    private String kategorieName;
    private Color farbe;



    @Override
    public Color getFarbe() {
        return this.farbe;
    }


    @Override
    public int getKategorieID() {
        return this.kategorieID;
    }


    @Override
    public String getKategorieName() {
        return this.kategorieName;
    }


    @Override
    public void setKategorieID(int kategorieID) {
        this.kategorieID = kategorieID;
    }


    @Override
    public void setKategorieName(String kategorieName) {
        this.kategorieName = kategorieName;
    }


    @Override
    public void setFarbe(Color farbe) {
        this.farbe = farbe;
    }


    @Override
    public String toString() {
        return "Kategorie{" +
                "kategorieID=" + kategorieID +
                ", kategorieName='" + kategorieName + '\'' +
                ", farbe=" + farbe +
                '}';
    }
}
