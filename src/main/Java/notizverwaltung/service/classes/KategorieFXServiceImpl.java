package notizverwaltung.service.classes;

import javafx.scene.paint.Color;
import notizverwaltung.builders.ModelObjectBuilder;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.KategorieFX;
import notizverwaltung.service.interfaces.KategorieFXService;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse fuer KategorieFXServiceImpl. Die Klasse implementiert das Interface KategorieFXService
 * @author Kevin Engelhardt
 * @version 1.0
 */

public class KategorieFXServiceImpl implements KategorieFXService {
    @Override
    public KategorieFX wrapKategorie(Kategorie kategorie) {
        KategorieFX kategorieFX = ModelObjectBuilder.getKategorieFXObjekt();

        kategorieFX.setKategorieID(kategorie.getKategorieID());
        kategorieFX.setKategorieName(kategorie.getKategorieName());
        kategorieFX.setFarbe(kategorie.getFarbe());
        return kategorieFX;

    }

    @Override
    public Kategorie unwrapKategorieFX(KategorieFX kategorieFX) {
        Kategorie kategorie = ModelObjectBuilder.getKategorieObject();

        kategorie.setKategorieID(kategorieFX.getKategorieID().getValue());
        kategorie.setKategorieName(kategorieFX.getKategorieName().getValue());
        kategorie.setFarbe((Color) kategorieFX.getFarbe().getValue());
        return kategorie;
    }

    @Override
    public List<KategorieFX> convertInKategorieFXList(List<Kategorie> kategorieListe) {

        List<KategorieFX> kategorieFXListe = new ArrayList<>();

        for(Kategorie kategorie : kategorieListe)
        {
            KategorieFX kategorieFX = wrapKategorie(kategorie);
            kategorieFXListe.add(kategorieFX);
        }
        return kategorieFXListe;
    }
}
