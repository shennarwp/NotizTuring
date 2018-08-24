package notizverwaltung.model.interfaces;

import javafx.scene.paint.Color;

public interface Kategorie {

    public void setKategorieID(int kategorieID);
    public void setKategorieName(String name);
    public void setFarbe(Color farbe);

    public int getKategorieID();
    public String getKategorieName();
    public Color getFarbe();
    public String toString();
}