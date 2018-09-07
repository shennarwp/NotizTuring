package notizverwaltung.exceptions;

/**
 * Wirft eine Execption, wenn ein int negativ ist
 *
 * @author Tobias Gottschalk
 *
 * @version 1.0
 */
public class IntIstNegativException extends RuntimeException{
    private static final String MESSAGE = "Der Integer darf nicht 0 oder negativ sein";

    public IntIstNegativException(){
        super(MESSAGE);
    }
}
