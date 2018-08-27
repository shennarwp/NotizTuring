package notizverwaltung.builders;

import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.service.classes.NotizServiceImpl;
import notizverwaltung.service.interfaces.AufgabeService;
import notizverwaltung.service.interfaces.KategorieService;
import notizverwaltung.service.interfaces.NotizService;



/**
 * Die Klasse stellt ein Model-Objekt bereit
 *
 * @author Tobias Gottschalk
 * @version 1.0
 * @since
 */
public class ServiceObjectBuilder {

    public static NotizService getNotizService() throws ObjectIstNullException {
        return new NotizServiceImpl();
    }



}
