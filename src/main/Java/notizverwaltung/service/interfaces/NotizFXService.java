package notizverwaltung.service.interfaces;

import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.model.interfaces.NotizFX;

public interface NotizFXService {

    public NotizFX wrapNotizInNotizFX (Notiz notiz);

}
