package notizverwaltung.service.classes;

import notizverwaltung.builders.DaoObjectBuilder;
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

	public BearbeitungszustandServiceImpl(BearbeitungszustandDAO bearbeitungszustandDAO) throws ObjectIstNullException {
		ObjectValidator.checkObObjectNullIst(bearbeitungszustandDAO);
		this.bearbeitungszustandDAO = bearbeitungszustandDAO;
	}

	public BearbeitungszustandServiceImpl() throws ObjectIstNullException {
		this(DaoObjectBuilder.getBearbeitungszustandDaoObject());
	}

	@Override
	public int addBearbeitungszustand (Bearbeitungszustand bearbeitungszustand) {
		int bearbeitungszustandID = bearbeitungszustandDAO.addBearbeitungszustand(bearbeitungszustand);
		bearbeitungszustand.setBearbeitungszustandID(bearbeitungszustandID);
		return bearbeitungszustandID;
	}

	@Override
	public Bearbeitungszustand getBearbeitungszustand (int bearbeitungszustandID) {
		return new BearbeitungszustandDAOImpl() {
			@Override
			public List<Notiz> getAlleBearbeitungszustaendeVomNotizblock(int bearbeitungszustand) {
				return null;
			}
		}.getBearbeitungszustand(bearbeitungszustandID);
	}

	@Override
	public void updateBearbeitungszustand (Bearbeitungszustand bearbeitungszustand) {

	}

	@Override
	public void deleteBearbeitungszustand (int bearbeitungszustandID) {}

	@Override
	public List<Bearbeitungszustand> getAllBearbeitungszustand() {
		return null;
	}


}
