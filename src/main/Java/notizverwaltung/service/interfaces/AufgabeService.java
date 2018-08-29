package notizverwaltung.service.interfaces;

import notizverwaltung.model.classes.AufgabeImpl;

import java.util.List;

public interface AufgabeService {

    public AufgabeImpl getAufgabe(int notizID, int aufgabeID);
    public void addAufgabe (int notizID, AufgabeImpl aufgabeImpl);
    public void updateAufgabe(int notizID, AufgabeImpl aufgabeImpl);

    //notizID und aufgabeID sollte der Primärschlussel der DB sein
    public void removeAufgabe (int notizID, int aufgabeID);

    public List<AufgabeImpl> getAlleAufgabenEinerNotize (int notizID);
}
