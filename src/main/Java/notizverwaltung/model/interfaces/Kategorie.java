package notizverwaltung.model.interfaces;

import javafx.scene.paint.Color;
import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.exceptions.StringIsEmptyException;

/**
 *  Das Interface stellt die Methoden für die Modelklasse
 *
 * @author Tobias Gottschalk
 * @author Shenna RWP
 *
 * @version 1.0
 */


public interface Kategorie
{

    public int getKategorieID();
    public void setKategorieID(int kategorieID) throws IntIstNegativException;

    public String getKategorieName();
    public void setKategorieName(String name) throws StringIsEmptyException;

    public Color getFarbe();
    public void setFarbe(Color farbe) throws ObjectIstNullException;


    public String toString();
}