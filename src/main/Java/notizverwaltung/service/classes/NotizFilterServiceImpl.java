package notizverwaltung.service.classes;

import notizverwaltung.builders.DaoObjectBuilder;
import notizverwaltung.dao.interfaces.NotizDAO;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.interfaces.NotizFilterService;
import notizverwaltung.validators.IntValidator;
import notizverwaltung.validators.ObjectValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


/**
 *
 * Die Klasse stellt verschiedene Listen bereit, welche nach verschiedenen Kriterien gefiltert sind.
 *
 *
 *
 * @author Tobias Gottschalk
 * @author Shenna RWP
 * @version 1.0
 * @since
 */
public class NotizFilterServiceImpl implements NotizFilterService {

    private NotizDAO notizDAO;


    /**
     * Konstruktor fuer Filterklasse
     * @param notizDAO
     */
    public NotizFilterServiceImpl(NotizDAO notizDAO){
        ObjectValidator.checkObObjectNullIst(notizDAO);
        this.notizDAO = notizDAO;

    }

    public NotizFilterServiceImpl(){
        this(DaoObjectBuilder.getNotizDaoObject());
    }

    /**
     * Die Methode bittet die Moeglichkeit mit Lambda-Ausdruecken eine Liste zu filtern
     * @param notizblockID Integer, darf nicht kleiner als 1 sein
     * @param notizPredicate Predicate Lampda Ausdruck
     * @return
     */
    @Override
    public List<Notiz> filterAlleNotizenMitLambda(int notizblockID, Predicate<Notiz> notizPredicate) {
        List<Notiz> listeMitGefiltertenNotizen = new ArrayList<>();
        List<Notiz> listMitAllenNotizen = notizDAO.getAlleNotizenVomNotizblock(notizblockID);

        for(Notiz notiz : listMitAllenNotizen){
            if(notizPredicate.test(notiz)){
                listeMitGefiltertenNotizen.add(notiz);
            }
        }
        return listeMitGefiltertenNotizen;
    }

    /**
     * Vordefinierter Filter, der alle Notizen mit Priorität eines bestimmten Bearbeitungszustand zurueck gibt
     * @param notizblockID Integer, darf nicht kleiner als 1 sein
     * @param bearbeitungszustandID Integer, darf nicht kleiner als 1 sein
     * @return Liefert eine gefilterte Liste zurueck
     */
    @Override
    public List<Notiz> filterAlleNotizenMitPriorität(int notizblockID, int bearbeitungszustandID) {
        IntValidator.checkObIntNullOderNegativIst(notizblockID);
        IntValidator.checkObIntNullOderNegativIst(bearbeitungszustandID);
        Predicate<Notiz> mitPriotitaetPredicate = notiz -> notiz.getPrioritaet() == true &&
                                                           notiz.getBearbeitungszustandID() == bearbeitungszustandID;
        return filterAlleNotizenMitLambda(notizblockID, mitPriotitaetPredicate);
    }

    /**
     * Vordefinierter Filter der alle Notizen ohne Priorität eines bestimmten Bearbeitungszustand zurueck gibt
     * @param notizblockID Integer, darf nicht kleiner als 1 sein
     * @param bearbeitungszustandID Integer, darf nicht kleiner als 1 sein
     * @return Liefert eine gefilterte Liste zurueck
     */
    @Override
    public List<Notiz> filterAlleNotizenOhnePriorität(int notizblockID, int bearbeitungszustandID) {
        IntValidator.checkObIntNullOderNegativIst(notizblockID);
        IntValidator.checkObIntNullOderNegativIst(bearbeitungszustandID);
        Predicate<Notiz> ohnePriotitaetPredicate = notiz -> notiz.getPrioritaet() == false &&
                                                            notiz.getBearbeitungszustandID() == bearbeitungszustandID;
        return filterAlleNotizenMitLambda(notizblockID, ohnePriotitaetPredicate);
    }

    /**
     * Vordefinierter Filter der alle Notizen einer bestimmten Kategorie liefert
     * @param notizblockID Integer, darf nicht kleiner als 1 sein
     * @param kategorieID Integer, darf nicht kleiner als 1 sein
     * @return Liefert eine Liste von Notizen
     */
    @Override
    public List<Notiz> filterAlleNotizenMiteinerBestimmtenKategorie(int notizblockID, int kategorieID) {
        IntValidator.checkObIntNullOderNegativIst(notizblockID);
        IntValidator.checkObIntNullOderNegativIst(kategorieID);
        Predicate<Notiz> kategoriePredicate = notiz -> notiz.getKategorieID() == kategorieID;
        return filterAlleNotizenMitLambda(notizblockID, kategoriePredicate);
    }
}
