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

    //Methode wandelt NotizFX in Notiz um
    public NotizFX wrapNotiz(Notiz notiz);

    //Methode wandelt NotizFX in Notiz um
    public Notiz unwrapNotizFX(NotizFX notizFX);

    //Methode wandelt notizListe in NotizFX Liste um
    public List<NotizFX> convertInNotizFXList(List<Notiz> notizListe);


}
