package notizverwaltung.validators;

import notizverwaltung.builders.ServiceObjectBuilder;
import notizverwaltung.constants.DAOKonstanten;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.classes.NotizServiceImpl;
import notizverwaltung.service.interfaces.BearbeitungszustandService;
import notizverwaltung.service.interfaces.KategorieService;
import notizverwaltung.service.interfaces.NotizService;

import java.util.List;

/**
 * Stellt Methoden zum Ueberprüfen von Datenbankinhalten zur Verfuegung.
 * Diese Methoden werden für die GUI verwendet.
 *
 * @author Michelle Blau
 * @version 24.09.2018
 */
public class DaoContentValidator {


    /**
     * Prueft, ob es Notizen in der Datenbank gibt, die eine uebergebene Kategorie nutzen
     *
     * @param kategorie zu der festgestellt werden soll, ob Notizen dieser zugeordnet sind
     * @return true, wenn es zugeordnete Notizen gibt, sonst false
     */
    public static boolean isNotizMitKategorieVorhanden(Kategorie kategorie) {
        KategorieService kategorieService = ServiceObjectBuilder.getKategorieService();
        int id = kategorie.getKategorieID();
        long anzahlNotizen = kategorieService.getAnzahlNotizenInKategorie(id);

        if (anzahlNotizen == 0){
            return false;
        }else{
            return true;
        }
    }


    /**
     * Prueft, ob es Notizen in der Datenbank gibt, die einen uebergebenen Bearbeitungszustand nutzen
     *
     * @param bearbeitungszustand zu dem festgestellt werden soll, ob Notizen diesem zugeordnet sind
     * @return true, wenn es zugeordnete Notizen gibt, sonst false
     */
    public static boolean isNotizMitBearbeitungszustandVorhanden(Bearbeitungszustand bearbeitungszustand){
        BearbeitungszustandService bearbeitungszustandService = ServiceObjectBuilder.getBearbeitungszustandService();
        int id = bearbeitungszustand.getBearbeitungsZustandID();
        long anzahlNotizen = bearbeitungszustandService.getAnzahlNotizenInBearbeitungszustand(id);

        if (anzahlNotizen == 0){
            return false;
        }else{
            return true;
        }
    }


    /**
     * Ueberprueft, ob die max. moegliche Anzahl an Kategorien in der DB erreicht wurde
     *
     * @return true, wenn max. Anzahl erreicht, sonst false
     */
    public static boolean isMaximumKategorienErreicht(){
        KategorieService kategorieService = ServiceObjectBuilder.getKategorieService();
        long anzahlKategorienInDB = kategorieService.getAlleKategorien().size();

        if (anzahlKategorienInDB >= DAOKonstanten.MAX_ANZAHL_KATEGORIEN){
            return true;
        }else{
            return false;
        }
    }


    /**
     * Ueberprüft, ob die max. moegliche Anzahl an Bearbeitungszustaenden in der DB erreicht wurde
     *
     * @return true, wenn max. Anzahl erreicht, sonst false
     */
    public static boolean isMaximumZustaendeErreicht(){
        BearbeitungszustandService bearbeitungszustandService = ServiceObjectBuilder.getBearbeitungszustandService();
        long anzahlZustaendeInDB = bearbeitungszustandService.getAllBearbeitungszustand().size();

        if (anzahlZustaendeInDB >= DAOKonstanten.MAX_ANZAHL_ZUSTAENDE){
            return true;
        }else{
            return false;
        }
    }


    /**
     * Ueberprüft, ob die max. moegliche Anzahl Notizen in der DB erreicht wurde
     *
     * @return true, wenn max. Anzahl erreicht, sonst false
     */
    public static boolean isMaximumNotizenErreicht(){
        NotizService notizService = ServiceObjectBuilder.getNotizService();
        List<Notiz> notizListe = notizService.getAlleNotizenVomNotizblock(DAOKonstanten.STANDARD_NOTIZBLOCK_ID);
        long anzahlNotizenInDB = notizListe.size();

        if (anzahlNotizenInDB >= DAOKonstanten.MAX_ANZAHL_NOTIZEN){
            return true;
        }else{
            return false;
        }
    }
}
