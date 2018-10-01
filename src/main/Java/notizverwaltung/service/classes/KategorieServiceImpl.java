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

	/**
	 * Konstruktor
	 * @param kategorieDAO
	 * @throws ObjectIstNullException
	 */
	public KategorieServiceImpl(KategorieDAO kategorieDAO) throws ObjectIstNullException {
		ObjectValidator.checkObObjectNullIst(kategorieDAO);
		this.kategorieDAO = kategorieDAO;
	}

	/**
	 * Konstruktor
	 * @throws ObjectIstNullException
	 */
	public KategorieServiceImpl() throws ObjectIstNullException {
		this(DaoObjectBuilder.getKategorieDaoObject());
	}

	/**
	 * erstelle/addiere neue Kategorie
	 * @param kategorie Kategorie Objekt, welches in die Datenbank geschrieben wird
	 * @return neue Kategorie
	 * @throws IntIstNegativException
	 */
	@Override
	public int addKategorie(Kategorie kategorie) throws IntIstNegativException {
		int kategorieID = kategorieDAO.addKategorie(kategorie);
		kategorie.setKategorieID(kategorieID);
		return kategorieID;
	}

	/**
	 * suche eine bestimmte Kategorie
	 * @param kategorieID Kategorie ID als Integer. Darf nur groesser als 0 sein
	 * @return
	 */
	@Override
	public Kategorie getKategorie(int kategorieID) {
		return kategorieDAO.getKategorie(kategorieID);
	}

	/**
	 * Inhalte von der Kategorie ändern
	 * @param kategorie Kategorie Objekt
	 */
	@Override
	public void updateKategorie (Kategorie kategorie) {
		ObjectValidator.checkObObjectNullIst(kategorie);
		kategorieDAO.updateKategorie(kategorie);
	}

	/**
	 * läsche eine bestimmte Kategorie
	 * @param kategorieID Kategorie ID als Integer, darf nicht kleiner als 1 sein
	 */
	//Achtung nur löschen, wenn keine Artikel mehr eine Kategorie hat
	@Override
	public void deleteKategorie (int kategorieID) {
		if(getAnzahlNotizenInKategorie(kategorieID) == 0) {
			kategorieDAO.deleteKategorie(kategorieID);
		}
	}

	/**
	 * suche die Summe der Notizen von einer bestimmten Kategorie
	 * @param kategorieID Kategorie ID als Integer, darf nicht kleiner als 1 sein
	 * @return Summe der Notizen von einer bestimmten Kategorie
	 */
	@Override
	public long getAnzahlNotizenInKategorie(int kategorieID) {
		return kategorieDAO.getAnzahlNotizenInKategorie(kategorieID);
	}

	/**
	 * suche Liste von aller vorhandenen Kategorie
	 * @return Liste von aller vorhandenen Kategorie
	 */
	@Override
	public List<Kategorie> getAlleKategorien() {

	    return new KategorieDAOImpl().getAlleKategorien();
	}

	/**
	 * suche eine bestimmte Name der Kategorie
	 * @param kategorieID Kategorie ID als Integer, darf nicht kleiner als 1 sein
	 * @return eine bestimmte Name der Kategorie
	 */
	@Override
	public String findKategorieName(int kategorieID){
		Kategorie kategorie = getKategorie(kategorieID);
		String kategorieName = kategorie.getKategorieName();
		return kategorieName;
	}
}
