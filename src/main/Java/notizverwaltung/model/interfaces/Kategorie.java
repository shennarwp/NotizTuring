package notizverwaltung.model.interfaces;

import javafx.scene.paint.Color;
import notizverwaltung.exceptions.StringIsEmptyException;

public interface Kategorie
{

    public int getKategorieID();
    public void setKategorieID(int kategorieID);

    public String getKategorieName();
    public void setKategorieName(String name) throws StringIsEmptyException;

    public Color getFarbe();
    public void setFarbe(Color farbe);


    public String toString();
}