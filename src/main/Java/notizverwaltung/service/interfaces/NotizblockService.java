package notizverwaltung.service.interfaces;

import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Kategorie;

import java.util.List;

/**
 *
 * Die Klasse stellt Funktionalitäten für den Notizblock bereit
 *
 *
 * @author Tobias Gottschalk
 * @version 1.0
 * @since
 */
public interface NotizblockService {

	/**
	 * Die Methode gibt eine Liste mit allen Kategorien von einem Notizblock zurueck
	 * @param notizblockID NotizblockID als Integer. Der Integer darf nicht kleiner als 1 sein
	 * @return Liefert eine Liste von Kategorien zurueck
	 */
	public List<Kategorie> getAlleKategorienVomNotizblock(int notizblockID);


	/**Die Methode gibt eine Liste mit allen Bearbeitungszuständen von einem bestimmten Notizblock zurueck
	 * @param notizblockID NotizblockID als Integer. Der Integer darf nicht kleiner als 1 sein
	 * @return Liste von Bearbeitungszustände
	 */
	public List<Bearbeitungszustand> getAlleBearbeitungszustaendeVomNotizblock(int notizblockID);
}
