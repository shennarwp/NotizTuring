package notizverwaltung.service.interfaces;

import notizverwaltung.model.interfaces.Notiz;

import java.util.List;
import java.util.function.Predicate;

public interface NotizFilterService {

    public List<Notiz> filterAlleNotizenMitLambda (Predicate<Notiz> notizPredicate, List<Notiz> listeVonNotiz);

    public List<Notiz> filterAlleNotizenMitPriorität(int notizblockID, List<Notiz> listVonNotizen);
    public List<Notiz> filterAlleNotizenOhnePriorität (int notizblockID, List<Notiz> listVonNotizen);

    public List<Notiz> filterAlleNotizenMitEinemBearbeitunszustand(int bearbeitungszustandID, List<Notiz> listVonNotizen);
}
