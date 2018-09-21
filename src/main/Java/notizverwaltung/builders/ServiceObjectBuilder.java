package notizverwaltung.builders;

import notizverwaltung.exceptions.ObjectIstNullException;
import notizverwaltung.service.classes.*;
import notizverwaltung.service.interfaces.*;


/**
 * Die Klasse stellt ein Service-Objekt bereit
 *
 * @author Tobias Gottschalk
 * @author Shenna RWP
 * @version 1.0
 */
public class ServiceObjectBuilder {

    /**
     * erstelle ein NotizService-Objekt
     * @return Implementation von NotizSevice
     */
    public static NotizService getNotizService() {
        NotizService notizService = null;
        try {
            notizService = new NotizServiceImpl();
        } catch (ObjectIstNullException oe) {
            oe.printStackTrace();
        }
        return notizService;
    }

    /**
     * erstelle ein KategorieService-Objekt
     * @return Implementation von KategorieSevice
     */
    public static KategorieService getKategorieService() {
        KategorieService kategorieService = null;
        try {
            kategorieService = new KategorieServiceImpl();
        } catch (ObjectIstNullException oe) {
            oe.printStackTrace();
        }
        return kategorieService;
    }

    /**
     * erstelle ein Bearbeitungszustand-Objekt
     * @return Implementation von BearbeitungszustandSservice
     */
    public static BearbeitungszustandService getBearbeitungszustandService() {
        BearbeitungszustandService bearbeitungszustandService = null;
        try {
            bearbeitungszustandService = new BearbeitungszustandServiceImpl();
        } catch (ObjectIstNullException oe) {
            oe.printStackTrace();
        }
        return bearbeitungszustandService;
    }

    /**
     * erstelle ein NotizFXService-Objekt
     * @return Implementation von NotizFXSevice
     */
    public static NotizFXService getNotizFXService(){
        return new NotizFXServiceImpl();

    }

    /**
     * erstelle ein KategorieFXService-Objekt
     * @return Implementation von KategorieFXService
     */
    public static KategorieFXService getKategorieFXService(){
        return new KategorieFXServiceImpl();

    }

    /**
     * erstelle ein BearbeitungszustandFXService-Objekt
     * @return Implementation von BearbeitungszustandFXService
     */
    public static BearbeitungszustandFXService getBearbeitungszustandFXService(){
        return new BearbeitungszustandFXServiceImpl();

    }

    /**
     * erstelle ein NotizFilterService-Objekt
     * @return Implementation von NotizFilterSevice
     */
    public static NotizFilterService getNotizFilterService() {
        NotizFilterService notizFilterService = null;
        try {
            notizFilterService = new NotizFilterServiceImpl();
        } catch (ObjectIstNullException oe) {
            oe.printStackTrace();
        }
        return notizFilterService;
    }

    /**
     * erstelle ein NotizSortService-Objekt
     * @return Implementation von NotizSortSevice
     */
    public static NotizSortService getNotizSortService() {
        NotizSortService notizSortService = null;
        try {
            notizSortService = new NotizSortServiceImpl();
        } catch (ObjectIstNullException oe) {
            oe.printStackTrace();
        }
        return notizSortService;
    }



}
