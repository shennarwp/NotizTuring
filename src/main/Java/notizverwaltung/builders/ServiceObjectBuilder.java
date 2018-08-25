package notizverwaltung.builders;

import notizverwaltung.service.classes.NotizServiceImpl;
import notizverwaltung.service.interfaces.AufgabeService;
import notizverwaltung.service.interfaces.KategorieService;
import notizverwaltung.service.interfaces.NotizService;

public class ServiceObjectBuilder {

    public static NotizService getNotizService(){
        return new NotizServiceImpl();
    }



}
