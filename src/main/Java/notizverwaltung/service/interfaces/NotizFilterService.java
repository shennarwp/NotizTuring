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
 * @version 1.0
 * @since
 */
public interface NotizFilterService {

    public List<Notiz> filterAlleNotizenMitLambda (int notizblockID,int bearbeitungszustandID,Predicate<Notiz> notizPredicate);

    public List<Notiz> filterAlleNotizenMitPriorität(int notizblockID, int bearbeitungszustandID);
    public List<Notiz> filterAlleNotizenOhnePriorität (int notizblockID,int bearbeitungszustandID);
    public List<Notiz> filterAlleNotizenMiteinerBestimmtenKategorie(int notizblockID,int kategorieID);


}
