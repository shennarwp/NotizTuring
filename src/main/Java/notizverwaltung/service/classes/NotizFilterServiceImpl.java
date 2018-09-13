package notizverwaltung.service.classes;

import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.interfaces.NotizFilterService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


/**
 *
 * Die Klasse stellt Filter fuer Notizen bereit
 *
 *
 * @author Tobias Gottschalk
 * @version 1.0
 * @since
 */
public class NotizFilterServiceImpl implements NotizFilterService {


    @Override
    public List<Notiz> filterAlleNotizenMitLambda(int notizblockID, int bearbeitungszustandID, Predicate<Notiz> notizPredicate) {
        return null;
    }

    @Override
    public List<Notiz> filterAlleNotizenMitPriorität(int notizblockID, int bearbeitungszustandID) {
        return null;
    }

    @Override
    public List<Notiz> filterAlleNotizenOhnePriorität(int notizblockID, int bearbeitungszustandID) {
        return null;
    }

    @Override
    public List<Notiz> filterAlleNotizenMiteinerBestimmtenKategorie(int notizblockID, int kategorieID) {
        return null;
    }
}
