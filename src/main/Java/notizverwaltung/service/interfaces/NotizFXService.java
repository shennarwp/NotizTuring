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

    public NotizFX wrapNotiz(Notiz notiz);

    public Notiz unwrapNotizFX(NotizFX notizFX);

    public List<NotizFX> convertInNotizFXList(List<Notiz> notizListe);


}
