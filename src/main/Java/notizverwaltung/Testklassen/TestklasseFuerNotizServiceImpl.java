package notizverwaltung.Testklassen;

import notizverwaltung.builders.ServiceObjectBuilder;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.interfaces.NotizService;

import java.util.List;

public class TestklasseFuerNotizServiceImpl {
    public static void main(String[] args) {

        TestklasseFuerNotizServiceImpl test = new TestklasseFuerNotizServiceImpl();

        test.testGetAlleNotizen();

    }

    private void testGetAlleNotizen(){
        NotizService notizService = ServiceObjectBuilder.getNotizService();

        List<Notiz> list = notizService.getAlleNotizen();
        System.out.println("test");
    }

}
