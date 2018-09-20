package notizverwaltung.service.classes;

import notizverwaltung.builders.DaoObjectBuilder;
import notizverwaltung.dao.interfaces.NotizDAO;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.interfaces.NotizSortService;
import notizverwaltung.validators.IntValidator;
import notizverwaltung.validators.ObjectValidator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementierung für Sortierung der Notizen
 * @author Shenna RWP
 */
public class NotizSortServiceImpl implements NotizSortService {

	private NotizDAO notizDAO;
	Comparator<Notiz> aufsteigendFaelligkeit = Comparator.comparing(Notiz::getFaelligkeit);
	/**
	 * Konstruktor fuer Filterklasse
	 * @param notizDAO
	 */
	public NotizSortServiceImpl(NotizDAO notizDAO){
		ObjectValidator.checkObObjectNullIst(notizDAO);
		this.notizDAO = notizDAO;

	}

	public NotizSortServiceImpl(){
		this(DaoObjectBuilder.getNotizDaoObject());
	}


	/**
	 * sortiert alle Notizen nach ein vorgegebene Comparator
	 * @param notizblockID Integer, darf nicht kleiner als 1
	 * @param notizComparator vorgegebene Comparator
	 * @return sortierende Liste von Notizen
	 */
	@Override
	public List<Notiz> sortNachComparator(int notizblockID, Comparator<Notiz> notizComparator) {
		List<Notiz> listMitAllenNotizen = notizDAO.getAlleNotizenVomNotizblock(notizblockID);
		return listMitAllenNotizen.stream()
								   .sorted(notizComparator)
								   .collect(Collectors.toList());
	}

	/**
	 * sortiert alle Notizen aufsteigend nach Faelligkeitsdatum
	 * @param notizblockID
	 * @return aufsteigend sortierende Liste von Notizen
	 */
	@Override
	public List<Notiz> sortNachFaelligkeitAufsteigend(int notizblockID) {
		IntValidator.checkObIntNullOderNegativIst(notizblockID);
		return sortNachComparator(notizblockID, aufsteigendFaelligkeit);
	}

	/**
	 * sortiert alle Notizen absteigend nach Faelligkeitsdatum
	 * @param notizblockID
	 * @return absteigend sortierende Liste von Notizen
	 */
	@Override
	public List<Notiz> sortNachFaelligkeitAbsteigend(int notizblockID) {
		IntValidator.checkObIntNullOderNegativIst(notizblockID);
		List<Notiz> notizList = sortNachComparator(notizblockID, aufsteigendFaelligkeit);
		Collections.reverse(notizList);
		return notizList;
	}
}
