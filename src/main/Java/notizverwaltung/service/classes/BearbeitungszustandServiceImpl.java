package notizverwaltung.service.classes;

import notizverwaltung.builders.DaoObjectBuilder;
import notizverwaltung.builders.ServiceObjectBuilder;
import notizverwaltung.dao.classes.BearbeitungszustandDAOImpl;
import notizverwaltung.dao.interfaces.BearbeitungszustandDAO;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.model.interfaces.Notiz;
import notizverwaltung.service.interfaces.BearbeitungszustandService;
import notizverwaltung.validators.ObjectValidator;

import java.util.List;

/**
 * Service-Klasse für Bearbeitungszustand
 *
 * @author Shenna RWP, Agra Bimantara
 */
public class BearbeitungszustandServiceImpl implements BearbeitungszustandService {

	private BearbeitungszustandDAO bearbeitungszustandDAO;

	/**
	 * Konstruktor
	 * @param bearbeitungszustandDAO
	 * @throws ObjectIstNullException
	 */
	public BearbeitungszustandServiceImpl(BearbeitungszustandDAO bearbeitungszustandDAO) throws ObjectIstNullException {
		ObjectValidator.checkObObjectNullIst(bearbeitungszustandDAO);
		this.bearbeitungszustandDAO = bearbeitungszustandDAO;
	}

	public BearbeitungszustandServiceImpl() throws ObjectIstNullException {
		this(DaoObjectBuilder.getBearbeitungszustandDaoObject());
	}

	/**
	 * erstelle einen neue Bearbeitungszustand
	 * @param bearbeitungszustand
	 * @return
	 */
	@Override
	public int addBearbeitungszustand (Bearbeitungszustand bearbeitungszustand) {
		int bearbeitungszustandID = bearbeitungszustandDAO.addBearbeitungszustand(bearbeitungszustand);
		bearbeitungszustand.setBearbeitungszustandID(bearbeitungszustandID);
		return bearbeitungszustandID;
	}

	/**
	 * suche einen bestimmte Bearbeitungszustand
	 * @param bearbeitungszustandID
	 * @return Bearbeitungszustand
	 */
	@Override
	public Bearbeitungszustand getBearbeitungszustand (int bearbeitungszustandID) {
		return new BearbeitungszustandDAOImpl().getBearbeitungszustand(bearbeitungszustandID);
	}

	/**
	 * Inhalt von Bearbeitungszustand ändern
	 * @param bearbeitungszustand
	 */
	@Override
	public void updateBearbeitungszustand (Bearbeitungszustand bearbeitungszustand) {
		ObjectValidator.checkObObjectNullIst(bearbeitungszustand);
		bearbeitungszustandDAO.updateBearbeitungszustand(bearbeitungszustand);
	}

	/**
	 * lösche einen bestimmte Bearbeitungszustand
	 * @param bearbeitungszustandID
	 */
	@Override
	public void deleteBearbeitungszustand (int bearbeitungszustandID) {
		if(getAnzahlNotizenInBearbeitungszustand(bearbeitungszustandID) == 0) {
			bearbeitungszustandDAO.deleteBearbeitungszustand(bearbeitungszustandID);
		}
		//TODO throws exception later
	}

	/**
	 * suche die Summe von Notizen in einem bestimmten Bearbeitungszustand
	 * @param bearbeitungszustandID
	 * @return Summe der Notizen von einer bestimmten Kategorie
	 */
	@Override
	public long getAnzahlNotizenInBearbeitungszustand(int bearbeitungszustandID) {
		return bearbeitungszustandDAO.getAnzahlNotizenInBearbeitungszustand(bearbeitungszustandID);
	}

	/**
	 * suche die Liste von aller Bearbeitungszustände
	 * @return ie Liste von aller Bearbeitungszustände
	 */
	@Override
	public List<Bearbeitungszustand> getAllBearbeitungszustand() {
		return bearbeitungszustandDAO.getAlleBearbeitungszustand();
	}


}
