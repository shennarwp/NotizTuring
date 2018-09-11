package notizverwaltung.Testklassen;

import notizverwaltung.builders.ModelObjectBuilder;
import notizverwaltung.constants.DAOKonstanten;
import notizverwaltung.model.classes.BearbeitungszustandImpl;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.model.interfaces.Notizblock;
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
import java.util.List;

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

        //Legt Notiz an mit bz1 und kat1 als Bearbeitungszustand bzw. Kategorie, fügt diese anschließend in die Datenbank ein
        Notiz notiz1 = ModelObjectBuilder.getNotizObject();
        notiz1.setTitle("Programm schreiben");
        notiz1.setBeschreibung("Lagerklasse schreiben mit JUnit-Tests");
        notiz1.setKategorieID(kat1.getKategorieID());
        notiz1.setBearbeitungszustandID(bz1.getBearbeitungsZustandID());
        notiz1.setPrioritaet(true);
        notiz1.setFaelligkeit(naechsteWoche);
        notizService.addNotiz(notiz1,1);

        //TODO: Hier wird eine Exception geworfen, bitte Fehler beheben
        notizService.deleteNotiz(notiz1.getNotizID());

        //Lade die Objekte aus der Datenbank
        List<Notiz> notizListe = notizService.getAlleNotizenVomNotizblock(1);
        List<Kategorie> kategorieListe = notizblockService.getAlleKategorienVomNotizblock(1);
        List<Bearbeitungszustand> bearbeitungszustandListe = notizblockService.getAlleBearbeitungszustaendeVomNotizblock(1);

        //Gebe den Inhalt der Listen aus
            System.out.println("\n\n\n\n"+notizListe);
            System.out.println("\n\n\n\n"+kategorieListe);
            System.out.println("\n\n\n\n"+bearbeitungszustandListe);

        //TODO: deleteBearbeitungszustand, deleteKategorie implementieren!
        bearbeitungszustandService.deleteBearbeitungszustand(bz1.getBearbeitungsZustandID());
        kategorieService.deleteKategorie(kat1.getKategorieID());

    }


}
