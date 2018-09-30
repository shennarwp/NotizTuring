package notizverwaltung.dao.interfaces;

/**
 * DAO-superclass
 * implementiert die Verbindung mit dem Datenbank
 * @author Shenna RWP
 */
public interface ObjectDAO
{
	//Hilfsfunktion, erstelle die persistence entity objekt, um mit dem Datenbank zu kommunizieren
	void initTransaction();

	//Hilfsfunktion, schliesst die persistence entity objekt aus
	void finishTransaction();
}
