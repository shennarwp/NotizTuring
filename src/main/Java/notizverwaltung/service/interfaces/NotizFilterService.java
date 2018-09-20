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

    List<Notiz> filterAlleNotizenMitLambda (int notizblockID, Predicate<Notiz> notizPredicate);

    List<Notiz> filterAlleNotizenMitPrioritaet(int notizblockID, int bearbeitungszustandID);
    List<Notiz> filterAlleNotizenOhnePrioritaet (int notizblockID,int bearbeitungszustandID);
    List<Notiz> filterAlleNotizenMiteinerBestimmtenKategorie(int notizblockID,int kategorieID);


}
