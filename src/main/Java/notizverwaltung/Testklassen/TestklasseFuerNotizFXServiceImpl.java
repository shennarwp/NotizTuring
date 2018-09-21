package notizverwaltung.Testklassen;

import notizverwaltung.builders.ModelObjectBuilder;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.model.interfaces.NotizFX;
import notizverwaltung.service.classes.NotizFXServiceImpl;

import java.util.Calendar;
import java.util.Date;

public class TestklasseFuerNotizFXServiceImpl {

    public static void main(String[] args){
        new TestklasseFuerNotizFXServiceImpl().testWrapNotizInNotizFX();
    }


    public void testWrapNotizInNotizFX(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date naechsteWoche = calendar.getTime();
        Notiz notiz2 = ModelObjectBuilder.getNotizObject();
        NotizFX notizFX;

        NotizFXServiceImpl notizFXService = new NotizFXServiceImpl();

        notiz2.setID(2);
        notiz2.setTitle("Übung 13");
        notiz2.setBeschreibung("Aufgaben 1 bis 4");
        notiz2.setKategorieID(2);
        notiz2.setBearbeitungszustandID(2);
        notiz2.setPrioritaet(true);
        notiz2.setFaelligkeit(naechsteWoche);
        notiz2.setErinnerung(naechsteWoche);




        notizFX = notizFXService.wrapNotiz(notiz2);
        System.out.println("Debug");
        System.out.println(notizFX.getErstellung());
        System.out.println(notizFX.getErstellung());
        System.out.println(notizFX);


    }
}
