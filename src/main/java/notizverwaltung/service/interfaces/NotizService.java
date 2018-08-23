package service.interfaces;


import model.classes.NotizImpl;

import java.util.List;
import model.classes.Kategorie;

/**
 *
 * Die Klasse stellt Funktionalitäten für Notizen bereit
 *
 *
 * @author
 * @version 1.0
 * @since
 */
public interface NotizService {

    public NotizImpl getNotiz(int NotizID);
    public void newNotiz(NotizImpl notiz, int notizblockID);
    public void removeNotiz(int NotizID);
    public void updateNotiz(NotizImpl notiz);

    //TODO Brauchen wir eine Methode zum Verändern der Spalte?


    public List<NotizImpl> getAlleNotizenvonEinerKategorie(Kategorie kategorie);
    public List<NotizImpl> getAlleNotizenImNotizblock (int notizblockID);

 }