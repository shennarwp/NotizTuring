package notizverwaltung.service.interfaces;

import notizverwaltung.model.classes.Aufgabe;
import notizverwaltung.model.classes.Notiz;

import java.util.List;

public interface AufgabenService {
    public Aufgabe getAufgabe(int aufgabeID);

    //Sollen wir hier die NotizID oder das Objekt Notiz werden?
    //Vorteil <-> Nachteile
    //Gem. DB Entwurf eine Tabelle
    //Ist die Methode hier richtig? oder in NotizService?
    public void addAufgabe (int notizID, Aufgabe aufgabe);
    public void updateAufgabe(int notizID, Aufgabe aufgabe);

    //notizID und aufgabeID sollte der Primärschlussel der DB sein
    public void removeAufgabe (int notizID, int aufgabeID);

    public List<Notiz> getAlleAufgabenEinerNotize (int notizID, int aufgabeID);




}
