package notizverwaltung.service.interfaces;

import notizverwaltung.model.interfaces.Notiz;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 * Die Klasse stellt Funktionalitäten für Notizen bereit
 *
 *
 * @author Tobias Gottschalk
 * @version 1.0
 * @since
 */
public interface NotizFilterService {

    public List<Notiz> filterAlleNotizenMitLambda (Predicate<Notiz> notizPredicate, List<Notiz> listeVonNotiz);

    public List<Notiz> filterAlleNotizenMitPriorität(int notizblockID,int bearbeitungszustandsID);
    public List<Notiz> filterAlleNotizenOhnePriorität (int notizblockID, int bearbeitungszustandsID);
    public List<Notiz> filterAlleNotizenMitEinemBearbeitunszustand(int notizblockID,int bearbeitungszustandID);
}
