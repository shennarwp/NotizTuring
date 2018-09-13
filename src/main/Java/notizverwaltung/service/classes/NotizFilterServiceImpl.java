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
    public List<Notiz> filterAlleNotizenMitLambda(Predicate<Notiz> notizPredicate, List<Notiz> listeVonNotizen){
        ArrayList<Notiz> neueListe = new ArrayList<>();
        for (Notiz notiz:listeVonNotizen){
            if(notizPredicate.test(notiz)){
                neueListe.add(notiz);
            }
        }

        return neueListe;
    }

    @Override
    public List<Notiz> filterAlleNotizenMitPriorität(int notizblockID, List<Notiz> listeVonNotizen) {
        ArrayList<Notiz> neueListe = new ArrayList<>();

        for (Notiz notiz:listeVonNotizen){
            if(notiz.getPrioritaet()==true){
                neueListe.add(notiz);
            }
        }

        return neueListe;
    }

    @Override
    public List<Notiz> filterAlleNotizenOhnePriorität(int notizblockID, List<Notiz> listeVonNotizen) {
        ArrayList<Notiz> neueListe = new ArrayList<>();

        for (Notiz notiz:listeVonNotizen){
            if(notiz.getPrioritaet()==false){
                neueListe.add(notiz);
            }
        }
        return neueListe;
    }

    //TODO Implementieren
    public List<Notiz> filterAlleNotizenMiteinerBestimmtenKategorie(int kategorieID, int notizblock){
        ArrayList<Notiz> neueListe =  new ArrayList<>();

        return null;
    }


    @Override
    public List<Notiz> filterAlleNotizenMitEinemBearbeitunszustand(int bearbeitungszustandID, List<Notiz> listVonNotizen) {
        ArrayList<Notiz> neueListe = new ArrayList<>();

        for (Notiz notiz:listVonNotizen){
            if(notiz.getBearbeitungszustandID() == bearbeitungszustandID){
                neueListe.add(notiz);
            }
        }


        return neueListe;
    }


}
