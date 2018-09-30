package notizverwaltung.service.interfaces;

import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.model.interfaces.NotizFX;

import java.util.List;

/**
 * Interface fuer Klasse NotizFXServiceImpl
 * @author Kevin Engelhardt
 * @version 1.0
 */

public interface NotizFXService {

    //Wandelt Notiz in NotizFX um
    public NotizFX wrapNotiz(Notiz notiz);
    //Wandelt Notiz in NotizFX um
    public Notiz unwrapNotizFX(NotizFX notizFX);
    //Wandelt notizListe in notizFXListe um
    public List<NotizFX> convertInNotizFXList(List<Notiz> notizListe);


}
