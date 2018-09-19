package notizverwaltung.service.interfaces;

import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.model.interfaces.NotizFX;

import java.util.List;

public interface NotizFXService {

    public NotizFX wrapNotizInNotizFX (Notiz notiz);

    public Notiz wrapNotizFXinNotiz(NotizFX notizFX);

    public List<NotizFX> convertInNotizFXList(List<Notiz> notizListe);


}
