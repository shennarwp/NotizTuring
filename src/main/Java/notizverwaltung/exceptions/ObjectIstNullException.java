package notizverwaltung.exceptions;

/**
 * Die Klasse wirft eine Expection, wenn das Objekt null ist
 *
 * @author Tobias Gottschalk
 *
 * @version 1.0
 */
public class ObjectIstNullException extends RuntimeException {
    private static String Message ="Das Objekt darf nicht null sein";

    public ObjectIstNullException(){
        super(Message);
    }
}
