package notizverwaltung.validators;

import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.classes.NotizServiceImpl;
import notizverwaltung.service.interfaces.NotizService;

import java.util.List;

/**
 * Überprüft, ob noch Notizen in der Datenbank exisiteren, die einer bestimmten Kategorie oder
 * einem bestimmten Bearbeitungszustand zugeordnet sind
 *
 * @author Michelle Blau
 */
public class ListValidator {

    //TODO fertigschreiben, sobald getAlleNotizenvonEinerKategorie() implementiert ist
    public static boolean isNotizMitKategorieVorhanden(Kategorie kategorie) {
        NotizService notizService = new NotizServiceImpl();
        List<Notiz> notizenMitBestimmerKategorie = notizService.getAlleNotizenvonEinerKategorie(kategorie);

        return true;
    }


    /**
     * Prüft, ob es Notizen in der Datenbank gibt, die einen übergebenen Bearbeitungszustand nutzen
     *
     * @param bearbeitungszustand zu dem festgestellt werden soll, ob Notizen diesem zugeordnet sind
     * @return true, wenn es zugeordnete Notizen gibt, sonst false
     */
    public static boolean isNotizMitBearbeitungszustandVorhanden(Bearbeitungszustand bearbeitungszustand){
        NotizService notizService = new NotizServiceImpl();
        int bearbeitungszustandID = bearbeitungszustand.getBearbeitungsZustandID();
        List<Notiz> notizenMitBestimmtemBearbeitungszustand = notizService.getAlleNotizenVonEinemBearbeitungszustand(bearbeitungszustandID);

        if (notizenMitBestimmtemBearbeitungszustand.size() == 0){
            return false;
        }else{
            return true;
        }
    }

}
