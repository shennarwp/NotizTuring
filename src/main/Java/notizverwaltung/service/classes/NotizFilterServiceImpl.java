package notizverwaltung.service.classes;

import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.interfaces.NotizFilterService;
import notizverwaltung.validators.IntValidator;

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
        IntValidator.checkObIntNullOderNegativIst(notizblockID);
        IntValidator.checkObIntNullOderNegativIst(bearbeitungszustandID);



        return null;
    }

    @Override
    public List<Notiz> filterAlleNotizenOhnePriorität(int notizblockID, int bearbeitungszustandID) {
        IntValidator.checkObIntNullOderNegativIst(notizblockID);
        IntValidator.checkObIntNullOderNegativIst(bearbeitungszustandID);
        return null;
    }

    @Override
    public List<Notiz> filterAlleNotizenMiteinerBestimmtenKategorie(int notizblockID, int kategorieID) {
        IntValidator.checkObIntNullOderNegativIst(notizblockID);
        IntValidator.checkObIntNullOderNegativIst(kategorieID);
        return null;
    }
}
