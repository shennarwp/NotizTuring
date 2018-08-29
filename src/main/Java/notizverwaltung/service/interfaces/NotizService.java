package notizverwaltung.service.interfaces;



import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.model.interfaces.Notiz;

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
//TODO Kommentare oder irgendwelche Tests für Interface notwendig?
public interface NotizService {


    public int addNotiz(Notiz notiz, int notizblockID);
    public Notiz getNotiz(int NotizID);

    public void updateNotiz(Notiz notiz);
    public void deleteNotiz(int NotizID);

    //TODO Brauchen wir eine Methode zum Verändern der Spalte?


    public List<Notiz> getAlleNotizenvonEinerKategorie(Kategorie kategorie);
    public List<Notiz> getAlleNotizenImNotizblock (int notizblockID);

 }