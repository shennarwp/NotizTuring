package notizverwaltung.service.interfaces;

import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.model.interfaces.Kategorie;

import java.util.List;


/**
 * Die Klasse stellt Funktionalitäten für Kategorien bereit
 *
 *
 * @author Tobias Gottschalk
 * @version 1.0
 */
public interface KategorieService {

    /**
     * Die Methode fuegt eine Kategorie in die Datenbank hinzu
     * @param kategorie Kategorie Objekt, welches in die Datenbank geschrieben wird
     * @return Liefert die ID der Notiz, welche in die Datenbank eingefuegt
     */
    public int addKategorie(Kategorie kategorie);


    /**
     * Methode gibt eine Kategorie Objekt zuruck
     * @param kategorieID Kategorie ID als Integer. Darf nur groesser als 0 sein
     * @return Liefert ein Kategorie Objekt zurueck
     */
    public Kategorie getKategorie(int kategorieID);


    /**
     * Die Methode aktualisiert ein Kategorie Objekt in der Datenbank
     * @param kategorie Kategorie Objekt
     */
    public void updateKategorie (Kategorie kategorie);


    /**
     * Loscht eine Kategorie aus der Datenbank
     * @param kategorieID Kategorie ID als Integer, darf nicht kleiner als 1 sein
     */
    public void deleteKategorie (int kategorieID);


    /**
     * Liefert die Anzahl an Notizen zurueck
     * @param kategorieID Kategorie ID als Integer, darf nicht kleiner als 1 sein
     * @return Anzahl der Notizen als long
     */
    public long getAnzahlNotizenInKategorie(int kategorieID);


    /**
     * Die Methode liefert eine Liste aller Kategorien zurueck
     * @return Liste von Kategorien
     */
    public List<Kategorie> getAlleKategorien();


    /**
     * Die Methode liefert den Namen einer Kategorie zurueck.
     * @param kategorieID Kategorie ID als Integer, darf nicht kleiner als 1 sein
     * @return Name der Kategorie als String
     */
    public String findKategorieName(int kategorieID);

}
