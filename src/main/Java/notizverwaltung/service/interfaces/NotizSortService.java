package notizverwaltung.service.interfaces;

import notizverwaltung.model.interfaces.Notiz;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Interface für Sortierung
 * @author Shenna RWP
 */
public interface NotizSortService {

	//sortiert alle Notizen nach ein vorgegebene Comparator
	public List<Notiz> sortNachComparator(int notizblockID, Comparator<Notiz> notizComparator);

	//sortiert alle Notizen aufsteigend nach Faelligkeitsdatum
	public List<Notiz> sortNachFaelligkeitAufsteigend(int notizblockID);

	//sortiert alle Notizen absteigend nach Faelligkeitsdatum
	public List<Notiz> sortNachFaelligkeitAbsteigend(int notizblockID);
}
