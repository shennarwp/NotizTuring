package notizverwaltung.Testklassen;

import javafx.beans.property.StringProperty;
import notizverwaltung.service.classes.KategorieFXServiceImpl;
import notizverwaltung.service.classes.KategorieServiceImpl;

public class TestklasseFuerKategorieFXServiceImpl {

    public static void main (String[] args){
        TestklasseFuerKategorieFXServiceImpl testKlasse = new TestklasseFuerKategorieFXServiceImpl();
        testKlasse.testgetKategorieNamePropertyVonKategorieID();
    }

    private void testgetKategorieNamePropertyVonKategorieID(){
        KategorieFXServiceImpl kategorieFXService= new KategorieFXServiceImpl();

        StringProperty stringProperty = kategorieFXService.getKategorieNamePropertyVonKategorieID(5);
        stringProperty.getValue();

        System.out.println(stringProperty.getValue());
    }
}
