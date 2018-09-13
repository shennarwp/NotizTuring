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

	public List<Kategorie> getAlleKategorienVomNotizblock(int notizblockID);
	public List<Bearbeitungszustand> getAlleBearbeitungszustaendeVomNotizblock(int notizblockID);
}
