package notizverwaltung.service.classes;

import notizverwaltung.builders.ModelObjectBuilder;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.model.interfaces.NotizFX;
import notizverwaltung.service.interfaces.NotizFXService;

import java.util.ArrayList;
import java.util.List;

public class NotizFXServiceImpl implements NotizFXService {

    @Override
    public NotizFX wrapNotizInNotizFX(Notiz notiz) {
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

    @Override
    public List<NotizFX> convertInNotizFXList(List<Notiz> notizListe){
        List<NotizFX> notizFXListe = new ArrayList<>();

        for(Notiz notiz : notizListe){
            NotizFX notizFX = wrapNotizInNotizFX(notiz);
            notizFXListe.add(notizFX);
        }
        return notizFXListe;
    }


}
