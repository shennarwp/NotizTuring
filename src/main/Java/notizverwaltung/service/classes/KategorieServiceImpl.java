package notizverwaltung.service.classes;

import notizverwaltung.builders.DaoObjectBuilder;
import notizverwaltung.dao.classes.KategorieDAOImpl;
import notizverwaltung.dao.interfaces.KategorieDAO;
import notizverwaltung.exceptions.IntIstNegativException;
import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.model.classes.KategorieImpl;
import notizverwaltung.model.interfaces.Kategorie;
import notizverwaltung.service.interfaces.KategorieService;
import notizverwaltung.validators.ObjectValidator;

import java.util.List;

/**
 * Service-Klasse für Kategorie
 *
 * @author Shenna RWP
 */
public class KategorieServiceImpl implements KategorieService
{
	private KategorieDAO kategorieDAO;

	public KategorieServiceImpl(KategorieDAO kategorieDAO) throws ObjectIstNullException {
		ObjectValidator.checkObObjectNullIst(kategorieDAO);
		this.kategorieDAO = kategorieDAO;
	}

	public KategorieServiceImpl() throws ObjectIstNullException {
		this(DaoObjectBuilder.getKategorieDaoObject());
	}

	@Override
	public int addKategorie(Kategorie kategorie) throws IntIstNegativException {
		int kategorieID = kategorieDAO.addKategorie(kategorie);
		kategorie.setKategorieID(kategorieID);
		return kategorieID;
	}

	@Override
	public Kategorie getKategorie(int kategorieID) {
		return kategorieDAO.getKategorie(kategorieID);
	}

	@Override
	public void updateKategorie (Kategorie kategorie) {

	}

	//Achtung nur löschen, wenn keine Artikel mehr eine Kategorie hat
	@Override
	public void deleteKategorie (int kategorieID) {

	}

	@Override
	public List<Kategorie> getAllKategorien() {
		return null;
	}
}
