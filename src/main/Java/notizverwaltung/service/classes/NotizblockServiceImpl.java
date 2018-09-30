package notizverwaltung.service.classes;

import notizverwaltung.builders.DaoObjectBuilder;
import notizverwaltung.dao.interfaces.NotizblockDAO;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.service.interfaces.NotizblockService;
import notizverwaltung.validators.IntValidator;
import notizverwaltung.validators.ObjectValidator;

import java.util.List;

/**
 * Service-klasse für Notizblock
 * @author Shenna RWP
 */
public class NotizblockServiceImpl implements NotizblockService
{
	private NotizblockDAO notizblockDAO;

	/**
	 * Konstruktor
	 * @param notizblockDAO
	 * @throws ObjectIstNullException
	 */
	public NotizblockServiceImpl(NotizblockDAO notizblockDAO) throws ObjectIstNullException {
		ObjectValidator.checkObObjectNullIst(notizblockDAO);
		this.notizblockDAO = notizblockDAO;
	}

	public NotizblockServiceImpl() {
		this(DaoObjectBuilder.getNotizblockDaoObject());
	}

	/**
	 * suche die Liste von aller vorhandenen Kategorien in einer Notizblock
	 * @param notizblockID NotizblockID als Integer. Der Integer darf nicht kleiner als 1 sein
	 * @return die Liste von aller vorhandenen Kategorien in einer Notizblock
	 */
	@Override
	public List<Kategorie> getAlleKategorienVomNotizblock(int notizblockID) {
		IntValidator.checkObIntNullOderNegativIst(notizblockID);
		return notizblockDAO.getAlleKategorienVomNotizblock(notizblockID);
	}

	/**
	 * suche die Liste von aller vorhandenen Bearbeitungszustände in einer Notizblock
	 * @param notizblockID NotizblockID als Integer. Der Integer darf nicht kleiner als 1 sein
	 * @return die Liste von aller vorhandenen Bearbeitungszustände in einer Notizblock
	 */
	@Override
	public List<Bearbeitungszustand> getAlleBearbeitungszustaendeVomNotizblock(int notizblockID) {
		IntValidator.checkObIntNullOderNegativIst(notizblockID);
		return notizblockDAO.getAlleBearbeitungszustaendeVomNotizblock(notizblockID);
	}
}
