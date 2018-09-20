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
	public List<Notiz> sortNachComparator(int notizblockID, Comparator<Notiz> notizComparator);
	public List<Notiz> sortNachFaelligkeitAufsteigend(int notizblockID);
	public List<Notiz> sortNachFaelligkeitAbsteigend(int notizblockID);
}
