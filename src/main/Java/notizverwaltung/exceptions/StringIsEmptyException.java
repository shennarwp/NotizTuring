package notizverwaltung.exceptions;

/**
 * Wirft eine Execption, wenn ein String leer oder null ist.
 *
 * @author Tobias Gottschalk
 *
 * @version 1.0
 */
public class StringIsEmptyException extends Exception {
	private static final String MESSAGE = "Der String darf nicht leer sein!";
	
	public StringIsEmptyException() {
		super(MESSAGE);
	}
}
