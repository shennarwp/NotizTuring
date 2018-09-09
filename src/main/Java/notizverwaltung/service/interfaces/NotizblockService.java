package notizverwaltung.service.interfaces;

import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Kategorie;

import java.util.List;

public interface NotizblockService {

	public List<Kategorie> getAlleKategorienVomNotizblock(int notizblockID);
	public List<Bearbeitungszustand> getAlleBearbeitungszustaendeVomNotizblock(int notizblockID);
}
