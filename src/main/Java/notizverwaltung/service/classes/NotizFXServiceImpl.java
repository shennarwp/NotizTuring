package notizverwaltung.service.classes;

import notizverwaltung.builders.ModelObjectBuilder;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.model.interfaces.NotizFX;
import notizverwaltung.service.interfaces.NotizFXService;
import notizverwaltung.validators.ObjectValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse NotizFXServiceImpl implementiert NotizFXService Interface
 * @author Kevin Engelhardt
 * @version 1.0
 */
public class NotizFXServiceImpl implements NotizFXService {

    /**
     * Methode wandelt Notiz in NotizFX um
     * @param notiz
     * @return NotizFX
     */
    @Override
    public NotizFX wrapNotiz(Notiz notiz) {
        ObjectValidator.checkObObjectNullIst(notiz);
        NotizFX notizFX = ModelObjectBuilder.getNotizFXObjekt();

        notizFX.setNotizID(notiz.getNotizID());
        notizFX.setTitle(notiz.getTitle());
        notizFX.setKategorieID(notiz.getKategorieID());
        notizFX.setBearbeitungszustandID(notiz.getBearbeitungszustandID());
        notizFX.setBeschreibung(notiz.getBeschreibung());
        notizFX.setPrioritaet(notiz.getPrioritaet());
        notizFX.setFaelligkeit(notiz.getFaelligkeit());
        notizFX.setErinnerung(notiz.getErinnerung());
        notizFX.setErstellung(notiz.getErstellung());



        return notizFX;
    }

    /**
     * Methode wandelt NotizFX in Notiz um
     * @param notizFX
     * @return Notiz
     */

    @Override
    public Notiz unwrapNotizFX(NotizFX notizFX){
        ObjectValidator.checkObObjectNullIst(notizFX);
        Notiz notiz = ModelObjectBuilder.getNotizObject();

        notiz.setID(notizFX.getNotizID().getValue());
        notiz.setTitle(notizFX.getTitle().getValue());
        notiz.setKategorieID(notizFX.getKategorieID().getValue());
        notiz.setBearbeitungszustandID(notizFX.getBearbeitungszustandID().getValue());
        notiz.setBeschreibung(notizFX.getBeschreibung().getValue());
        notiz.setPrioritaet(notizFX.getPrioritaet().getValue());
        notiz.setFaelligkeit(notizFX.getFaelligkeit().getValue());

        return notiz;
    }

    /**
     * Methode wandelt notizListe in NotizFX Liste um
     * @param notizListe
     * @return List von NotizFX
     */
    @Override
    public List<NotizFX> convertInNotizFXList(List<Notiz> notizListe){
        ObjectValidator.checkObObjectNullIst(notizListe);
        List<NotizFX> notizFXListe = new ArrayList<>();

        for(Notiz notiz : notizListe){
            NotizFX notizFX = wrapNotiz(notiz);
            notizFXListe.add(notizFX);
        }
        return notizFXListe;
    }


}
