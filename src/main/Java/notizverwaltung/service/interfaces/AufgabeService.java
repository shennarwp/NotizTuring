package notizverwaltung.service.interfaces;

import notizverwaltung.model.classes.AufgabeImpl;

import java.util.List;


/**
 *
 * Die Klasse stellt Funktionalitäten für Aufgaben bereit
 *
 *
 * @author Tobias Gottschalk
 * @version 1.0
 * @since
 */
public interface AufgabeService {

    public AufgabeImpl getAufgabe(int notizID, int aufgabeID);
    public void addAufgabe (int notizID, AufgabeImpl aufgabeImpl);
    public void updateAufgabe(int notizID, AufgabeImpl aufgabeImpl);

    //notizID und aufgabeID sollte der Primärschlussel der DB sein
    public void removeAufgabe (int notizID, int aufgabeID);

    public List<AufgabeImpl> getAlleAufgabenEinerNotize (int notizID);
}
