package notizverwaltung.service.interfaces;

import notizverwaltung.model.interfaces.Notiz;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 * Die Klasse stellt Funktionalitäten für den NotizFilter bereit
 *
 *
 * @author Kevin Engelhardt
 * @author Shenna RWP
 * @version 1.0
 */
public interface NotizFilterService {
    //Filtert eine Liste mittels Lambada-Ausdruecken
    List<Notiz> filterAlleNotizenMitLambda (int notizblockID, Predicate<Notiz> notizPredicate);
    //Filter, der alle Notizen eines bestimmten Bearbeitungszustands zurueck gibt.
    List<Notiz> filterAlleNotizenMitPrioritaet(int notizblockID, int bearbeitungszustandID);
    //Filter der alle Notizen ohne Priorität eines bestimmten Bearbeitungszustand zurueck gibt
    List<Notiz> filterAlleNotizenOhnePrioritaet (int notizblockID,int bearbeitungszustandID);
    //Filter der alle Notizen ohne Priorität eines bestimmten Bearbeitungszustand zurueck gibt
    List<Notiz> filterAlleNotizenMiteinerBestimmtenKategorie(int notizblockID,int kategorieID);


}
