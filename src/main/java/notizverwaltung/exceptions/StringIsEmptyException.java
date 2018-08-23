package notizverwaltung.exceptions;

public class StringIsEmptyException extends Exception {
	private static final String MESSAGE = "Der String darf nicht leer sein!";
	
	public StringIsEmptyException() {
		super(MESSAGE);
	}
}
