package notizverwaltung.service.interfaces;

import notizverwaltung.model.interfaces.Notiz;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 * Die Klasse stellt Funktionalitäten für den Notizblock bereit
 *
 *
 * @author Kevin Engelhardt
 * @author Shenna RWP
 * @version 1.0
 */
public interface NotizFilterService {

    //Die Methode bietet die Moeglichkeit mit Lambda-Ausdruecken eine Liste zu filtern
    List<Notiz> filterAlleNotizenMitLambda (int notizblockID, Predicate<Notiz> notizPredicate);

    //Vordefinierter Filter, der alle Notizen mit Priorität eines bestimmten Bearbeitungszustand zurueck gibt
    List<Notiz> filterAlleNotizenMitPrioritaet(int notizblockID, int bearbeitungszustandID);

    //Vordefinierter Filter der alle Notizen ohne Priorität eines bestimmten Bearbeitungszustand zurueck gibt
    List<Notiz> filterAlleNotizenOhnePrioritaet (int notizblockID,int bearbeitungszustandID);

    //Vordefinierter Filter der alle Notizen einer bestimmten Kategorie liefert
    List<Notiz> filterAlleNotizenMiteinerBestimmtenKategorie(int notizblockID,int kategorieID);


}
