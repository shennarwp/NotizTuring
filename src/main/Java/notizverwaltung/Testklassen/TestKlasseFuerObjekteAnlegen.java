package notizverwaltung.Testklassen;

import notizverwaltung.builders.ModelObjectBuilder;
import notizverwaltung.constants.DAOKonstanten;
import notizverwaltung.model.classes.BearbeitungszustandImpl;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.classes.BearbeitungszustandServiceImpl;
import notizverwaltung.service.classes.KategorieServiceImpl;
import notizverwaltung.service.classes.NotizServiceImpl;
import notizverwaltung.service.classes.NotizblockServiceImpl;
import notizverwaltung.service.interfaces.BearbeitungszustandService;
import notizverwaltung.service.interfaces.KategorieService;
import notizverwaltung.service.interfaces.NotizService;
import notizverwaltung.service.interfaces.NotizblockService;

import java.util.Calendar;
import java.util.Date;

/**
 * Diese Klasse testet, ob Kategorie/Notiz/Bearbeitungszustand-Objekte richtig angelegt werden können, und ob sie
 * dauerhaft in der Datenbank gespeichert werden können sowie daraus gelöscht werden können.
 *
 * @author Michelle Blau
 */
public class TestKlasseFuerObjekteAnlegen {



    public static void main (String[] args){

        //Initialisiere Service-Schnittstellen
        NotizService notizService = new NotizServiceImpl();
        KategorieService kategorieService = new KategorieServiceImpl();
        BearbeitungszustandService bearbeitungszustandService = new BearbeitungszustandServiceImpl();
        NotizblockService notizblockService = new NotizblockServiceImpl();


        //Dient nur der Erstellung des Faelligkeitsdatums, "naechsteWoche"
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date naechsteWoche = calendar.getTime();

        //Legt Bearbeitungszustand und Kategorie an, fügt diese anschließend in die Datenbank ein...
        Bearbeitungszustand bz1 = new BearbeitungszustandImpl("To-Do");
        bearbeitungszustandService.addBearbeitungszustand(bz1);
        Kategorie kat1 = ModelObjectBuilder.getKategorieObjekt("Prog 3");
        kategorieService.addKategorie(kat1);

        //Legt Notiz an mit bz1 und kat1 als Bearbeitungszustand bzw. Kategorie
        Notiz notiz1 = ModelObjectBuilder.getNotizObject();
        notiz1.setTitle("Programm schreiben");
        notiz1.setBeschreibung("Lagerklasse schreiben mit JUnit-Tests");
        notiz1.setKategorieID(kat1.getKategorieID());
        notiz1.setBearbeitungszustandID(bz1.getBearbeitungsZustandID());
        notiz1.setPrioritaet(true);
        notiz1.setFaelligkeit(naechsteWoche);



        //TODO folgende Aufrufe führen zu Exceptions, bitte fixen
            System.out.println(notizService.getAlleNotizenVomNotizblock(1));
            System.out.println(notizblockService.getAlleKategorienVomNotizblock(1));
            System.out.println(notizblockService.getAlleBearbeitungszustaendeVomNotizblock(1));

        //lösche bz1 und kat1 aus Datenbank - sind diese Methoden überhaupt schon implementiert?
        bearbeitungszustandService.deleteBearbeitungszustand(bz1.getBearbeitungsZustandID());
        kategorieService.deleteKategorie(kat1.getKategorieID());

    }


}
