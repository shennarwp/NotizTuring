package notizverwaltung.exceptions;

public class ObjectIstNullException extends Exception {
    private static String Message ="Das Objekt darf nicht null sein";

    public ObjectIstNullException(){
        super(Message);
    }
}
