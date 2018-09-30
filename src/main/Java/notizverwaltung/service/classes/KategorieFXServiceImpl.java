package notizverwaltung.service.classes;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;
import notizverwaltung.builders.DaoObjectBuilder;
import notizverwaltung.builders.ModelObjectBuilder;
import notizverwaltung.builders.ServiceObjectBuilder;
import notizverwaltung.dao.interfaces.KategorieDAO;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.KategorieFX;
import notizverwaltung.service.interfaces.KategorieFXService;
import notizverwaltung.validators.IntValidator;
import notizverwaltung.validators.ObjectValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse fuer KategorieFXServiceImpl. Die Klasse implementiert das Interface KategorieFXService
 * @author Kevin Engelhardt
 * @version 1.0
 */

public class KategorieFXServiceImpl implements KategorieFXService {

    /**
     * Methode wandelt Kategorie in KategorieFX um
     * @param kategorie
     * @return KategorieFX
     */
    @Override
    public KategorieFX wrapKategorie(Kategorie kategorie) {
        ObjectValidator.checkObObjectNullIst(kategorie);
        KategorieFX kategorieFX = ModelObjectBuilder.getKategorieFXObjekt();

        kategorieFX.setKategorieID(kategorie.getKategorieID());
        kategorieFX.setKategorieName(kategorie.getKategorieName());
        kategorieFX.setFarbe(kategorie.getFarbe());
        return kategorieFX;

    }

    /**
     * Methode wandelt KategorieFX in Kategorie um
     * @param kategorieFX
     * @return Kategorie
     */

    @Override
    public Kategorie unwrapKategorieFX(KategorieFX kategorieFX) {
        ObjectValidator.checkObObjectNullIst(kategorieFX);
        Kategorie kategorie = ModelObjectBuilder.getKategorieObject();

        kategorie.setKategorieID(kategorieFX.getKategorieID().getValue());
        kategorie.setKategorieName(kategorieFX.getKategorieName().getValue());
        kategorie.setFarbe((Color) kategorieFX.getFarbe().getValue());
        return kategorie;
    }

    /**
     * Methode wandelt KategorieListe in KategorieFX Liste um
     * @param kategorieListe
     * @return List<KategorieFX>
     */

    @Override
    public List<KategorieFX> convertInKategorieFXList(List<Kategorie> kategorieListe) {
        ObjectValidator.checkObObjectNullIst(kategorieListe);
        List<KategorieFX> kategorieFXListe = new ArrayList<>();

        for(Kategorie kategorie : kategorieListe)
        {
            KategorieFX kategorieFX = wrapKategorie(kategorie);
            kategorieFXListe.add(kategorieFX);
        }
        return kategorieFXListe;
    }

    /**
     * Die Methode liefert zu einer KategorieID eine Stringproperty mit dem Name der
     * Kategorie zurueck
     * @param kategorieID Integer, darf nicht nicht kleiner als 1 sein
     * @return Liefert ein StringProperty mit dem Kategorie Name zurueck
     */
    @Override
    public StringProperty getKategorieNamePropertyVonKategorieID(int kategorieID) {
        IntValidator.checkObIntNullOderNegativIst(kategorieID);

        KategorieDAO kategorieDAO = DaoObjectBuilder.getKategorieDaoObject();
        StringProperty kategorieIDProperty = new SimpleStringProperty();

        kategorieIDProperty.set(kategorieDAO.getKategorieNameVonKategorieID(kategorieID));

        return kategorieIDProperty;


    }
}
