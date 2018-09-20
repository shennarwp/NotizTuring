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


	@Override
	public List<Notiz> sortNachComparator(int notizblockID, Comparator<Notiz> notizComparator) {
		List<Notiz> listMitAllenNotizen = notizDAO.getAlleNotizenVomNotizblock(notizblockID);
		return listMitAllenNotizen.stream()
								   .sorted(notizComparator)
								   .collect(Collectors.toList());
	}

	@Override
	public List<Notiz> sortNachFaelligkeitAufsteigend(int notizblockID) {
		IntValidator.checkObIntNullOderNegativIst(notizblockID);
		return  sortNachComparator(notizblockID, aufsteigendFaelligkeit);
	}

	@Override
	public List<Notiz> sortNachFaelligkeitAbsteigend(int notizblockID) {
		IntValidator.checkObIntNullOderNegativIst(notizblockID);
		List<Notiz> notizList = sortNachComparator(notizblockID, aufsteigendFaelligkeit);
		Collections.reverse(notizList);
		return notizList;
	}
}
