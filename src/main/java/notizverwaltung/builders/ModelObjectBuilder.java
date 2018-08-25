package notizverwaltung.builders;

import notizverwaltung.model.classes.NotizImpl;
import notizverwaltung.model.classes.NutzerprofilImpl;

import notizverwaltung.service.interfaces.KategorieService;
import notizverwaltung.service.interfaces.NotizService;
import notizverwaltung.service.interfaces.AufgabeService;

import java.io.IOException;


/**
 * Die Klasse stellt ein Model-Objekt bereit
 *
 * @author Tobias Gottschalk
 * @version 1.0
 * @since
 */
public class ModelObjectBuilder {

    public static NotizImpl getNotizObjektMinimaleParameter(String title, String beschreibung) throws IOException {
        return new NotizImpl(title,beschreibung);
    }









}
