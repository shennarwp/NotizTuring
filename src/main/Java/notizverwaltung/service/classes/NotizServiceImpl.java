package notizverwaltung.service.classes;

import notizverwaltung.model.classes.NotizImpl;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.interfaces.NotizService;

import java.util.List;

/**
 *
 * Die Klasse stellt Funktionalitäten für Notizen bereit
 *
 *
 * @author Tobias Gottschalk
 * @version 1.0
 * @since
 */
public class NotizServiceImpl implements NotizService {

    @Override
    public NotizImpl getNotiz(int NotizID) {
        return null;
    }

    @Override
    public void newNotiz(Notiz notiz, int notizblockID) {

    }

    @Override
    public void removeNotiz(int NotizID) {

    }

    @Override
    public void updateNotiz(Notiz notiz) {

    }

    @Override
    public List<Notiz> getAlleNotizenvonEinerKategorie(Kategorie kategorie) {
        return null;
    }

    @Override
    public List<Notiz> getAlleNotizenImNotizblock(int notizblockID) {
        return null;
    }
}
