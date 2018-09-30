package notizverwaltung.service.interfaces;

import notizverwaltung.model.interfaces.Notiz;

import java.util.List;


/**
 *
 * Die Klasse stellt verschiedene Funktionalitäten für Notizen bereit
 *
 *
 * @author Tobias Gottschalk
 * @version 1.0
 */

public interface NotizService {


    /**
     * Schreibt eine Notiz in die Datenbank
     * @param notiz Notizblock Objekt
     * @param notizblockID ID der Notizblocks
     * @return Liefert die ID der Notiz zurueck
     */
    public int addNotiz(Notiz notiz, int notizblockID);


    /**
     * @param NotizID Notiz ID. Integer. Es duerfen nur ID genutzt werden, die größer als 0 sind
     * @return Liefert das angeforderte Notiz-Objekt zurueck
     */
    public Notiz getNotiz(int NotizID);


    /**
     * Aktualisiert eine Notiz in der Datenbank
     * @param notiz Notiz
     */
    public void updateNotiz(Notiz notiz);


    /**
     * Loescht eine Notiz aus der Datenbank
     * @param NotizID Notiz ID. Integer. Es duerfen nur ID genutzt werden, die größer als 0 sind
     */
    public void deleteNotiz(int NotizID);

    /**
     * Methode gibt eine List von Notizen zu einer bestimmten Kategorie zurueck
     * @param kategorieID ID der Kategorie
     * @return Liste von Notizen
     */
    public List<Notiz> getAlleNotizenvonEinerKategorie(int kategorieID);





    /**
     * Gibt eine Liste von allen in der Datenbank zurueck, welche sich in der Datenbank befinden.
     * @return Liste von allen Notizen
     */
    public List<Notiz> getAlleNotizen();


    /**
     * Methode gibt eine Liste mit Notizen zurueck, welche alle einen bestimmten Bearbeitungszustand haben
     * @param bearbeitungszustandID ID des Bearbeitungszustand als Integer. Die BearbeitungszustandsID darf nicht kleiner als 1 sein
     * @return Liefert eine Liste von Notizen
     */
    public List<Notiz> getAlleNotizenVonEinemBearbeitungszustand(int bearbeitungszustandID);



    /**
     * Die Methode gibt eine Liste von allen Notizen, welche sich in einem bestimmten Notizblock befinden zurueck
     * @param notizblockID ID des Notizblock als Integer.
     * @return Liefert eine Liste von Notizen
     */
    public List<Notiz> getAlleNotizenVomNotizblock(int notizblockID);



 }