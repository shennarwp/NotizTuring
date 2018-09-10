package notizverwaltung.dao.classes;

import notizverwaltung.dao.interfaces.ObjectDAO;
import notizverwaltung.model.interfaces.Bearbeitungszustand;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO-superclass
 * implementiert die Verbindung mit dem Datenbank
 *
 * @author Shenna RWP
 */
public class ObjectDAOImpl implements ObjectDAO
{
	public static Connection connection;
	protected EntityManagerFactory factory;
	protected EntityManager entityManager;
	protected EntityTransaction transaction;

	public ObjectDAOImpl() {
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/testdb.db" );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Hilfsfunktion, erstelle die persistence entity objekt, um mit dem Datenbank zu kommunizieren
	 */
	@Override
	public void initTransaction() {
		factory = Persistence.createEntityManagerFactory("test");
		entityManager = factory.createEntityManager();
		transaction = entityManager.getTransaction();
	}

	/**
	 * Hilfsfunktion, schliesst die persistence entity objekt aus
	 */
	@Override
	public void finishTransaction() {
		entityManager.close();
		factory.close();
	}

}
