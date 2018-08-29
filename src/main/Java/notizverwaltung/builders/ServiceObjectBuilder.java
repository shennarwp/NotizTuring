package notizverwaltung.builders;

import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.service.classes.BearbeitungszustandServiceImpl;
import notizverwaltung.service.classes.KategorieServiceImpl;
import notizverwaltung.service.classes.NotizServiceImpl;
import notizverwaltung.service.interfaces.AufgabeService;
import notizverwaltung.service.interfaces.BearbeitungszustandService;
import notizverwaltung.service.interfaces.KategorieService;
import notizverwaltung.service.interfaces.NotizService;



/**
 * Die Klasse stellt ein Service-Objekt bereit
 *
 * @author Tobias Gottschalk
 * @author Shenna RWP
 * @version 1.0
 * @since
 */
public class ServiceObjectBuilder {

    public static NotizService getNotizService() {
        NotizService notizService = null;
        try {
            notizService = new NotizServiceImpl();
        } catch (ObjectIstNullException oe) {
            oe.printStackTrace();
        }
        return notizService;
    }

    public static KategorieService getKategorieService() {
        KategorieService kategorieService = null;
        try {
            kategorieService = new KategorieServiceImpl();
        } catch (ObjectIstNullException oe) {
            oe.printStackTrace();
        }
        return kategorieService;
    }

    public static BearbeitungszustandService getBearbeitungszustandService() {
        BearbeitungszustandService bearbeitungszustandService = null;
        try {
            bearbeitungszustandService = new BearbeitungszustandServiceImpl();
        } catch (ObjectIstNullException oe) {
            oe.printStackTrace();
        }
        return bearbeitungszustandService;
    }



}
