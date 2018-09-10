package notizverwaltung.Testklassen;

import notizverwaltung.builders.DaoObjectBuilder;
import notizverwaltung.builders.ServiceObjectBuilder;
import notizverwaltung.dao.interfaces.KategorieDAO;
import notizverwaltung.model.classes.KategorieImpl;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.service.interfaces.KategorieService;

import java.util.List;

public class TestklasseFuerKategorieDAOImpl {
    KategorieDAO kategorieDAO = DaoObjectBuilder.getKategorieDaoObject();

    public static void main(String [] args){
        TestklasseFuerKategorieDAOImpl test = new TestklasseFuerKategorieDAOImpl();
        test.kategorieHinzufuegen();
        test.testGetAlleKategorien();

    }


    private void kategorieHinzufuegen(){
        KategorieDAO kategorieDAO = DaoObjectBuilder.getKategorieDaoObject();

        Kategorie kat1 = new KategorieImpl("Prog 3");
        Kategorie kat2 = new KategorieImpl("Mathe");
        Kategorie kat3 = new KategorieImpl("Englisch");

        kategorieDAO.addKategorie(kat1);
        kategorieDAO.addKategorie(kat2);
        kategorieDAO.addKategorie(kat3);

    }

    private void testGetAlleKategorien(){
        KategorieService kategorieService = ServiceObjectBuilder.getKategorieService();

        List<Kategorie> liste =kategorieService.getAlleKategorien();
        System.out.println("test");

    }
}
